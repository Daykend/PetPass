package br.unit.petpass.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.exception.ClienteException;
import br.unit.petpass.repository.ClienteHibernateDAO;


public class ClienteController {

	private ClienteHibernateDAO clienteHibernateDAO;

	public ClienteController() {
		clienteHibernateDAO = new ClienteHibernateDAO();
	}

	public boolean salvarCliente(Cliente cliente) {
		String clienteCPFCadastrado = cliente.getCpf();
		Period period = Period.between(LocalDate.now(), cliente.getDtNascimento());
		
		if (clienteCPFCadastrado != null) {
			throw new ClienteException("Já! cadastrado!");
		}
		
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
	
	public List<Cliente> getAllClients(Integer codigoCliente) {
		return clienteHibernateDAO.getAllClients(codigoCliente);
	}
	
	
	/*
	 * public boolean inserir(Cliente cliente) { String numero =
	 * Conta.gerarNumero(); conta.setNumero(numero);
	 * 
	 * if (contaValidador.validaContaInserir(conta)) {
	 * 
	 * String senhaHash = SenhaUtil.geraHash(conta.getSenha());
	 * conta.setSenha(senhaHash);
	 * 
	 * clienteController.inserir(conta.getCliente()); contaDao.inserir(conta);
	 * 
	 * return true; } return false; }
	 */
	
	public boolean inserir(Cliente cliente) {
		String contaValida = Cliente.numeroCadastro();
		
		if (contaValida != null) {		
			return true;
		}
		return false;
	}
	
}	