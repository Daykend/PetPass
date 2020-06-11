package br.unit.petpass.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.repository.ClienteHibernate;

public class ClienteController {

	private ClienteHibernate clienteHibernate;
	
	public ClienteController() {
		clienteHibernate = new ClienteHibernate();
	}

	public boolean salvarCliente(Cliente cliente) {
		clienteHibernate.salvarCliente(cliente);
		return true;
	}

	public void updateCliente(Cliente cliente) {
		clienteHibernate.updateCliente(cliente);
	}

	public Cliente getClientById(Integer codigoCliente) {
		return clienteHibernate.getClientById(codigoCliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllClients(Integer codigoCliente) {
		return clienteHibernate.getAllClients(codigoCliente);
	}

	public void confirmarIdade(Cliente cliente) {
		Period period = Period.between(LocalDate.now(), cliente.getDtNascimento());

		if (period.getYears() < 18) {
			throw new RuntimeException("Não é possível cadastrar clientes menores de 18 anos");
		}
		
		clienteHibernate.salvarCliente(cliente);
	}
}	
	/*
	 * public boolean confirmar(Cliente cliente) { if (email = unique) {
	 * 
	 * clienteHibernate.salvarCliente(cliente);
	 * 
	 * return true; } return false; }
	 * 
	 * }
	 */
