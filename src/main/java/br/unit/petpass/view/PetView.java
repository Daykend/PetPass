package br.unit.petpass.view;

import java.util.Scanner;

import br.unit.petpass.controller.ClienteController;
import br.unit.petpass.controller.ContratoController;
import br.unit.petpass.controller.PetController;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Pet;

public class PetView {

	PetController petController = new PetController();
	Scanner scan = new Scanner(System.in);

	public void cadastrarPet() {

		System.out.println("Vamos cadastrar seu pet!");
		System.out.print("Qual o codigo do cliente? ");
		int cliente_id = scan.nextInt();

		ClienteController clienteController = new ClienteController();
		Cliente cliente = clienteController.getClientById(cliente_id);
		if (cliente == null) {
			System.out.println("Cliente " + cliente_id + " não encontrado");
		}

		System.out.println("Cliente " + cliente.getNome() + " selecionado");

		System.out.println("Digite o nome do pet: ");
		String pet_nome = scan.next();

		PetController petController = new PetController();
		// Pet pet = new Pet(null, pet_nome, null, null, null, null, null );
		Pet pet = new Pet();
		pet.setNome(pet_nome);
		pet.setCliente(cliente);

		System.out.println("Nome do pet setado para: " + pet.getNome());
		petController.inserirPet(pet);

	}

	public void listarPets() {
		new PetController();

		java.util.List<Pet> pets = PetController.getAllPets();
//		pets.forEach(System.out::println);

//		for (Pet pet : pets) {
		System.out.println(pets);
//		}
	}
	public void menuPet() {

		Scanner scan = new Scanner(System.in);

		int menu = -1;
		do {

			System.out.println("Bem vindo(a) as opções de Pet. Você gostaria de:");
			System.out.println("[1] - Cadastrar Pet");
			System.out.println("[100] - Sair");

			menu = scan.nextInt();

			switch (menu) {
			case 1:
				cadastrarPet();
				break;
			case 100:
				System.out.println("--------------------------------------");
				System.out.println("------------Até a Próxima!------------");
				System.out.println("--------------------------------------");
				System.exit(0);

			default:
				System.out.println("O sistema não reconhece esse comando. Tente novamente.");
				break;
			}

		} while (menu != 100);
		scan.close();
	}

}
