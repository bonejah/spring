package com.cruzeirodosul.cielo.ecommerce.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cruzeirodosul.cielo.ecommerce.dto.TransacaoDTO;

public class TransacaoDTORowMapper implements RowMapper<TransacaoDTO> {
	@Override
	public TransacaoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TransacaoDTO transacaoDTO = new TransacaoDTO();
		transacaoDTO.setLojCreden(rs.getLong("LOJ_CREDEN"));
		transacaoDTO.setLojChave(rs.getString("LOJ_CHAVE"));
		transacaoDTO.setLojLogo(rs.getString("LOJ_LOGO"));
		transacaoDTO.setLojNome(rs.getString("LOJ_NOME"));
		transacaoDTO.setMid(rs.getString("MID"));
		return transacaoDTO;
	}
}
