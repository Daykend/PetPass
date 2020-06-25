package br.unit.petpass.controller;

import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Pet;
import br.unit.petpass.entities.Plano;
import br.unit.petpass.repository.PetHibernateDAO;

public class PetController {
	public final int MAX_PETS = 3;

	private static PetHibernateDAO petHibernateDAO;

	public PetController() {
		petHibernateDAO = new PetHibernateDAO();
	}


	public boolean inserirPet(Pet pet) {
		System.out.println("Requisitado salvar pet " + pet.getNome());
		System.out.println("\n");

		Cliente cliente = pet.getCliente();
		List<Pet> ownedPets = cliente.getPets();
		System.out.println("Cliente " + cliente.getNome() + " atualmente possui " + (ownedPets.size()+1) + " pets");

        Contrato contrato = cliente.getContrato();
        Plano plano = contrato.getPlano();
        int codigoPlano = plano.getCodigoPlano();
        
		if (ownedPets.size() >= MAX_PETS && codigoPlano == 1) {
			System.out.println("Cliente atingiu o máximo de pets permitidos para o plano!");
			System.out.println("\n");
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
	
	public void deletarPet(Pet pet) {
		// petHibernateDAO.deletarPet(pet);
	}
}
