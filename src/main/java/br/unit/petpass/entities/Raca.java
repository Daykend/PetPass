package br.unit.petpass.entities;

import lombok.Data;

@Data
public class Raca {
	// Faltam a FK: CategoriaPet e o relacionamento
	
	private Integer codigoRaca;
	private String nomeRaca;
	private CategoriaPet categoriaPet;
}
