package com.api.ecommerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.ecommerce.model.Compra;
import com.api.ecommerce.repository.CompraRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/ecommerce")
@Api(value="API REST - Área de Compras")
@CrossOrigin(origins = "*")
public class CompraResource {
	
	@Autowired
	CompraRepository compraRepository;
	
	@GetMapping("/listarCompras")
	@ApiOperation(value="Retorna a lista de todas compras do banco de dados")
	public List<Compra> listaCompras(){
		return compraRepository.findAll();
	}
	
	@GetMapping("/listarCompra/{id}")
	@ApiOperation(value="Retorna uma compra única com base no ID informado")
	public List<Compra> listaCompraUnica(@PathVariable(value="id") long id){
		return compraRepository.findById(id);
	}

	@PostMapping("/comprar")
	@ApiOperation(value="Realiza o cadastro de uma nova compra")
	public Compra realizaCompra(@RequestBody Compra compra) {
		return compraRepository.save(compra);
	}
	
}
