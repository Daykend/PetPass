package br.unit.petpass.entities;

import lombok.Data;

@Data
public class Empresa {
	
	private Integer codigoEmpresa;
	private String nome;
	private String cnpj;
	private String telefone;
	private String endereco;
	private boolean statusEmpresa = true;
	
}
