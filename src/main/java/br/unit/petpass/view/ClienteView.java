package br.unit.petpass.view;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.exception.ClienteException;
import br.unit.petpass.controller.ClienteController;

public class ClienteView {
	
		public static Cliente criarCliente() {
		ClienteController clienteController = new ClienteController();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite seu nome");
		String nome = scan.nextLine();
		
		System.out.println("Digite seu CPF");
		String cpf = scan.next();
			
		System.out.println("Digite seu email");
		String email = scan.next();
		
		System.out.println("Digite seu RG");
		String rg = scan.next();
		
		System.out.println("Digite seu telefone");
		String telefone = scan.next();
		
		scan.nextLine();
		System.out.println("Digite seu Endereço");
		String endereco = scan.nextLine();

		System.out.println("Digite sua Data de Nascimento (dd/mm/aaaa)");
		String data = scan.next();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dtNascimento = LocalDate.parse(data, dateFormat); 
		try {
			dtNascimento = LocalDate.parse(data, dateFormat);
		} catch (Exception e) {
			throw new ClienteException("Data inválida");
		}
		
		System.out.println("Digite F para gênero feminino, e M para gênero masculino");
		String sexo = scan.next();
		
		System.out.println("Cadastro de Cliente concluido. Você Voltará ao menu inicial!");
		
		Cliente cliente = new Cliente(null, cpf, nome, rg, telefone, email, endereco, dtNascimento, sexo);
		clienteController.salvarCliente(cliente);
		return cliente;
		}
	 
}

