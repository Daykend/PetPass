package br.unit.petpass.view;

import static br.unit.petpass.application.PetPassMainConstantes.ALTERAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.DELETAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.MOSTRAR_CADASTROS;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;

import java.util.Scanner;

import br.unit.petpass.controller.PlanoController;
import br.unit.petpass.entities.Plano;

public class PlanoView {
	Scanner scan = new Scanner(System.in);

	public void criarPlano() {

		PlanoController planoController = new PlanoController();

		Scanner scan = new Scanner(System.in);

		System.out.println("Digite o nome do novo plano:");
		String nome = scan.nextLine();
		System.out.println("");

		System.out.println("Digite o preço do plano:");
		double preco = scan.nextDouble();

		System.out.println("Digite a quantidade de pontos disponível no plano:");
		Integer pacoteInicialCredito = scan.nextInt();

		Plano plano = new Plano(null, nome, preco, pacoteInicialCredito);
		planoController.salvarPlano(plano);

	}

	public void listarPlano() {
		new PlanoController();

		java.util.List<Plano> planos = PlanoController.listar();

		for (Plano plano : planos) {
			System.out.println(plano);
		}
	}

	public void atualizarPlano() {
		PlanoController planoController = new PlanoController();
		Plano plano = new Plano();

		System.out.println("Digite o código do plano a ser modificado:");
		int codigoPlano = scan.nextInt();
		plano = planoController.getPlano(codigoPlano);
		scan.nextLine();
		
		
		int menu = -1;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("O que deseja modificar? Escolha uma opção:");
			System.out.println("[1] Nome, [2] Preço, [3] Pacote [4] Voltar Menu [100] Sair");
			menu = scan.nextInt();

			switch (menu) {

			case 1:
				scan.nextLine();
				System.out.println("Digite o nome novo do plano:");
				String nome = scan.nextLine();
				plano.setNome(nome);

				planoController.atualizar(plano);
				System.out.println("Alteração realizada");

				break;

			case 2:
				scan.nextLine();
				System.out.println("Digite o preço novo do plano:");
				double preco = scan.nextDouble();
				plano.setPreco(preco);

				planoController.atualizar(plano);
				System.out.println("Alteração realizada");

				break;

			case 3:
				scan.nextLine();
				System.out.println("Digite o preço novo do plano:");
				int pacote = scan.nextInt();
				plano.setPacoteInicialCredito(pacote);

				planoController.atualizar(plano);
				System.out.println("Alteração realizada");

				break;
			case 4:
				menuPlano();

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

	public void deletarPlano() {

		PlanoController planoController = new PlanoController();
		Plano plano = new Plano();

		System.out.println("Digite o código do plano que deseja deletar:");
		Integer codigoPlano = scan.nextInt();

		plano = planoController.getPlano(codigoPlano);
		planoController.deletar(plano);
		System.out.println("Plano " + plano + " deletado!");
	}

	public void menuPlano() {

		int menu = -1;
		do {

			System.out.println("Bem vindo(a) as opções de Plano. Você gostaria de:");
			System.out.println("[1] - Criar Cadastro de Plano");
			System.out.println("[2] - Editar Cadastro de Plano");
			System.out.println("[3] - Deletar Cadastro de Plano");
			System.out.println("[4] - Mostrar Planos");
			System.out.println("[100] - Sair");

			menu = scan.nextInt();

			switch (menu) {
			case CRIAR_CADASTRO:
				criarPlano();
				break;
			case ALTERAR_CADASTRO:
				atualizarPlano();
				break;
			case MOSTRAR_CADASTROS:
				listarPlano();
				break;
			case DELETAR_CADASTRO:
				deletarPlano();
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
