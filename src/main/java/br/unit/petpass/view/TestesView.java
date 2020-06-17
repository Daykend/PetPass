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

		System.out.println("Qual serviço? Digite o código:");
		int codigoServicos = scan.nextInt();
		servicos = servicosController.getServicos(codigoServicos);
		scan.nextLine();
		System.out.println("Serviço escolhido: " + servicos.getNome());

		ContratoController contratoController = new ContratoController();
		Contrato contrato = new Contrato();

		System.out.println("Digite o código do Contrato a ser consultado:");
		int codigoContrato = scan.nextInt();
		contrato = contratoController.getContratoById(codigoContrato);
		scan.nextLine();

		c1 = contrato.getSaldoFinal();
		c2 = servicos.getCustoCredito();

		if (c1 > c2) {
			System.out.println("Cliente pode realizar serviço");
		} else {
			System.out.println("Saldo insuficiente! Cliente NÃO pode realizar serviço");
		}

	}


public void menuTestes() {

	int menu = -1;
	do {

		System.out.println("Bem vindo(a) as opções de Testes. Você gostaria de:");
		System.out.println("[1] - Verificar se cliente possui saldo para serviço");
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