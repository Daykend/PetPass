package br.unit.petpass.entities;

import org.hibernate.type.LocalDateType;

import lombok.Data;

@Data
public class Cliente {
	
	private Integer codigoCliente;
	private String cpf;
	private String nome;
	private String rg;
	private String telefone;
	private String email;
	private String endereco;
	private LocalDateType dtNascimento;
	private Character sexo;
	private boolean statusCliente  = true;
	
}
