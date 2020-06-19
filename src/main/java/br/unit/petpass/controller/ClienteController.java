package br.unit.petpass.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.repository.ClienteHibernateDAO;


public class ClienteController {

	private static ClienteHibernateDAO clienteHibernateDAO;

	public ClienteController() {
		clienteHibernateDAO = new ClienteHibernateDAO();
	}

	public boolean salvarCliente(Cliente cliente) {

		Period period = Period.between(cliente.getDtNascimento(), LocalDate.now());

		if (period.getYears() < 18) {
			throw new RuntimeException("Não é possível cadastrar clientes menores de 18 anos");
		}
		clienteHibernateDAO.salvarCliente(cliente);
		return true;
	}

	public void updateCliente(Cliente cliente) {
		clienteHibernateDAO.updateCliente(cliente);
	}

	public Cliente getClientById(Integer codigoCliente) {
		return clienteHibernateDAO.getClientById(codigoCliente);
	}
	
	public static List<Cliente> getAllClients() {
		return clienteHibernateDAO.getAllClients();
	}
		
	
	public void deletarCliente(Cliente cliente) {

		clienteHibernateDAO.deletarCliente(cliente);
	}
	
}	