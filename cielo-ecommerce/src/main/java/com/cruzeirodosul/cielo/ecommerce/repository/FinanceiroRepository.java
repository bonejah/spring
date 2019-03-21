package com.cruzeirodosul.cielo.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cruzeirodosul.cielo.ecommerce.model.Transacao;

@Repository
@Transactional
public interface FinanceiroRepository extends CrudRepository<Transacao, Integer>{

}
