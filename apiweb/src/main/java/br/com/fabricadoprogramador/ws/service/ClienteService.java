package br.com.fabricadoprogramador.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadoprogramador.ws.model.Cliente;
import br.com.fabricadoprogramador.ws.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Collection<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}

	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	public Cliente buscaPorId(Integer id) {
		return clienteRepository.findOne(id);
	}

	public Cliente alterar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
