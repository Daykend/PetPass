package br.unit.petpass.view;

import java.util.List;

import br.unit.petpass.entities.Plano;

public class PlanoView {
	public static void main(String[] args) {
	System.out.println("Listar todos os planos:"); //view
	List<Plano> planos = reporPlanoHibernate.listAll();
	for (Plano plano : planos) {
		System.out.println(plano);
	}
	
	System.out.println("Consultar 1 plano pelo id (codigo):");
	Plano plano = reporPlanoHibernate.findById(2);
	System.out.println(plano);
	
	System.out.println("Atualizar Preço do Plano");
	reporPlanoHibernate.updatePriceOfPlan(3, 450.0);
	
	System.out.println("Atualizar Nome do Plano");
	reporPlanoHibernate.updatePlanName(1, "PetPass Basic");
	
	System.out.println("Atualizar Pacote Inical de Credito do Plano");
	reporPlanoHibernate.updatePriceOfPlan(3, 450.0);
	
	System.out.println("Atualizar Status do Plano (1/0)");
	reporPlanoHibernate.updatePlanStatus(1, 0);
	
	reporPlanoHibernate.deleteById(4);
	
	for (Plano p : planos) {
		System.out.println(p);
	}
	}

}
