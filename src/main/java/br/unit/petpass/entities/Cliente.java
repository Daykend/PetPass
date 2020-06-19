package br.unit.petpass.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGOCLIENTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoCliente;

	@Column(name = "CPF", unique = true, length = 15, nullable = false)
	private String cpf;

	@Column(name = "NOME", length = 80, nullable = false)
	private String nome;

	@Column(name = "RG", length = 10, nullable = false)
	private String rg;

	@Column(name = "TELEFONE", unique = true, length = 11, nullable = false)
	private String telefone;

	@Column(name = "EMAIL", unique = true, length = 50, nullable = false)
	private String email;

	@Column(name = "ENDERECO", length = 250, nullable = false)
	private String endereco;

	@Column(name = "DTNASCIMENTO", nullable = false)
	private LocalDate dtNascimento;

	@Column(name = "SEXO", length = 1)
	private String sexo;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "FKCLIENTE")
	private List<Pet> pets;
	
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	private Contrato contrato;

	public static String numeroCadastro() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}


}
