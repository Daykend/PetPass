package br.unit.petpass.controller;

import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Pet;
import br.unit.petpass.repository.PetHibernateDAO;

public class PetController {
	public final int MAX_PETS = 3;

	private static PetHibernateDAO petHibernateDAO;

	public PetController() {
		petHibernateDAO = new PetHibernateDAO();
	}


	public boolean inserirPet(Pet pet) {
		System.out.println("requisitado salvar pet " + pet.getNome());

		Cliente cliente = pet.getCliente();
		List<Pet> owned_pets = cliente.getPets();
		System.out.println("Cliente " + cliente.getNome() + " atualmente possui " + owned_pets.size() + " pets");

		// Checando se o máximo de pets foi atingido...
		if (owned_pets.size() >= MAX_PETS) {
			System.out.println("Cliente atingiu o máximo de pets permitidos!");
			System.out.println("\n\n");
			return false;
		}
		return petHibernateDAO.inserirPet(pet);

	}
	
	public static List<Pet> getAllPets() {
		return petHibernateDAO.getAllPets();
	}
	
	public static List<Pet> getPetsCliente(Integer codigoCliente) {
		return petHibernateDAO.getPetsCliente(codigoCliente);
	}
	
	public boolean salvarPet(Pet pet) {
		// PetHibernateDAO.inserirPet(pet);
		return true;
	}

	public void deletarPet(Pet pet) {
		// petHibernateDAO.deletarPet(pet);
	}
}
