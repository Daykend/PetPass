package br.unit.petpass.entities;

import org.hibernate.type.LocalDateType;

import lombok.Data;

@Data
public class Pet {
	// Faltam as FKs: Cleinte, Raça, CategoriaPet e os relacionamentos
	
	private Integer codigoPet;
	private String nome;
	private LocalDateType dtNascimentoPet;
	private Character sexoPet;
	private boolean statusPet = true;
	private Raca raca;
	private CategoriaPet categoriaPet;
	
	
}
