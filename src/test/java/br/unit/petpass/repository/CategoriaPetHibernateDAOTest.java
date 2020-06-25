package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unit.petpass.entities.CategoriaPet;
@DisplayName("Cenários_0005 - Testar Categoria de Pets")
class CategoriaPetHibernateDAOTest {
	CategoriaPet categoriaPet;
	CategoriaPetHibernateDAO categoriaPetHibernateDAO;
	Session session;
	Transaction trasaction;
	@BeforeEach
	void init() {
		categoriaPet = new CategoriaPet();
		categoriaPetHibernateDAO = new CategoriaPetHibernateDAO();
		System.out.println("====Início dos Testes de Categoria dos Pets====");
		
		new CategoriaPet(1, "Ave");
		}

	@Test
	@DisplayName("CT0001 - Testar criação de cadastro de Categoria")
	void testSalvar() {
		System.out.println("Testando salvar Categorias");
		
		CategoriaPet categoriaPet = new CategoriaPet(2, "Ave");
		categoriaPetHibernateDAO.salvar(categoriaPet);
		 
		CategoriaPet categoriaPetEsperado = new CategoriaPet(2, "Ave");
		CategoriaPet categoriaPetReal = new CategoriaPet(categoriaPet.getCodigoCategoria(), categoriaPet.getTipo());
		
		Assertions.assertEquals(categoriaPetEsperado, categoriaPetReal, "Testando criação de Cadastro");
		System.out.println("Teste de criar Cadastros realizado");
	}
	
	
	@Test
	@DisplayName("CT0001 - Testar edição de cadastro de Categorias")
	void testUpdateById() {
		System.out.println("Testando update de Categorias");
		CategoriaPet categoriaPet = new CategoriaPet(1, "Cãer de grande porte");
		session.beginTransaction();
		session.update(categoriaPet);
		session.getTransaction().commit();

		CategoriaPet categoriaPetAtual = session.find(categoriaPet.getClass(), categoriaPet.getCodigoCategoria());

		Assertions.assertEquals("Lagartos", categoriaPetAtual.getTipo());
	}

	@Test
	@DisplayName("CT0002 - Testar criação de cadastro de Categorias")
	void testFindById() {
		System.out.println("Testando encontrar Categorias");
		CategoriaPet categoriaPet = new CategoriaPet(3, "Roedores");
		Integer codigoCategoria = 3;
		categoriaPet = session.find(CategoriaPet.class, codigoCategoria);
				
		Assertions.assertEquals("Roedores", categoriaPet.getTipo());
	}

	@Test
	@DisplayName("CT0003 - Testar Listagem de cadastro de Categorias")
	void testListarTodos() {
		System.out.println("Testando listagem de Categorias");
						
		String hql = "select cp from CategoriaPet cp";
		Query<CategoriaPet> query = session.createQuery(hql);
		List<CategoriaPet> categoriaPet = query.list();
		
		Assertions.assertFalse(hql.isEmpty());
		
		System.out.println("Teste de listgem de Cadastros realizado");
	}

	@Test
	@DisplayName("CT0004 - Testar Listagem de cadastro de Categorias")
	void testDeletarCategoriaPet() {
		System.out.println("Testando deletar Categoria");
		Integer codigoCategoria = 1;
		session.find(CategoriaPet.class, codigoCategoria);
		
		session.beginTransaction();
		session.delete(codigoCategoria = 1);
		session.getTransaction().commit();
		
		Assertions.assertTrue(codigoCategoria != 1);
		
		System.out.println("Teste de deletar Cadastros realizado");
	}
}
