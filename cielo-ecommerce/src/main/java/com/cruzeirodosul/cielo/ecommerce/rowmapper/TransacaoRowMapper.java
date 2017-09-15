package com.cruzeirodosul.cielo.ecommerce.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cruzeirodosul.cielo.ecommerce.model.Transacao;

public class TransacaoRowMapper implements RowMapper<Transacao> {
	@Override
	public Transacao mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transacao transacao = new Transacao();
		transacao.setIdTrn(rs.getLong("ID_TRN"));
		transacao.setTid(rs.getString("TID"));
		transacao.setLocPgto(rs.getInt("LOC_PGTO"));
		transacao.setDtTrn(rs.getDate("DT_TRN"));
		transacao.setTrnModal(rs.getString("TRN_MODAL"));
		transacao.setTrnTotPar(rs.getInt("TRN_TOT_PAR"));
		transacao.setTrnValTot(rs.getBigDecimal("TRN_VAL_TOT"));
		transacao.setTrnProduto(rs.getString("TRN_PRODUTO"));
		transacao.setTrnNome(rs.getString("TRN_NOME"));
		transacao.setCodEmpr(rs.getInt("COD_EMPR"));
		transacao.setCodInst(rs.getInt("COD_INST"));
		transacao.setTrnCodban(rs.getInt("TRN_CODBAN"));
		return transacao;
	}
}	
