package br.unit.petpass.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.repository.ClienteHibernateDAO;

public class ClienteController {

	private ClienteHibernateDAO clienteHibernateDAO;

	public ClienteController() {
		clienteHibernateDAO = new ClienteHibernateDAO();
	}

	public boolean salvarCliente(Cliente cliente) {
		clienteHibernateDAO.salvarCliente(cliente);
		return true;
	}

	public void updateCliente(Cliente cliente) {
		clienteHibernateDAO.updateCliente(cliente);
	}

	public Cliente getClientById(Integer codigoCliente) {
		return clienteHibernateDAO.getClientById(codigoCliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllClients(Integer codigoCliente) {
		return clienteHibernateDAO.getAllClients(codigoCliente);
	}

	public void confirmarIdade(Cliente cliente) {
		Period period = Period.between(LocalDate.now(), cliente.getDtNascimento());

		if (period.getYears() < 18) {
			throw new RuntimeException("Não é possível cadastrar clientes menores de 18 anos");
		}
		clienteHibernateDAO.salvarCliente(cliente);
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
