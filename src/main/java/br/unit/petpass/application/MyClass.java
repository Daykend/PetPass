package br.unit.petpass.application;
import java.time.LocalDate; // import the LocalDate class
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.unit.petpass.exception.ClienteException;

public class MyClass {

  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
    LocalDate myObj = LocalDate.now(); // Create a date object
    System.out.println(myObj); // Display the current date
    
	System.out.println("Digite sua Data de Nascimento (dd/mm/aaaa)");
	String data = scan.next();
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate dtNascimento = LocalDate.parse(data, dateFormat); 
	try {
		dtNascimento = LocalDate.parse(data, dateFormat);
	} catch (Exception e) {
		throw new ClienteException("Data inválida");
	}
	System.out.println(dtNascimento);
    
	Period period = Period.between(dtNascimento, LocalDate.now());
	System.out.println(period);
	if (period.getYears() < 18) {
		System.out.println(period.getYears());
		throw new RuntimeException("Não é possível cadastrar clientes menores de 18 anos");
	}
	else
		System.out.println(period.getYears());
  }
}