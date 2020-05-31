package br.unit.petpass.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.LocalDateType;

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
	private Integer codigoCliente;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "RG")
	private String rg;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ENDERECO")
	private String endereco;

	@Column(name = "DTNASCIMENTO")
	private LocalDateType dtNascimento;

	@Column(name = "SEXO")
	private Character sexo;

	@Column(name = "STATUS_CLIENTE")
	private boolean statusCliente = true;

}
