package br.unit.petpass.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javassist.SerialVersionUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CONTRATO")
public class Contrato implements Serializable {
	

	@Id
	@Column(name="CODIGOCONTRATO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoContrato;
	
	@Column(name="NUMERODOCONTRATO", unique = true, nullable = false)
	private Integer numeroContrato;
	
	@Column(name="SALDOINICIAL")
	private Short saldoInicial;
	
	@Column(name="SALDOFINAL") // Duvida sobre Trigger e metodo de de setar o saldo final
	private Short saldoFinal;
	
	@Column(name="DATACOMPRACREDITO", nullable = false)
	private LocalDate dtCompraCredito;
	
	@Column(name="DATAVENCIMENTOCREDITO", nullable = false)
	private LocalDate dtVencimentoCredito;
	
	@Column(name="STATUS_CONTRATO", nullable = false)
	private Integer statusContrato = 1;
	
	
	@ManyToOne
	@JoinColumn(name = "FKPLANO")
	private Plano plano;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FKCLIENTE")
	private Cliente cliente;
	
//	@OneToMany
//	@JoinColumn//(name = "falta colocar o nome aqui ainda...")
//	private List<NotaFiscal> notasFiscais = new ArrayList<>();	
	
}
