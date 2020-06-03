package br.unit.petpass.controller;

import java.time.LocalDate;
import java.time.Period;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.repository.ClienteHibernate;

public class ClienteController {

	private ClienteHibernate clienteHibernate;

	public ClienteController() {
		clienteHibernate = new ClienteHibernate();
	}

	public void inserir(Cliente cliente) {
		Period period = Period.between(LocalDate.now(), cliente.getDtNascimento());

		if (period.getYears() < 18) {
			throw new RuntimeException("Não é possível cadastrar clientes menores de 18 anos");
		}
		
		clienteHibernate.salvar(cliente);
	}

}
