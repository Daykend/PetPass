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
@Table(name = "PLANO")
public class Plano implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGOPLANO")
	private Integer codigoPlano;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "PRECO")
	private Double preco;

	@Column(name = "PACOTEINICIALCREDITO")
	private Integer pacoteInicialCredito;

	@Column(name = "STATUS_PLANO")
	private boolean statusPlano = true;

}
