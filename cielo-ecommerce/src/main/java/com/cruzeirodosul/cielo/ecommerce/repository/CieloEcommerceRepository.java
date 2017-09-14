package com.cruzeirodosul.cielo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cruzeirodosul.cielo.ecommerce.sdk.Sale;

@Repository
public interface CieloEcommerceRepository extends JpaRepository<Sale, Integer>{

}
