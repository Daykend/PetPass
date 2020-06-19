package br.unit.petpass.application;

import static br.unit.petpass.application.PetPassMainConstantes.ALTERAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;
import static br.unit.petpass.application.PetPassMainConstantes.DELETAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.MOSTRAR_CADASTROS;

import java.util.Scanner;

import br.unit.petpass.repository.HibernateUtil;
import br.unit.petpass.view.ClienteView;
import br.unit.petpass.view.ContratoView;
import br.unit.petpass.view.EmpresaView;
import br.unit.petpass.view.PetView;
import br.unit.petpass.view.PlanoView;
import br.unit.petpass.view.ServicosView;

public class MainTeste {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		EmpresaView empresaView = new EmpresaView();
		ClienteView clienteView = new ClienteView();
		PlanoView planoView = new PlanoView();
		ContratoView contratoView = new ContratoView();
		PetView petView = new PetView();
		ServicosView servicosView = new ServicosView();


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
//				planoView.criarPlano();
				petView.cadastrarPet();
				
				
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
				clienteView.listarCLiente();
//				planoView.listarPlano();
//				contratoView.listarContrato();
//				petView.listarPets();
//				contratoView.listarContrato2();
//				servicosView.listarServicos();
				
				break;

			case 5:
//				servicosView.testeContrato();
//				contratoView.listarContrato2();
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
		System.out.println("------ Selecione o que deseja!------");
		System.out.println("[1] - Cadastrar");
		System.out.println("[2] - Alterar");
		System.out.println("[3] - Deletar");
		System.out.println("[4] - Mostrar Cadastros");
		System.out.println("[5] - Testes");
		System.out.println("[100] - Terminar Programa");

	}

}