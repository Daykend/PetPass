package br.unit.petpass.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PET")
public class Pet implements Serializable {

	
	@Id
	@Column(name="CODIGOPET")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoPet;
	
	@Column(name="NOME", length = 30)
	private String nome;
	
	@Column(name="DTNASCIMENTO_PET")
	private LocalDate dtNascimentoPet;

	@Column(name="SEXO_PET", length = 1)
	private String sexoPet;
	
	@Column(name="STATUS_PET")
	private Integer statusPet = 1;
	
	@ManyToOne
	@JoinColumn(name="FKCLIENTE")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="FKRACA")
	private Raca raca;
	
//	@ManyToOne
//	@JoinColumn(name="FKCATEGORIAPET")
//	private CategoriaPet categoriaPet;
	
	
}
