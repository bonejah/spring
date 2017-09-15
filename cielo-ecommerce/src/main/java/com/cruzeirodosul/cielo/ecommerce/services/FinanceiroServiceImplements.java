package com.cruzeirodosul.cielo.ecommerce.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cruzeirodosul.cielo.ecommerce.model.Transacao;
import com.cruzeirodosul.cielo.ecommerce.repository.FinanceiroRepository;
import com.cruzeirodosul.cielo.ecommerce.rowmapper.TransacaoRowMapper;

@Service
public class FinanceiroServiceImplements implements FinanceiroService {

	@Autowired
	FinanceiroRepository financeiroRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Transacao consultaTransacao(String idTrn) throws IOException {
		return jdbcTemplate.queryForObject("select * from pagtrn where id_trn = ?", new Object[]{idTrn}, new TransacaoRowMapper());
	}
}
