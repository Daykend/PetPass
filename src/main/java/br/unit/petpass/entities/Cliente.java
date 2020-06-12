package br.unit.petpass.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

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

	public static String numeroCadastro() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

	// Duvida se o Cliente vai ter uma Lista dos pets ou não, e se vai ter que
	// mapear isso, já que no banco não tem fk de pet em cliente e sim o contrário

}
