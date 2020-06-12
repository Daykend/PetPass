package br.unit.petpass.application;

import static br.unit.petpass.application.PetPassMainConstantes.ALTERAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_REGISTRO;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;

import java.util.Scanner;

import br.unit.petpass.repository.HibernateUtil;
import br.unit.petpass.view.ClienteView;
import br.unit.petpass.view.PlanoView;

public class PetPassMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HibernateUtil.getSessionFactory().openSession();
		ClienteView clienteView = new ClienteView();
		PlanoView planoView = new PlanoView();

		int opcao = -1;
		do {
			System.out.println("-----------------------------------");
			System.out.println("------ Bem Vindo ao PETPASS! ------");
			System.out.println("-----------------------------------");
			System.out.println();

			menuInicial();
			opcao = scan.nextInt();

			switch (opcao) {

			case CRIAR_REGISTRO:
				clienteView.criarCliente();

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
	}

	private static void menuInicial() {
		System.out.println("------ Selecione o seu Login!------");
		System.out.println("[1] - Criar Registro");
		System.out.println("[2] - Alterar Cliente");
		System.out.println("[100] - Terminar Programa");

	}

}
