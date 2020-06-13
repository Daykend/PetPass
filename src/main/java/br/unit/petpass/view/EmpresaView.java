package br.unit.petpass.view;

import java.util.Scanner;

import org.hibernate.mapping.List;

import br.unit.petpass.controller.EmpresaController;
import br.unit.petpass.entities.Empresa;

public class EmpresaView {
	Scanner scan = new Scanner(System.in);

	public static Empresa criarEmpresa() {
		Scanner scan = new Scanner(System.in);

		EmpresaController empresaController = new EmpresaController();

		System.out.println("Digite o nome:");
		String nome = scan.nextLine();
		System.out.println("");

		System.out.println("Agora o CNPJ:");
		String cnpj = scan.nextLine();

		System.out.println("Qual telefone?");
		String telefone = scan.nextLine();

		System.out.println("Preencha o Endere�o:");
		String endereco = scan.nextLine();

		Empresa empresa = new Empresa(null, nome, cnpj, telefone, endereco);
		empresaController.salvar(empresa);
		return empresa;

	}

	public void listarEmpresas() {
		EmpresaController empresasController = new EmpresaController();
		
		java.util.List<Empresa> empresas = empresasController.listar();
		
		
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
			
			System.out.println("Digite o nome novo da empresa:");
			String nome = scan.nextLine();
			empresa.setNome(nome);
			
			empresaController.atualizar(empresa);
			System.out.println("Altera��o realizada");
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