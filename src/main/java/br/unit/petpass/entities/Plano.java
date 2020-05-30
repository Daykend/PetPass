package br.unit.petpass.entities;

import lombok.Data;

@Data
public class Plano {
	
	private Integer codigoPlano;
	private String nome;
	private Float preco;
	private Short pacoteInicialCredito;
	private boolean statusPlano = true;
	
}
