package br.unit.petpass.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLANO")
public class Plano implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGOPLANO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoPlano;

	@Column(name = "NOME", length = 25, nullable = false)
	private String nome;

	@Column(name = "PRECO", nullable = false)
	private Double preco;

	@Column(name = "PACOTEINICIALCREDITO", nullable = false)
	private Integer pacoteInicialCredito;

	public Plano(String nome, Double preco, Integer pacoteInicialCredito) {
		this.nome = nome;
		this.preco = preco;
		this.pacoteInicialCredito = pacoteInicialCredito;
	}
}
