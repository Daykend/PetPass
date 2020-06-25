package br.unit.petpass.application;

import static br.unit.petpass.application.PetPassMainConstantes.CLIENTE;
import static br.unit.petpass.application.PetPassMainConstantes.PLANO;
import static br.unit.petpass.application.PetPassMainConstantes.RELATORIOS;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;

import java.util.Scanner;

import br.unit.petpass.view.ClienteView;
import br.unit.petpass.view.PlanoView;
import br.unit.petpass.view.RelatoriosView;

public class PetPassMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ClienteView clienteView = new ClienteView();
		PlanoView planoView = new PlanoView();
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
		System.out.println("[1] - Cliente  [2] - Plano  [6] - Relatórios");

	}

}
