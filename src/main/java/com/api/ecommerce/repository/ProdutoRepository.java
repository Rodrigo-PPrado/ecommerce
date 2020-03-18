package com.api.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);

}
