package com.api.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findById(long id);

}
