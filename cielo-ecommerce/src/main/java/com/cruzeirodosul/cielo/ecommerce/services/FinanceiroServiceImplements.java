package com.cruzeirodosul.cielo.ecommerce.services;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;

import com.cruzeirodosul.cielo.ecommerce.dto.TransacaoDTO;
import com.cruzeirodosul.cielo.ecommerce.model.Transacao;
import com.cruzeirodosul.cielo.ecommerce.repository.FinanceiroRepository;
import com.cruzeirodosul.cielo.ecommerce.rowmapper.TransacaoRowMapper;

import oracle.jdbc.OracleTypes;

@Service
public class FinanceiroServiceImplements implements FinanceiroService {

	@Autowired
	FinanceiroRepository financeiroRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	TransacaoDTO transacaoDTO;

	@Override
	public TransacaoDTO validaTransacaoCieloEcommerce(String idTrn) throws IOException {
		String query = "select * from pagtrn where id_trn = ? ";
		Object[] inputs = new Object[] {idTrn};
		Transacao transacao = jdbcTemplate.queryForObject(query, inputs, new TransacaoRowMapper());
		
		transacaoDTO = getCredenciaisLoja(transacao);
		transacaoDTO = getConfiguracaoLoja(transacaoDTO);
		validaTransacaoCielo(idTrn);
		return transacaoDTO;
	}
	
	private TransacaoDTO getCredenciaisLoja(Transacao transacao) {
		String query = "select distinct nvl(b.loj_creden, nvl(a.loj_creden,'0')) from acd.empres a, acd.filial b"
				+ " where a.cod_empr = ? and b.cod_empr = a.cod_empr and b.cod_inst = ? ";
		Object[] inputs = new Object[] {transacao.getCodEmpr(), transacao.getCodInst()};
		
		Long lojCreden = jdbcTemplate.queryForObject(query, inputs, Long.class);
		
		transacaoDTO.setLojCreden(lojCreden);
		return transacaoDTO;
	}


	private TransacaoDTO getConfiguracaoLoja(TransacaoDTO transacaoDTO) {
		String query = "select car.loj_logo, car.loj_nome, car.loj_chave, car.mid from fin.carloja car where car.loj_creden = ? and car.loj_dta_fin > sysdate";
		Object[] inputs = new Object[] {transacaoDTO.getLojCreden()};
				
		Map<String, Object> map = jdbcTemplate.queryForMap(query, inputs);
		transacaoDTO.setLojLogo((String) map.get("LOJ_LOGO"));
		transacaoDTO.setLojNome((String) map.get("LOJ_NOME"));
		transacaoDTO.setLojChave((String) map.get("LOJ_CHAVE"));
		transacaoDTO.setMid((String) map.get("MID"));
		
		return transacaoDTO;
	}

	private void validaTransacaoCielo(String idTrn) {
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(OracleTypes.NUMBER), new SqlParameter(OracleTypes.VARCHAR), 
				new SqlOutParameter("S_EXIT_CAPT", OracleTypes.NUMBER), new SqlOutParameter("S_EXIT_PGTO", OracleTypes.NUMBER), 
				new SqlOutParameter("S_COD_ERRO", OracleTypes.NUMBER), new SqlOutParameter("S_MENSAGEM", OracleTypes.VARCHAR));
		
		Map<String, Object> map = jdbcTemplate.call(new CallableStatementCreator() {
			
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement callableStatement = con.prepareCall("{call FIN.P_VALIDA_TRANS_CIELO(?, ?, ?, ?, ?, ?)}");
		        callableStatement.setString(1, idTrn);
		        callableStatement.setString(2, "0");
		        callableStatement.registerOutParameter(3,Types.VARCHAR);
		        callableStatement.registerOutParameter(4,Types.VARCHAR);
		        callableStatement.registerOutParameter(5,Types.VARCHAR);
		        callableStatement.registerOutParameter(6,Types.VARCHAR);
				return callableStatement;
			}
		}, parameters);
		
		System.out.println(map);
		transacaoDTO.setsCodErro((String) map.get("S_COD_ERRO"));
		transacaoDTO.setsExitCapt((String) map.get("S_EXIT_CAPT"));
		transacaoDTO.setsExitPgto((String) map.get("S_EXIT_PGTO"));
		transacaoDTO.setsMensagem((String) map.get("S_MENSAGEM"));
	}
}
