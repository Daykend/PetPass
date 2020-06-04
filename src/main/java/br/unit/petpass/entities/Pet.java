package br.unit.petpass.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class Pet {
	// Faltam as FKs: Cleinte, Raça, CategoriaPet e os relacionamentos
	
	@Id
	@Column(name="CODIGOPET")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoPet;
	
	@Column(name="NOME", length = 30)
	private String nome;
	
	@Column(name="DTNASCIMENTO_PET")
	private LocalDate dtNascimentoPet;

	@Column(name="SEXO_PET", length = 1)
	private String sexoPet;
	
	@Column(name="STATUS_PET")
	private Integer statusPet = 1;
	
	@OneToMany
	@JoinColumn//(name = "falta colocar o nome aqui ainda...")
	private Raca raca;
	
	@OneToMany
	@JoinColumn//(name = "falta colocar o nome aqui ainda...")
	private CategoriaPet categoriaPet;
	
	
}
