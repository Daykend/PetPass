package br.unit.petpass.application;

import static br.unit.petpass.application.PetPassMainConstantes.ALTERAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_REGISTRO;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;
import static br.unit.petpass.application.PetPassMainConstantes.DELETAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.MOSTRAR_REGISTROS;

import java.util.Scanner;

import br.unit.petpass.repository.HibernateUtil;
import br.unit.petpass.view.ClienteView;
import br.unit.petpass.view.EmpresaView;
import br.unit.petpass.view.PlanoView;

public class PetPassMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HibernateUtil.getSessionFactory().openSession();
		EmpresaView empresaView = new EmpresaView();

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
				empresaView.criarEmpresa();
				
				break;

			case ALTERAR_CADASTRO:
				empresaView.atualizarEmpresa();
				
				break;
				
			case DELETAR_CADASTRO:
				empresaView.deletarEmpresa();

				break;
				
			case MOSTRAR_REGISTROS:
				empresaView.listarEmpresas();

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
		System.out.println("[1] - Cadastrar Empresa");
		System.out.println("[2] - Alterar Empresa");
		System.out.println("[3] - Deletar Empresa");
		System.out.println("[4] - Mostrar Cadastros");
		System.out.println("[100] - Terminar Programa");

	}

}
