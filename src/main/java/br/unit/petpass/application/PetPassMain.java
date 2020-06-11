package br.unit.petpass.application;

import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_REGISTRO;
import static br.unit.petpass.application.PetPassMainConstantes.FAZER_LOGIN;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import br.unit.petpass.controller.ClienteController;
import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Plano;
import br.unit.petpass.repository.CategoriaPetHibernateDAO;
import br.unit.petpass.repository.ClienteHibernateDAO;
import br.unit.petpass.repository.PlanoHibernateDAO;



public class PetPassMain {

	private static ClienteController clienteController = new ClienteController();
	private static CategoriaPetHibernateDAO reporCategoriaHibernate = new CategoriaPetHibernateDAO();
	private static PlanoHibernateDAO reporPlanoHibernate = new PlanoHibernateDAO();
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("-----------------------------------");
		System.out.println("------ Bem Vindo ao PETPASS! ------");
		System.out.println("-----------------------------------");
	
		int opcao = -1;
//		do  
		{
			menuInicial();
			opcao = scan.nextInt();
			
			switch (opcao) {
			case CRIAR_REGISTRO: 
				Cliente cliente = criarCliente();
				ClienteHibernateDAO.salvarCliente(cliente);
			break;
			case FAZER_LOGIN:
				
			break;
			case TERMINAR:
				System.out.println("--------------------------------------");
				System.out.println("------------Até a Próxima!------------");
				System.out.println("--------------------------------------");
				break;
			default:
				System.out.println("O sistema não reconhece esse comando. Tente novamente.");
			break;
		}

	} while (opcao != TERMINAR)


//			System.out.println("------Opção Inválida------");
		
		System.out.println("Testando git bash e git hub");
		
		
//		geraInsertsCategoriaPet();  // Pode alterar os valores da Categoria dentro do metodo mais abaixo

//		List<CategoriaPet> listaDeCategoriaPet = reporCategoriaHibernate.listarTodos();
//		for (CategoriaPet categorias : listaDeCategoriaPet) {
//			System.out.println(categorias);
//		}
//		
//		CategoriaPet categoriaX = reporCategoriaHibernate.findById(5);
//		System.out.println(categoriaX);
		
		geraInsertsPlano(); //Faz os inserts no banco, pode alterar valores nas linhas a baixo dentro do metodo
		
		System.out.println("Listar todos os planos:");
		List<Plano> planos = reporPlanoHibernate.listAll(); // Testar o listAll para os Planos depois de fazer os inserts
		for (Plano plano : planos) {
			System.out.println(plano);
		}
		
		System.out.println("Consultar 1 plano pelo id (codigo):");
		Plano plano = reporPlanoHibernate.findById(2);
		System.out.println(plano);
		
		System.out.println("Atualizar Preço do Plano");
		reporPlanoHibernate.updatePriceOfPlan(3, 450.0);
		
		System.out.println("Atualizar Nome do Plano");
		reporPlanoHibernate.updatePlanName(1, "PetPass Basic");
		
		System.out.println("Atualizar Pacote Inical de Credito do Plano");
		reporPlanoHibernate.updatePriceOfPlan(3, 450.0);
		
		System.out.println("Atualizar Status do Plano (1/0)");
		reporPlanoHibernate.updatePlanStatus(1, 0);
		
		
		reporPlanoHibernate.deleteById(4);
		
		for (Plano p : planos) {
			System.out.println(p);
		}
	}
	
	private static void menuInicial(){
		System.out.println("------ Selecione o seu Login!------");
		System.out.println("[1] - Criar Registro");
		System.out.println("[2] - Fazer Login");
		System.out.println("[100] - Terminar Programa");

	}
	
		private static Cliente criarCliente() {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Digite seu nome");
			String nome = scan.next();
			
			System.out.println("Digite seu CPF");
			String cpf = scan.next();
				
			System.out.println("Digite seu email");
			String email = scan.next();
			
			System.out.println("Digite seu RG");
			String rg = scan.next();
			
			System.out.println("Digite seu telefone");
			String telefone = scan.next();

			System.out.println("Digite seu Endereço");
			String endereco = scan.next();

			System.out.println("Digite sua Data de Nascimento (dd/mm/aaaa)");
			String data = scan.next();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dtNascimento = LocalDate.parse(data, dateFormat);
			
			System.out.println("Digite F para gênero feminino, e M para gênero masculino");
			Character sexo = scan.next().charAt(0);
			

			Cliente cliente = new Cliente(null, cpf, nome, rg, telefone, email, endereco, dtNascimento, sexo, statusCliente);
			return cliente;
		}
	
	public static void geraInsertsCategoriaPet() {
		
		CategoriaPet categoria1 = new CategoriaPet(1, "Gato");
		reporCategoriaHibernate.salvar(categoria1);

		CategoriaPet categoria2 = new CategoriaPet(2, "Ave");
		reporCategoriaHibernate.salvar(categoria2);

		CategoriaPet categoria3 = new CategoriaPet(3, "Réptil");
		reporCategoriaHibernate.salvar(categoria3);

	}
	
	public static void geraInsertsPlano() {
		
		Plano plano1 = new Plano(1, "PetPass", 100.0, 100, 1);
		reporPlanoHibernate.salvar(plano1);
		
		Plano plano2 = new Plano(2, "PetPass Plus", 200.0, 200, 1);
		reporPlanoHibernate.salvar(plano2);
		
		Plano plano3 = new Plano(3, "PetPass Gold", 300.0, 300, 1);
		reporPlanoHibernate.salvar(plano3);
		
		Plano plano4 = new Plano(4, "PetPass Deluxe", 500.0, 500, 1);
		reporPlanoHibernate.salvar(plano4);
	}

}
