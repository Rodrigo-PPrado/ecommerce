package com.api.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.ecommerce.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{
	
	List<Compra> findById(long id);
	
}
