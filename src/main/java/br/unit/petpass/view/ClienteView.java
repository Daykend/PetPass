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
import br.unit.petpass.controller.ContratoController;
import br.unit.petpass.controller.ServicosController;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Servicos;
import br.unit.petpass.exception.ClienteException;

public class ClienteView {

	Scanner scan = new Scanner(System.in);
	
	public void criarCliente() {
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

		Cliente cliente = new Cliente(null, cpf, nome, rg, telefone, email, endereco, dtNascimento, sexo, null , null);
		clienteController.salvarCliente(cliente);

	}
	
	public void listarCLiente() {
		new ClienteController();

		java.util.List<Cliente> clientes = ClienteController.getAllClients();

		for (Cliente cliente : clientes) {
			System.out.println(cliente.getCodigoCliente() + " || " + cliente.getNome() + " || " + cliente.getEmail());
		}
	}

	public void atualizarCliente() {
		ClienteController clienteController = new ClienteController();
		Cliente cliente = new Cliente();

		System.out.println("Digite o código do Cliente a ser modificado:");
		int codigoCliente = scan.nextInt();
		cliente = clienteController.getClientById(codigoCliente);
		scan.nextLine();
		
		int menu = -1;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("O que deseja modificar? Escolha uma opção:");
			System.out.println("[1] Nome, [2] CPF, [3] email, [4] RG, [5] Telefone,"
					+ "[6] Endereço, [7] Data de Nascimento, [8] Voltar Menu [100] Sair");
			menu = scan.nextInt();

			switch (menu) {

			case 1:
				scan.nextLine();
				System.out.println("Digite o nome novo:");
				String nome = scan.nextLine();
				cliente.setNome(nome);

				clienteController.updateCliente(cliente);;
				System.out.println("Alteração realizada");

				break;

			case 2:
				scan.nextLine();
				System.out.println("Digite o CPF novo:");
				String cpf = scan.nextLine();
				cliente.setCpf(cpf);

				clienteController.updateCliente(cliente);;
				System.out.println("Alteração realizada");

				break;

			case 3:
				scan.nextLine();
				System.out.println("Digite o email novo:");
				String email = scan.nextLine();
				cliente.setEmail(email);

				clienteController.updateCliente(cliente);
				System.out.println("Alteração realizada");

				break;
				
			case 4:
				scan.nextLine();
				System.out.println("Digite o RG novo:");
				String rg = scan.nextLine();
				cliente.setRg(rg);

				clienteController.updateCliente(cliente);
				System.out.println("Alteração realizada");

				break;
				
			case 5:
				scan.nextLine();
				System.out.println("Digite o telefone novo:");
				String telefone = scan.nextLine();
				cliente.setTelefone(telefone);

				clienteController.updateCliente(cliente);
				System.out.println("Alteração realizada");

				break;
				
			case 6:
				scan.nextLine();
				System.out.println("Digite o endereço novo:");
				String endereco = scan.nextLine();
				cliente.setEndereco(endereco);

				clienteController.updateCliente(cliente);
				System.out.println("Alteração realizada");

				break;
				
			case 7:
				scan.nextLine();
				System.out.println("Digite a nova data de nascimento (dd/mm/yyyy):");
				String data = scan.nextLine();
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dtNascimento = LocalDate.parse(data, dateFormat);
				try {
					dtNascimento = LocalDate.parse(data, dateFormat);
				} catch (Exception e) {
					throw new ClienteException("Data inválida");
				}
				cliente.setDtNascimento(dtNascimento);

				clienteController.updateCliente(cliente);
				System.out.println("Alteração realizada");

				break;
			case 8:
				menuCliente();
				break;
				
			case TERMINAR:
				System.out.println("--------------------------------------");
				System.out.println("------------Até a Próxima!------------");
				System.out.println("--------------------------------------");
				System.exit(0);

			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while (menu != TERMINAR);
		scan.close();
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
	
	/* Funcao para bonificar o cliente */
	public void bonificarCliente() {
		
		ClienteController clienteController = new ClienteController();
		
	        /* Carregando o cliente */
	        System.out.println("Qual o código do cliente?");
	        int cliente_id =  scan.nextInt();
	        Cliente cliente = new Cliente();
	        cliente = clienteController.getClientById(cliente_id);
	       
	        System.out.println("Cliente " + cliente.getNome() + " carregado com sucesso");
	        System.out.println("Data de nascimento: " + cliente.getDtNascimento());
	        System.out.println();
	 
	        /* Comparando a dt de nascimento do cliente */
	        int diaNascimento = cliente.getDtNascimento().getDayOfMonth();
	        int mesNascimento = cliente.getDtNascimento().getMonthValue();
	       
	        LocalDate hoje = LocalDate.now();
	        int hojeDia = hoje.getDayOfMonth();
	        int hojeMes = hoje.getMonthValue();
	       
	        /* Comparando o dia/mes para saber se está fazendo aniversário hoje */
	        if( diaNascimento == hojeDia &&
	            mesNascimento == hojeMes) {
	            System.out.println("Parabéns! Hoje é seu aniversário");
	            System.out.println("você será bonificado com um bônus de 30 créditos.");
	 
	            // carregando o contrato
	            ContratoController contratoController = new ContratoController();
	            //Contrato contrato = contratoController.getContratoById(cliente.getContrato().getCodigoContrato());
	            Contrato contrato = cliente.getContrato();
	           
	            int saldoFinal = contrato.getSaldoFinal();
	            System.out.println("Saldo antigo: " + saldoFinal );
	            saldoFinal += 30;
	            System.out.println("Saldo atual: " + saldoFinal);
	            System.out.println("\n");
	            System.out.println("salvando novo saldo final...");
	           
	            contrato.setSaldoFinal( (short) saldoFinal );
	            contratoController.updateContrato( contrato );
	            System.out.println("\n");
	           
	        }else {
	            System.out.println("Bem vindo! Hoje *ainda* não é seu aniversário");
	        }
	       
	}

	
	public void menuCliente() {
		
		Scanner scan = new Scanner(System.in);
		
		int menu = -1;
		do {
			
			System.out.println("Bem vindo(a) as opções de Cliente. Você gostaria de:");
			System.out.println("[1] - Criar Cadastro de Cliente");
			System.out.println("[2] - Editar Cadastro de Cliente");
			System.out.println("[3] - Deletar Cadastro de Clientes");
			System.out.println("[4] - Mostrar Cadastros");
			System.out.println("[5] - Verificar bonificação");
			System.out.println("[100] - Sair");
			
			menu = scan.nextInt();
			
			switch (menu)  {
			case CRIAR_CADASTRO:
				criarCliente();
				break;
			case ALTERAR_CADASTRO:
				atualizarCliente();
				break;
			case MOSTRAR_CADASTROS:
				listarCLiente();
				break;
			case DELETAR_CADASTRO:
				deletarCliente();
				break;
			case 5:
				bonificarCliente();
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

