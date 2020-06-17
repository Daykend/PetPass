package br.unit.petpass.view;

import java.util.Scanner;

import br.unit.petpass.controller.ContratoController;
import br.unit.petpass.controller.ServicosController;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Servicos;

public class ContratoView {
	
	Scanner scan = new Scanner(System.in);

	public void listarContrato() {
		new ContratoController();

		java.util.List<Contrato> contratos = ContratoController.getAllContratos();
		for (Contrato contrato : contratos) {
			System.out.println(contrato);
		}
	}
	

	public void listarContrato2() {
		new ContratoController();

		java.util.List<Contrato> contratos = ContratoController.getContratos();
		for (Contrato contrato : contratos) {
			System.out.println(contrato);
		}
	}


}
