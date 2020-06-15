package br.unit.petpass.view;

import static br.unit.petpass.application.PetPassMainConstantes.ALTERAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.DELETAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.MOSTRAR_CADASTROS;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.unit.petpass.controller.ClienteController;
import br.unit.petpass.controller.PlanoController;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Plano;
import br.unit.petpass.exception.ClienteException;

public class ClienteView {
	ClienteController clienteController = new ClienteController();
	Scanner scan = new Scanner(System.in);
	
	public static Cliente criarCliente() {
		ClienteController clienteController = new ClienteController();
		Scanner scan = new Scanner(System.in);

		System.out.println("Digite seu nome");
		String nome = scan.nextLine();

		System.out.println("Digite seu CPF");
		String cpf = scan.next();

		System.out.println("Digite seu email");
		String email = scan.next();

		System.out.println("Digite seu RG");
		String rg = scan.next();

		System.out.println("Digite seu telefone");
		String telefone = scan.next();

		scan.nextLine();
		System.out.println("Digite seu Endereço");
		String endereco = scan.nextLine();

		System.out.println("Digite sua Data de Nascimento (dd/mm/aaaa)");
		String data = scan.next();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dtNascimento = LocalDate.parse(data, dateFormat);
		try {
			dtNascimento = LocalDate.parse(data, dateFormat);
		} catch (Exception e) {
			throw new ClienteException("Data inválida");
		}

		System.out.println("Digite F para gênero feminino, e M para gênero masculino");
		String sexo = scan.next();

		System.out.println("Cadastro de Cliente concluido. Você Voltará ao menu inicial!");

		Cliente cliente = new Cliente(null, cpf, nome, rg, telefone, email, endereco, dtNascimento, sexo);
		clienteController.salvarCliente(cliente);
		return cliente;
	}
	
	public static void listarCLiente() {
		new ClienteController();

		java.util.List<Cliente> clientes = ClienteController.getAllClients();

		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

	public void atualizarCliente() {
		ClienteController clienteController = new ClienteController();
		Cliente cliente = new Cliente();

		System.out.println("Digite o código do Cliente a ser modificado:");
		int codigoCliente = scan.nextInt();
		cliente = clienteController.getClientById(codigoCliente);
		scan.nextLine();

		System.out.println("Digite o nome novo do Cliente:");
		String nome = scan.nextLine();
		cliente.setNome(nome);

		clienteController.updateCliente(cliente);
		System.out.println("Alteração realizada");
	}

	public void deletarCliente() {

		ClienteController clienteController = new ClienteController();
		Cliente cliente = new Cliente();

		System.out.println("Digite o código do Cliente que deseja deletar:");
		Integer codigoCliente = scan.nextInt();

		cliente = clienteController.getClientById(codigoCliente);
		clienteController.deletarCliente(cliente);
		System.out.println("Cliente " + cliente + " deletado!");
	}
	
	public static void menuCliente() {
		
		Scanner scan = new Scanner(System.in);
		ClienteController clienteController = new ClienteController();
		Cliente cliente = new Cliente();
		
		int menu = -1;
		do {
			
			System.out.println("Bem vindo(a) as opções de Cliente. Você gostaria de:");
			System.out.println("[1] - Criar Cadastro de Cliente");
			System.out.println("[2] - Editar Cadastro de Cliente");
			System.out.println("[3] - Listar Cadastro de Clientes");
			System.out.println("[4] - Deletar Cadastro de Cliente");
			
			menu = scan.nextInt();
			
			switch (menu)  {
			case CRIAR_CADASTRO:
				criarCliente();
				clienteController.salvarCliente(cliente);
				break;
			case ALTERAR_CADASTRO:
				clienteController.updateCliente(cliente);
				break;
			case MOSTRAR_CADASTROS:
				listarCLiente();
				break;
			case DELETAR_CADASTRO:
				clienteController.deletarCliente(cliente);
				break;				
			case TERMINAR:
				System.out.println("--------------------------------------");
				System.out.println("------------Até a Próxima!------------");
				System.out.println("--------------------------------------");
				System.exit(0);

			default:
				System.out.println("O sistema não reconhece esse comando. Tente novamente.");
				break;
			}  
			
	} while (menu != TERMINAR);
		scan.close();
	}
}

