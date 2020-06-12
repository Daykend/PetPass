package br.unit.petpass.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.repository.ClienteHibernateDAO;
import br.unit.petpass.exception.ClienteException;


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
	
	public static void aniversario(Cliente cliente) {
	    
	    LocalDate dtNascimento = cliente.getDtNascimento();  
	    
	    if (dtNascimento.equals(LocalDate.now())){
	    	System.out.println("A Equipe PETPASS te deseja um feliz aniversário!"); 
	    } 
	    if (!cliente.getSexo().equals("F") && !cliente.getSexo().equals("M")) {
			throw new ClienteException("Digite 'm' ou 'f'");
		}
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