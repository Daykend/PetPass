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

@Entity
@Data
@Table(name="CATEGORIAPET")
@NoArgsConstructor
@AllArgsConstructor


public class CategoriaPet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CODIGOCATEGORIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Defidindo que essa coluna é identity igual ao banco
	private Integer codigoCategoria;
	
	@Column(name="TIPO", length = 20) // Definindo nome e tamanho maximo de caracteres como tem na criação da tabela do banco
	private String tipo;

}
