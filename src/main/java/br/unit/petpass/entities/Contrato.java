package br.unit.petpass.entities;

import org.hibernate.type.LocalDateType;

import lombok.Data;

@Data
public class Contrato {
	// Faltam as FKs: Cliente, Plano e os relacionamentos plano ativo e um contrato
	
	private Integer codigoContrato;
	private Integer numeroContrato;
	private Short saldoInicial;
	private Short saldoFinal;
	private LocalDateType dtCompraCredito;
	private LocalDateType dtVencimentoCredito;
	private boolean statusContrato = true;
	private Cliente cliente;
	private Plano plano;
	
	
}
