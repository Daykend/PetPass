package br.unit.petpass.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Servicos;
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

	public static List<Cliente> getAllClients() {
		return clienteHibernateDAO.getAllClients();
	}
		
	public void deletarCliente(Cliente cliente) {
		clienteHibernateDAO.deletarCliente(cliente);
	}
	
	public void bonificacaoAniversario(Cliente cliente) {
		System.out.println("\n");
        System.out.println("Cliente " + cliente.getNome() + " carregado com sucesso");
        System.out.println("Data de nascimento: " + cliente.getDtNascimento());
        System.out.println();
 
        int diaNascimento = cliente.getDtNascimento().getDayOfMonth();
        int mesNascimento = cliente.getDtNascimento().getMonthValue();
       
        LocalDate hoje = LocalDate.now();
        int diaHoje = hoje.getDayOfMonth();
        int mesHoje = hoje.getMonthValue();
       

        if( diaNascimento == diaHoje &&
            mesNascimento == mesHoje && cliente.getBonificacao() == 0) {
            System.out.println("Parabéns! Hoje é seu aniversário");
            System.out.println("Você será bonificado com 20 créditos.");

            ContratoController contratoController = new ContratoController();
            Contrato contrato = cliente.getContrato();
           
            short saldoFinal = contrato.getSaldoFinal();
            System.out.println("Saldo antigo: " + saldoFinal );
            saldoFinal += 20;
            System.out.println("Saldo atual: " + saldoFinal);
            System.out.println("\n");
           
            contrato.setSaldoFinal(saldoFinal);
            contratoController.updateContrato( contrato );
            System.out.println("\n");
            
            ClienteController clienteController = new ClienteController();
            cliente.setBonificacao(1);
            clienteController.updateCliente(cliente);
            
           
        }else {
            System.out.println("Bem vindo! Você não tem direito a bonificação!");
            System.out.println("\n");
        }
       
		
	}
	
	public void verificaSaldoServico(Contrato contrato, Servicos servicos) {
		Short c1 = contrato.getSaldoFinal();
		Integer c2 = servicos.getCustoCredito();
		System.out.println("Serviço escolhido: " + servicos.getNome() + " Valor: " + servicos.getCustoCredito());
		System.out.println("Saldo do contrato: " + contrato.getSaldoFinal());

		if (c1 > c2) {
			System.out.println("Cliente pode realizar serviço");
			System.out.println("\n");
		} else {
			System.out.println("Saldo insuficiente! Cliente NÃO pode realizar serviço");
			System.out.println("\n");
		}
		
	}
	
	public Cliente getClientById(Integer codigoCliente) {
		return clienteHibernateDAO.getClientById(codigoCliente);
	}
	
	
}	