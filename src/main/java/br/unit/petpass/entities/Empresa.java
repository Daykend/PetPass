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
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGOEMPRESA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoEmpresa;

	@Column(name = "NOME", nullable = false, length = 20)
	private String nome;

	@Column(name = "CNPJ", unique = true, length = 18, nullable = false)
	private String cnpj;

	@Column(name = "TELEFONE", nullable = false, length = 11, unique = true)
	private String telefone;

	@Column(name = "ENDERECO", length = 250, nullable = false)
	private String endereco;

	@Column(name = "STATUS_EMPRESA")
	private Integer statusEmpresa = 1; // Tô colocando 1 como 'padrão' para ser como ta no banco...

}
