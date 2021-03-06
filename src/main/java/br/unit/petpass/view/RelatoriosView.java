package br.unit.petpass.view;

import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;

import java.util.List;
import java.util.Scanner;

import br.unit.petpass.controller.ContratoController;
import br.unit.petpass.controller.EmpresaController;
import br.unit.petpass.controller.PetController;
import br.unit.petpass.controller.ServicosController;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Empresa;
import br.unit.petpass.entities.Pet;
import br.unit.petpass.entities.Servicos;

public class RelatoriosView {
	Scanner scan = new Scanner(System.in);

	public void servicosAteValor() {
		ServicosController servicosController = new ServicosController();

		System.out.println("Qual valor m�ximo do servi�o?");
		int valorCredito = scan.nextInt();
		java.util.List<Servicos> servico = servicosController.listAll2(valorCredito);
		

		for (Servicos servicos : servico) {
			System.out.println("Nome: " + servicos.getNome()+ " || Valor: " + servicos.getCustoCredito());
		}

	}

	public void relatorioServicosPorEmpresas() {

		List<Empresa> empresas;
		EmpresaController empresaController = new EmpresaController();
		empresas = empresaController.listarEmpresa();

		for (Empresa empresa : empresas) {
			System.out.println("Empresa: " + empresa.getNome());

			for (Servicos servico : empresa.getServicos()) {
				System.out.println("Servi�o: " + servico.getNome());
			}
			System.out.println("\n");
		}
		System.out.println("\n\n");
	}
	
	public void listarPetsPorCliente() {
		new PetController();
		
		System.out.println("Digite o c�digo do cliente:");
		int codigoCliente = scan.nextInt();
		
		List<Pet> pets = PetController.getPetsCliente(codigoCliente);
		
		for (Pet pet : pets) {
			System.out.println("Nome: " + pet.getNome());
		}
		
	}
	
	public void listaCreditosClientes() {
		List<Contrato> contratos;
		ContratoController contratoController =  new ContratoController();
		contratos = contratoController.getAllContratos();
		int soma = 0;
		for (Contrato contrato : contratos) {
			System.out.println("Numero Contrato: ||" + contrato.getCodigoContrato() 
			+ "|| Saldo de pontos :" + contrato.getSaldoFinal());
			
			soma = contrato.getSaldoFinal() + soma;

		}
		System.out.println("Total de pontos ativos: " + soma);
		System.out.println("\n");

	}

	public void menuRelatorios() {

		int menu = -1;
		do {

			System.out.println("Bem vindo(a) as op��es de Relatorios. Voc� gostaria de:");
			System.out.println("[1] - Lista de contratos e saldo de pontos");
			System.out.println("[2] - Lista de servi�os que cada empresa realiza");
			System.out.println("[3] - Lista de pets por cliente");
			System.out.println("[4] - Lista de servi�os at� determinado valor");
			System.out.println("[100] - Sair");

			menu = scan.nextInt();

			switch (menu) {
			case 1:				
				listaCreditosClientes();
				break;

			case 2:
				relatorioServicosPorEmpresas();
				break;

			case 3:
				listarPetsPorCliente();
				break;
				
			case 4:
				servicosAteValor();
				break;
				
			case 5:
				
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
