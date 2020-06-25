package br.unit.petpass.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unit.petpass.entities.CategoriaPet;

class ContratoHibernateDAOTest {
	ContratoHibernateDAO contratoHibernateDAO;
	Session session;
	
	@Test
	@DisplayName("CT0001 - Testar criação de cadastro de Cliente")
	void testSalvarContrato() {
			System.out.println("Testando salvar novos Contratos");
			
			session.beginTransaction();
			
			CategoriaPet categoriaPetEsperado = new CategoriaPet(2, "Peixes");
			CategoriaPet categoriaPetReal = new CategoriaPet(2, "Cães de Pequeno Porte");
			
			session.getTransaction();
			
			Assertions.assertEquals(categoriaPetEsperado, categoriaPetReal, "Testando criação de Cadastro");
			System.out.println("Teste de criar Cadastros realizado");
	}

	@Test
	void testGetAllContratos() {
		fail("Not yet implemented");
	}

	@Test
	void testGetContratos() {
		fail("Not yet implemented");
	}

	@Test
	void testGetContratoById() {
		fail("Not yet implemented");
	}

}
