package br.unit.petpass.application;

import static br.unit.petpass.application.PetPassMainConstantes.CLIENTE;
//import static br.unit.petpass.application.PetPassMainConstantes.EMPRESA;
import static br.unit.petpass.application.PetPassMainConstantes.PLANO;
//import static br.unit.petpass.application.PetPassMainConstantes.SERVICOS;
import static br.unit.petpass.application.PetPassMainConstantes.TESTES;
import static br.unit.petpass.application.PetPassMainConstantes.RELATORIOS;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;

import java.util.Scanner;

import br.unit.petpass.view.ClienteView;
//import br.unit.petpass.view.EmpresaView;
import br.unit.petpass.view.PlanoView;
import br.unit.petpass.view.RelatoriosView;
import br.unit.petpass.view.TestesView;
//import br.unit.petpass.view.ServicosView;

public class PetPassMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ClienteView clienteView = new ClienteView();
		//ServicosView servicosView = new ServicosView();
		PlanoView planoView = new PlanoView();
		//EmpresaView empresaView = new EmpresaView();
		TestesView testesView = new TestesView();
		RelatoriosView relatoriosView = new RelatoriosView();
		
		int opcao = -1;
		do {
			System.out.println("-----------------------------------");
			System.out.println("------ Bem Vindo ao PETPASS! ------");
			System.out.println("-----------------------------------");
			System.out.println();

			menuInicial();
			opcao = scan.nextInt();

			switch (opcao) {

			case CLIENTE:
				clienteView.menuCliente();
				break;
				
			case PLANO:
				planoView.menuPlano();
				break;

//			case EMPRESA:
//				EmpresaView.;
//				break;
				
//			case SERVICOS:
//				ServicosView();
//				break;
				
			case TESTES:
				testesView.menuTestes();
				break;
				
			case RELATORIOS:
				relatoriosView.menuRelatorios();
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
	}

	private static void menuInicial() {
		System.out.println("------ Você está aqui para tratar de Assuntos de: ------");
		System.out.println("[1] - Cliente  [2] - Plano  [5] - Testes  [6] - Relatórios");

	}

}
