package br.unit.petpass.view;

import static br.unit.petpass.application.PetPassMainConstantes.ALTERAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.CRIAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.DELETAR_CADASTRO;
import static br.unit.petpass.application.PetPassMainConstantes.MOSTRAR_CADASTROS;
import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;

import java.util.Scanner;

import br.unit.petpass.controller.ContratoController;
import br.unit.petpass.controller.ServicosController;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Servicos;

public class TestesView {
	Scanner scan = new Scanner(System.in);
	private Short c1;
	private Integer c2;

	public void testeContrato() {

		ServicosController servicosController = new ServicosController();
		Servicos servicos = new Servicos();

		System.out.println("Qual servi�o? Digite o c�digo:");
		int codigoServicos = scan.nextInt();
		servicos = servicosController.getServicos(codigoServicos);
		scan.nextLine();
		System.out.println("Servi�o escolhido: " + servicos.getNome());

		ContratoController contratoController = new ContratoController();
		Contrato contrato = new Contrato();

		System.out.println("Digite o c�digo do Contrato a ser consultado:");
		int codigoContrato = scan.nextInt();
		contrato = contratoController.getContratoById(codigoContrato);
		scan.nextLine();

		c1 = contrato.getSaldoFinal();
		c2 = servicos.getCustoCredito();

		if (c1 > c2) {
			System.out.println("Cliente pode realizar servi�o");
		} else {
			System.out.println("Saldo insuficiente! Cliente N�O pode realizar servi�o");
		}

	}


public void menuTestes() {

	int menu = -1;
	do {

		System.out.println("Bem vindo(a) as op��es de Testes. Voc� gostaria de:");
		System.out.println("[1] - Verificar se cliente possui saldo para servi�o");
		System.out.println("[2] - Teste 2");
		System.out.println("[100] - Sair");
		
		menu = scan.nextInt();

		switch (menu) {
		case CRIAR_CADASTRO:
			testeContrato();
			break;
		case ALTERAR_CADASTRO:

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

	} while (menu != TERMINAR);
	scan.close();
}
}