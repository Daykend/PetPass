package br.unit.petpass.controller;

import java.util.List;

import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Pet;
import br.unit.petpass.repository.ContratoHibernateDAO;
import br.unit.petpass.repository.PetDAO;

public class PetController {
	private static PetDAO petDAO;
	
	public PetController() {
		petDAO = new PetDAO();
	}
	
	
	public static List<Pet> getAllPets() {
		return petDAO.getAllPets();
	}

}
