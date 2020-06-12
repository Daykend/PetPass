package br.unit.petpass.application;

import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_REGISTRO;
import static br.unit.petpass.application.PetPassMainConstantes.ALTERAR_CADASTRO;
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
import br.unit.petpass.repository.PlanoHibernateDAO;



public class PetPassMain {

	@SuppressWarnings("unused")
	private static ClienteController clienteControllerDAO = new ClienteController();
	private static CategoriaPetHibernateDAO reporCategoriaHibernate = new CategoriaPetHibernateDAO();
	private static PlanoHibernateDAO reporPlanoHibernate = new PlanoHibernateDAO();
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("-----------------------------------");
		System.out.println("------ Bem Vindo ao PETPASS! ------");
		System.out.println("-----------------------------------");
		System.out.println();
	
		int opcao = -1;
		do {
			menuInicial();
			opcao = scan.nextInt();
			
			switch (opcao) {
			
			case CRIAR_REGISTRO: 
				@SuppressWarnings("unused") 
				Cliente cliente = criarCliente();
				
			break;
			
			case ALTERAR_CADASTRO:
				
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
		} while (opcao != TERMINAR); 
		scan.close();

		
	
	private static void menuInicial(){
		System.out.println("------ Selecione o seu Login!------");
		System.out.println("[1] - Criar Registro");
		System.out.println("[2] - Alterar Cliente");
		System.out.println("[100] - Terminar Programa");

	}
	
		
	

}
