package br.unit.petpass.view;

import static br.unit.petpass.application.PetPassMainConstantes.TERMINAR;
import org.hibernate.mapping.List;

import java.util.Scanner;

import br.unit.petpass.controller.EmpresaController;
import br.unit.petpass.entities.Empresa;

public class EmpresaView {
	Scanner scan = new Scanner(System.in);

	public static Empresa criarEmpresa() {
		Scanner scan = new Scanner(System.in);

		EmpresaController empresaController = new EmpresaController();

		System.out.println("Digite o nome da Empresa:");
		String nome = scan.nextLine();
		System.out.println("");

		System.out.println("Agora o CNPJ:");
		String cnpj = scan.nextLine();

		System.out.println("Qual telefone?");
		String telefone = scan.nextLine();

		System.out.println("Preencha o Endereço:");
		String endereco = scan.nextLine();

	//	Empresa empresa = new Empresa(null, nome, cnpj, telefone, endereco);
		
		
		Empresa empresa2 = new Empresa(null, nome, cnpj, telefone, endereco, null);
		empresaController.salvar(empresa2);
		return empresa2;

	}

	public void listarEmpresas() {
		EmpresaController empresasController = new EmpresaController();

		java.util.List<Empresa> empresas = empresasController.listarEmpresa();

		for (Empresa empresa : empresas) {
			System.out.println(empresa);
		}
	}

	public void atualizarEmpresa() {
		EmpresaController empresaController = new EmpresaController();
		Empresa empresa = new Empresa();

		System.out.println("Digite o id da empresa a ser modificada:");
		int id = scan.nextInt();
		empresa = empresaController.getEmpresa(id);
		scan.nextLine();

		int menu = -1;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("O que deseja modificar? Escolha uma opção:");
			System.out.println("[1] Nome, [2] CNPJ, [3] Telefone, [4] Endereço, [100] Sair");
			menu = scan.nextInt();

			switch (menu) {

			case 1:
				scan.nextLine();
				System.out.println("Digite o nome novo da empresa:");
				String nome = scan.nextLine();
				empresa.setNome(nome);

				empresaController.atualizar(empresa);
				System.out.println("Alteração realizada");

				break;

			case 2:
				scan.nextLine();
				System.out.println("Digite o novo CNPJ:");
				String cnpj = scan.next();
				empresa.setCnpj(cnpj);

				empresaController.atualizar(empresa);
				System.out.println("Alteração realizada");

				break;

			case 3:
				scan.nextLine();
				System.out.println("Digite o novo Telefone:");
				String telefone = scan.next();
				empresa.setTelefone(telefone);

				empresaController.atualizar(empresa);
				System.out.println("Alteração realizada");

				break;

			case 4:
				scan.nextLine();
				System.out.println("Digite o novo Endereço:");
				String endereco = scan.next();
				empresa.setEndereco(endereco);

				empresaController.atualizar(empresa);
				System.out.println("Alteração realizada");

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

	public void deletarEmpresa() {

		EmpresaController empresaController = new EmpresaController();
		Empresa empresa = new Empresa();

		System.out.println("Digite o Id que deseja deletar:");
		Integer id = scan.nextInt();

		empresa = empresaController.getEmpresa(id);
		empresaController.deletar(empresa);
		System.out.println("Empresa " + empresa + " deletada!");
	}
}