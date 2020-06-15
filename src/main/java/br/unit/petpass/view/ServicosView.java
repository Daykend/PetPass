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
		
		System.out.println("Digite o custo em créditos do serviço:");
		int custoCredito = scan.nextInt();
		
		
		Servicos servicos = new Servicos(null, nome, custoCredito);
		servicosController.salvar(servicos);
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

		System.out.println("Digite o código do serviço a ser modificado:");
		int codigoServicos = scan.nextInt();
		servicos = servicosController.getServicos(codigoServicos);
		scan.nextLine();

		System.out.println("Digite o nome novo do servicos:");
		String nome = scan.nextLine();
		servicos.setNome(nome);

		servicosController.atualizarServicos(codigoServicos);
		System.out.println("Alteração realizada");
	}

	public void deletarPlano() {

		ServicosController servicosController = new ServicosController();
		Servicos servicos = new Servicos();

		System.out.println("Digite o código do plano que deseja deletar:");
		Integer codigoServicos = scan.nextInt();
		
		servicos = servicosController.getServicos(codigoServicos);
		servicosController.deletarServicos(codigoServicos);
		System.out.println("Serviço " + servicos + " deletado!");
	}
}
