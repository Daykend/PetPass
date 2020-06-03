package br.unit.petpass.application;

import java.util.List;
import java.util.Scanner;

import br.unit.petpass.controller.ClienteController;
import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Plano;
import br.unit.petpass.repository.CategoriaPetHibernate;
import br.unit.petpass.repository.PlanoHibernate;

public class PetPassMain {
	private static ClienteController clienteController = new ClienteController();
	private static CategoriaPetHibernate reporCategoriaHibernate = new CategoriaPetHibernate();
	private static PlanoHibernate reporPlanoHibernate = new PlanoHibernate();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int escolhaDeMenu;
		System.out.println("-----------------------------------");
		System.out.println("------ Bem Vindo ao PETPASS! ------");
		System.out.println("-----------------------------------");
		System.out.println("------ Selecione o seu Login!------");
		System.out.println("[1] - Criar Registro");
		System.out.println("[2] - Fazer Login");
		escolhaDeMenu = scan.nextInt();
		
		if (escolhaDeMenu == 1) {
			
			System.out.println("Por favor, preencha os campos a seguir");
			System.out.println("Nome:");
			
			System.out.println("Por favor, preencha os campos a seguir");
			System.out.println("Nome:");
			
		} if (escolhaDeMenu == 2) {
			
			
			
		} else {
			System.out.println("------Opção Inválida------");
		}
		
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
		
		System.out.println("Atualizar Status do Plano (true/false)");
		reporPlanoHibernate.updatePlanStatus(1, false);
		
		
		reporPlanoHibernate.deleteById(4);
		
		for (Plano p : planos) {
			System.out.println(p);
		}
		
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
		
		Plano plano1 = new Plano(1, "PetPass", 100.0, 100, true);
		reporPlanoHibernate.salvar(plano1);
		
		Plano plano2 = new Plano(2, "PetPass Plus", 200.0, 200, true);
		reporPlanoHibernate.salvar(plano2);
		
		Plano plano3 = new Plano(3, "PetPass Gold", 300.0, 300, true);
		reporPlanoHibernate.salvar(plano3);
		
		Plano plano4 = new Plano(4, "PetPass Deluxe", 500.0, 500, true);
		reporPlanoHibernate.salvar(plano4);
	}

}
