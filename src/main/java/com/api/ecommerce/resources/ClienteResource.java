package com.api.ecommerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.model.Cliente;
import com.api.ecommerce.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/ecommerce")
@Api(value="API REST - Área de Compras")
@CrossOrigin(origins = "*")
public class ClienteResource {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/listarClientes")
	@ApiOperation(value="Retorna a lista de todos clientes do banco de dados")
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/listarCliente/{id}")
	@ApiOperation(value="Retorna os dados de um cliente único com base no ID informado")
	public Cliente listaClienteUnico(@PathVariable(value="id") long id) {
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/cadastrarCliente")
	@ApiOperation(value="Realiza o cadastro de um novo cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/deletarCliente")
	@ApiOperation(value="Deleta o registro de um cliente")
	public void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	@PutMapping("/atualizarCliente")
	@ApiOperation(value="Atualiza o registro de um cliente se o mesmo já existir ou cria um novo caso não exista")
	public Cliente atualizaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
}
