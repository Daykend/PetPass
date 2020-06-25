package br.unit.petpass.repository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unit.petpass.controller.ClienteController;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.exception.ClienteException;
@DisplayName("Cenário_0002 - Testar de cadastro de Cliente")
class ClienteHibernateDAOTest {
	Cliente cliente;
	Session session;
	Transaction transaction;
	
	@BeforeEach
	void init() {
		cliente = new Cliente();
		System.out.println("====Início dos Testes de Cliente====");
		
//		Cliente clienteEsperado = new Cliente(02, "123.456.789-99", "Testão Testando", "3256987", "985746251",
//				"testao@gmail.com", "Rua Unit", 12/10/1852, "F");
	}

	@Test
	@DisplayName("CT0001 - Testar criação de cadastro de Cliente")
	void testSalvarCliente() {
		System.out.println("Testando alcarCliente()");
		
		session.beginTransaction();
		
//		Cliente clienteEsperado = new Cliente(02, "123.456.789-99", "Testão Testando", "3256987", "985746251", "testao@gmail.com", "Rua Unit", null, "F");
		Integer codigoCliente = (Integer) session.save(clienteEsperado);
		
		session.getTransaction();
		
		Assertions.assertTrue(codigoCliente > 0);
		}

	@Test
	void testUpdateCliente() {
//		Cliente cliente = new Cliente(2, "123.456.789-99", "Testudo Testando", "3256987", "985746251",
//				"testao@gmail.com", "Rua Unit", null, "F");
//		Cliente clienteEsperado = new Cliente(2, "123.456.789-99", "Testudo Testinha", "3256987", "985746251",
//				"testao@gmail.com", "Rua Unit", null, "F");
		session.update(clienteEsperado);
		session.getTransaction().commit();

		Cliente clienteReal = session.find(cliente.getClass(), Cliente.getCodigoCliente());

		Assertions.assertEquals("Testudo", cliente.getNome());
	}

	@Test
	void testGetClientById() {
		session.beginTransaction();
		
		String clienteEsperado = cliente.setCpf("123.456.789-99");
		String clienteReal = cliente.getCpf();
		assertEquals(clienteEsperado, clienteReal, "Testando criação de Cadastro");
			System.out.println("Teste de criação de cadastro realizado");
		}
	}

	@Test
	void testGetAllClients() {
//		Cliente clienteEsperado = new Cliente(02, "123.456.789-99", "Testão Testando", "3256987", "985746251",
//				"testao@gmail.com", "Rua Unit", null, "F");
		String hql = "select c from Cliente c";
		Query<Cliente> query = session.createQuery(hql);

		Assertions.assertFalse(hql.isEmpty());
		
		System.out.println("Teste de listgem de Cadastros realizado");
	}

	@Test
	void testDeletarCliente() {
		
		session.delete(cliente);
		session.getTransaction().commit();
		
		System.out.println("Teste de deletar Cadastros realizado");
	}

}
