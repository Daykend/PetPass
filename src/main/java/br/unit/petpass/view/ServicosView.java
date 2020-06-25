package br.unit.petpass.view;

import java.util.Scanner;

import br.unit.petpass.controller.ServicosController;
import br.unit.petpass.entities.Servicos;

public class ServicosView {
	Scanner scan = new Scanner(System.in);
	
	public static Servicos criarServicos() {
		
		ServicosController servicosController = new ServicosController();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o nome do novo servico:");
		String nome = scan.nextLine();
		System.out.println("");
		
		System.out.println("Digite o custo em cr�ditos do servi�o:");
		int custoCredito = scan.nextInt();
		
		System.out.println("Digite o status do servi�o [0/1]:");
		int statusServico = scan.nextInt();
		
		
		Servicos servicos = new Servicos(null, nome, custoCredito, statusServico);
		servicosController.salvar(servicos);
		scan.close();
		return servicos;
		
	}
	
	public void listarServicos() {
		ServicosController servicosController = new ServicosController();

		java.util.List<Servicos> servico = servicosController.listAll();

		for (Servicos servicos : servico) {
			System.out.println(servicos);
		}
	}

	public void atualizarServicos() {
		ServicosController servicosController = new ServicosController();
		Servicos servicos = new Servicos();

		System.out.println("Digite o c�digo do servi�o a ser modificado:");
		int codigoServicos = scan.nextInt();
		servicos = servicosController.getServicos(codigoServicos);
		scan.nextLine();

		System.out.println("Digite o nome novo do servicos:");
		String nome = scan.nextLine();
		servicos.setNome(nome);

		servicosController.atualizarServicos(codigoServicos);
		System.out.println("Altera��o realizada");
	}

	public void deletarServico() {

		ServicosController servicosController = new ServicosController();
		Servicos servicos = new Servicos();

		System.out.println("Digite o c�digo do plano que deseja deletar:");
		Integer codigoServicos = scan.nextInt();
		
		servicos = servicosController.getServicos(codigoServicos);
		servicosController.deletarServicos(codigoServicos);
		System.out.println("Servi�o " + servicos + " deletado!");
	}

}
