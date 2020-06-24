package br.unit.petpass.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RACA")
public class Raca {

	
	@Id
	@Column(name="CODIGORACA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoRaca;
	
	@Column(name="NOMERACA", length = 30)
	private String nomeRaca;
	
	@OneToOne
	@JoinColumn(name="FKCATEGORIAPET")
	private CategoriaPet categoriaPet;
}
