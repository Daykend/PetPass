package br.unit.petpass.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SERVICOS")
public class Servicos implements Serializable {

	private static final long serialVersionUID = 1L;

	// Relacionamento NxN com Empresa

	@Id
	@Column(name = "CODIGOSERVICO")
	private Integer codigoServico;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CUSTOCREDITO")
	private Integer custoCredito;

}
