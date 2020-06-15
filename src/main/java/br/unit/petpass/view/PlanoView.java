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

	public static Plano criarPlano() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Digite o nome do nove plano:");
		String nome = scan.nextLine();
		System.out.println("");

		System.out.println("Digite o preço do plano:");
		double preco = scan.nextDouble();

		System.out.println("Digite a quantidade de pontos disponível no plano:");
		int pacoteInicialCredito = scan.nextInt();

		Plano plano = new Plano(null, nome, preco, pacoteInicialCredito);
		PlanoController.salvarPlano(plano);
		return plano;

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

		System.out.println("Digite o nome novo do plano:");
		String nome = scan.nextLine();
		plano.setNome(nome);

		PlanoController.atualizar(plano);
		System.out.println("Alteração realizada");
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

		Scanner scan = new Scanner(System.in);
		Plano plano = new Plano();

		int menu = -1;
		do {

			System.out.println("Bem vindo(a) as opções de Cliente. Você gostaria de:");
			System.out.println("[1] - Criar Cadastro de Plano");
			System.out.println("[2] - Editar Cadastro de Plano");
			System.out.println("[3] - Listar Cadastro de Plano");
			System.out.println("[4] - Deletar Cadastro de P");

			menu = scan.nextInt();

			switch (menu) {
			case CRIAR_CADASTRO:
				criarPlano();
				PlanoController.salvarPlano(plano);
				break;
			case ALTERAR_CADASTRO:
				atualizarPlano();
				PlanoController.salvarPlano(plano);
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

//		 System.out.println("Atualizar Plano");
//		 PlanoHibernateDAO.updatePlano(3, 450.0);

	/*
	 * System.out.println("Atualizar Nome do Plano");
	 * PlanoHibernateDAO.updatePlanName(1, "PetPass Basic");
	 * 
	 * System.out.println("Atualizar Pacote Inical de Credito do Plano");
	 * PlanoHibernateDAO.updatePriceOfPlan(3, 450.0);
	 * 
	 * System.out.println("Atualizar Status do Plano (1/0)");
	 * PlanoHibernateDAO.updatePlanStatus(1, 0);
	 * 
	 * 
	 * PlanoHibernateDAO.deletarPlano(4); for (Plano p : planos) {
	 * System.out.println(p); }
	 */
}
