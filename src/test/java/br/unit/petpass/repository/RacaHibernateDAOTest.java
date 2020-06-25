package br.unit.petpass.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Pet;
import br.unit.petpass.entities.Raca;

class RacaHibernateDAOTest {
	Raca raca;
	RacaHibernateDAO racaHibernateDAO;
	Session session;
	Transaction trasaction;
	@SuppressWarnings("unused")
	@BeforeEach
	void init() {
		raca = new Raca();
		System.out.println("====Início dos Testes de Cadastro de Raças====");
		CategoriaPet categoriaPet = null;
		Integer codigoRaça = -1;
		new Raca(1, "Golden Retriever", categoriaPet);
		}

	@Test
	@DisplayName("CT0001 - Testar criação de cadastro de Pets")
	void testSalvarPet() {
		System.out.println("Testando salvar Pets");
		
		session.beginTransaction();
		
		Raca raçaEsperado = new Raca(2, "Golden Retriver", "Cães de Médio Porte");
		Raca raçaReal = new Raca(2, "Cães de Pequeno Porte");
		
		session.getTransaction();
		
		Assertions.assertEquals(raçaEsperado, raçaReal, "Testando criação de Cadastro");
		System.out.println("Teste de criar Cadastros realizado");
	}

	@Test
	void testListAll() {
		fail("Not yet implemented"); 
	}

	@Test
	void testUpdateRaca() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllRaca() {
		fail("Not yet implemented");
	}

	@Test
	void testAcharRaca() {
		fail("Not yet implemented");
	}

}
