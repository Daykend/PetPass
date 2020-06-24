package br.unit.petpass.view;

import static br.unit.petpass.application.PetPassMainConstantes.ALTERAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.DELETAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.MOSTRAR_CADASTROS;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.unit.petpass.application.PetPassMain;
import br.unit.petpass.controller.CategoriaPetController;
import br.unit.petpass.controller.ClienteController;
import br.unit.petpass.controller.ContratoController;
import br.unit.petpass.controller.PetController;
import br.unit.petpass.controller.RacaController;
import br.unit.petpass.controller.ServicosController;
import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Pet;
import br.unit.petpass.entities.Raca;
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
		
		int bonificacao = 0;

		System.out.println("Cadastro de Cliente concluido. Você Voltará ao menu inicial!");

		Cliente cliente = new Cliente(null, cpf, nome, rg, telefone, email, endereco, dtNascimento, sexo, bonificacao, null , null);
		clienteController.salvarCliente(cliente);

	}
	
	public void listarCLiente() {
		new ClienteController();

		java.util.List<Cliente> clientes = ClienteController.getAllClients();

		for (Cliente cliente : clientes) {
			System.out.println(cliente.getCodigoCliente() + "||" + cliente.getCpf() + " || " + cliente.getNome() +
					" || " + cliente.getEmail() + " || " + cliente.getTelefone());
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
	
	public void verificaSaldo() {
		ClienteController clienteController = new ClienteController();
		ContratoController contratoController = new ContratoController();
		Contrato contrato = new Contrato();
		
		System.out.println("Digite o código do Contrato a ser consultado:");
		int codigoContrato = scan.nextInt();
		contrato = contratoController.getContratoById(codigoContrato);
		scan.nextLine();

		ServicosController servicosController = new ServicosController();
		
		
		java.util.List<Servicos> servicos2 =  servicosController.listAll();

		for (Servicos servico : servicos2) {
			System.out.println(servico.getCodigoServicos() + " || " + servico.getNome());
			}

		Servicos servicos = new Servicos();
		System.out.println("Qual serviço? Digite o código:");
		int codigoServicos = scan.nextInt();
		servicos = servicosController.getServicos(codigoServicos);
		scan.nextLine();
		
		clienteController.verificaSaldoServico(contrato, servicos);
		
	}
	
	public void bonificarCliente() {
	
	ClienteController clienteController = new ClienteController();
	
        System.out.println("Qual o código do cliente?");
        int codigoCliente =  scan.nextInt();
        Cliente cliente = new Cliente();
        cliente = clienteController.getClientById(codigoCliente);
        
        clienteController.bonificacaoAniversario(cliente);
        
	}
	
	
	public void cadastrarPet() {
		
		System.out.print("Qual o codigo do cliente? ");
		int cliente_id = scan.nextInt();
		
		ClienteController clienteController = new ClienteController();
		Cliente cliente = clienteController.getClientById(cliente_id);
		System.out.println("Cliente " + cliente.getNome() + " selecionado");
		
		PetController petController = new PetController();
		System.out.println("Digite o nome do Pet");
		String nome = scan.next();
		
		System.out.println("Digite a Data de Nascimento (dd/mm/aaaa)");
		String data = scan.next();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dtNascimentoPet = LocalDate.parse(data, dateFormat);
		try {
			dtNascimentoPet = LocalDate.parse(data, dateFormat);
		} catch (Exception e) {
			throw new ClienteException("Data inválida");
		}
		
		System.out.println("Digite o genero do Pet");
		String sexoPet = scan.next();
		
		
		RacaController racaController = new RacaController();
		
		java.util.List<Raca> racas =  racaController.getAllRacas(); 

		for (Raca raca : racas) {
			System.out.println(raca.getCodigoRaca() + " || " + raca.getNomeRaca());
			}
		
		System.out.println("\n");
		System.out.println("Qual o código da raça?");
		int codigoRaca = scan.nextInt();
		
		Raca raca2 = racaController.getRacaById(codigoRaca);
		int statusPet = 1;
		
		Pet pet = new Pet(null, nome, dtNascimentoPet, sexoPet, statusPet, cliente, raca2);
		petController.inserirPet(pet);
			
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
			System.out.println("[5] - Verificar se cliente tem saldo para realizar serviço");
			System.out.println("[6] - Verificar bonificação");
			System.out.println("[7] - Cadastrar pet com verificação");
			System.out.println("[100] - Sair");
			
			menu = scan.nextInt();
			
			switch (menu)  {
			case 1:
				criarCliente();
				break;
			case 2:
				atualizarCliente();
				break;
			case 3:
				listarCLiente();
				break;
			case 4:
				deletarCliente();
				break;
				
			case 5:
				verificaSaldo();
				break;
				
			case 6:
				bonificarCliente();
				break;
				
			case 7:
				cadastrarPet();
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

