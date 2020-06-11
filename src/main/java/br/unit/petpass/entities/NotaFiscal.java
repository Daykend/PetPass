package br.unit.petpass.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class NotaFiscal {
	//Faltam as FKs; Empresa, Contrato e os relacionamentos
	@Id
	@Column(name="CODIGONF")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoNF;
	
	@Column(name="DATA", nullable = false)// como implementar um sysdatetime aqui, para gerar a data sozinho
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn//(name="Falta por o nome da coluna aqui...")
	private Contrato contrato;
	
	@ManyToOne
	@JoinColumn//(name="Falta por o nome da coluna aqui...")
	private Empresa empresa;
	
}
