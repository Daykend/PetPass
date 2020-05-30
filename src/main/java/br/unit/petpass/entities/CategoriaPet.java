package br.unit.petpass.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Integer codigoCategoria;
	
	@Column(name="TIPO")
	private String tipo;

}
