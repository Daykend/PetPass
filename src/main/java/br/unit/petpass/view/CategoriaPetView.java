package br.unit.petpass.view;

import br.unit.petpass.controller.CategoriaPetController;
import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.entities.Plano;

public class CategoriaPetView {

	public static void main(String[] args) {
		CategoriaPetController categoriaPetController = new CategoriaPetController();
		
		
		
		public static void gerarInsertsCategoriaPet() {
			
			CategoriaPet categoria1 = new CategoriaPet(1, "Gato");
			reporCategoriaHibernate.salvar(categoria1);

			CategoriaPet categoria2 = new CategoriaPet(2, "Ave");
			reporCategoriaHibernate.salvar(categoria2);

			CategoriaPet categoria3 = new CategoriaPet(3, "Réptil");
			reporCategoriaHibernate.salvar(categoria3);

		}
		
		public static void gerarInsertsPlano() {
			
			Plano plano1 = new Plano(1, "PetPass", 100.0, 100, 1);
			reporPlanoHibernate.salvar(plano1);
			
			Plano plano2 = new Plano(2, "PetPass Plus", 200.0, 200, 1);
			reporPlanoHibernate.salvar(plano2);
			
			Plano plano3 = new Plano(3, "PetPass Gold", 300.0, 300, 1);
			reporPlanoHibernate.salvar(plano3);
			
			Plano plano4 = new Plano(4, "PetPass Deluxe", 500.0, 500, 1);
			reporPlanoHibernate.salvar(plano4);
		}

	
}
}
