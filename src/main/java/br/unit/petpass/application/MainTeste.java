package br.unit.petpass.application;

import static br.unit.petpass.application.PetPassMainConstantes.ALTERAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;
import static br.unit.petpass.application.PetPassMainConstantes.DELETAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.MOSTRAR_CADASTROS;

import java.util.Scanner;

import br.unit.petpass.repository.HibernateUtil;
import br.unit.petpass.view.ClienteView;
import br.unit.petpass.view.EmpresaView;
import br.unit.petpass.view.PlanoView;

public class MainTeste {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HibernateUtil.getSessionFactory().openSession();
		EmpresaView empresaView = new EmpresaView();
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

			case CRIAR_CADASTRO:
//				empresaView.criarEmpresa();
//				clienteView.criarCliente();
				planoView.criarPlano();
				
				
				break;

			case ALTERAR_CADASTRO:
//				empresaView.atualizarEmpresa();
//				clienteView.atualizarCliente();
				planoView.atualizarPlano();
				
				break;
				
			case DELETAR_CADASTRO:
//				empresaView.deletarEmpresa();
//				clienteView.deletarCliente();
				planoView.deletarPlano();

				break;
				
			case MOSTRAR_CADASTROS:
//				empresaView.listarEmpresas();
//				clienteView.listarCLiente();
				planoView.listarPlano();

				break;

			case TERMINAR:
				System.out.println("--------------------------------------");
				System.out.println("------------At� a Pr�xima!------------");
				System.out.println("--------------------------------------");
				System.exit(0);

			default:
				System.out.println("O sistema n�o reconhece esse comando. Tente novamente.");
				break;

			}
		} while (opcao != TERMINAR);
		scan.close();
	}

	private static void menuInicial() {
		System.out.println("------ Selecione o que deseja!------");
		System.out.println("[1] - Cadastrar");
		System.out.println("[2] - Alterar");
		System.out.println("[3] - Deletar");
		System.out.println("[4] - Mostrar Cadastros");
		System.out.println("[100] - Terminar Programa");

	}

}