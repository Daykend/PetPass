package br.unit.petpass.view;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unit.petpass.controller.ClienteController;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.exception.ClienteException;
import br.unit.petpass.repository.HibernateUtil;

class ClienteViewTest {
	Cliente cliente;
	ClienteView clienteView;
	private Session session;
	private Transaction transaction;
	
	public void abreConexão() {
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		this.transaction = this.session.beginTransaction();
	}
	
	public void fechaConexão() {
		this.transaction.commit();
		try {
			if(this.session.isOpen()) {
				this.session.close();
			}
		} catch (Exception e) {
			System.out.println("Houve um problema enquanto fechávamos a conexão. Tente novamente." + e.getMessage());
		}
	}
	
	@BeforeEach
	void init() {
		cliente = new Cliente();
		clienteView = new ClienteView();
	}
	
	@Test
	void testCriarCliente() {
		Cliente c1 = new Cliente();
		c1.setNome("Testudo Testão");
		c1.setCpf("123.456.789-99");
		c1.setDtNascimento(1889-10-11);
	}

	@Test
	void testListarCliente() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAtualizarCliente() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeletarCliente() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testMenuCliente() {
		
	}
	
	

}
