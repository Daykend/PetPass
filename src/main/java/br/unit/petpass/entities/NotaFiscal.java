package br.unit.petpass.entities;

import org.hibernate.type.LocalDateType;

import lombok.Data;

@Data
public class NotaFiscal {
	//Faltam as FKs; Empresa, Contrato e os relacionamentos
	
	private Integer codigoNF;
	private LocalDateType data;
	private Empresa empresa;
	private Contrato contrato;
	
}
