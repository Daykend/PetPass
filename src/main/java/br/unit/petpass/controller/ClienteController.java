package br.unit.petpass.controller;

import java.time.LocalDate;
import java.time.Period;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.repository.ClienteHibernateDAO;

public class ClienteController {

	private ClienteHibernateDAO clienteHibernateDAO;

	public ClienteController() {
		clienteHibernateDAO = new ClienteHibernateDAO();
	}

	public void inserir(Cliente cliente) {
		Period period = Period.between(LocalDate.now(), cliente.getDtNascimento());

		if (period.getYears() < 18) {
			throw new RuntimeException("Não é possível cadastrar clientes menores de 18 anos");
		}
		
		clienteHibernateDAO.salvar(cliente);
	}

}
