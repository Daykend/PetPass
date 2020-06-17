package br.unit.petpass.view;

import br.unit.petpass.controller.ContratoController;
import br.unit.petpass.controller.PetController;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Pet;

public class PetView {
	
	public void listarPets() {
		new PetController();

		java.util.List<Pet> pets = PetController.getAllPets(); 
//		pets.forEach(System.out::println);
		
//		for (Pet pet : pets) {
			System.out.println(pets);
//		}
	}

}
