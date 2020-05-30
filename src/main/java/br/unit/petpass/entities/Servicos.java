package br.unit.petpass.entities;

import lombok.Data;

@Data
public class Servicos {
	// Relacionamento NxN com Empresa
	
	private Integer codigoServico;
	private String nome;
	private Short custoCredito;
	private boolean statusServicos = true;
	
}
