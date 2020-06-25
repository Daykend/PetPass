package br.unit.petpass.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unit.petpass.entities.Plano;

@DisplayName("Cenários 0001 - Testar Planos")
class PlanoHibernateDAOTest {
	PlanoHibernateDAO planoHibernateDAO;
	Plano plano;
	private static Session session;
	private static Transaction transaction;

	@BeforeEach
	void init() {
		System.out.println("====Início dos Testes de Plano====");
	}
	
	@BeforeEach
	public static void openConnection() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		transaction = session.beginTransaction();
	}
	
	@AfterEach
	public static void closeConnection() {
		transaction.commit();
		try {
			if (session.isOpen()) {
				session.close();
			}
		} catch (Exception e) {
			System.out.println("Houve um problema enquanto fechávamos a conexão. Tente novamente." + e.getMessage());
		}
	}
	
	

	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("CT0001 - Testar criação de cadastro de Planos")
	void testSalvarPlano() {
		System.out.println("Testando salvar planos");
		Plano p1 = new Plano();
		p1.setNome("PetPass");
		p1.setPreco(50.00);
		p1.setPacoteInicialCredito(50);

		Plano p2 = new Plano();
		p2.setNome("PetPass Gold");
		p2.setPacoteInicialCredito(100);
		p2.setPreco(75.00);

		Plano p3 = new Plano();
		p3.setNome("PetPass Platinum");
		p3.setPacoteInicialCredito(300);
		p3.setPreco(200.00);

		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		
		String hql = "select p from Plano p where p.nome=:nome";
		@SuppressWarnings("unchecked")
		Query<Plano> query = session.createQuery(hql);
		query.setString("nome", "%Go%");
		Plano planoQuery = (Plano) query.uniqueResult();
		
		Assertions.assertEquals("PetPass Gold", planoQuery.getNome(), "Testando criação de Plano");
		System.out.println("Teste de criar Planos realizado");
	}

	

	@Test
	@DisplayName("CT0002 - Testar seleção de Plano")
	void testGetPlanoById() {
		String hql = "select p from Plano p where p.codigoPlano=:codigoPlano";
		Query<Plano> query = searchEngine("PetPass Gold");
		Plano planoQuery = (Plano) query.uniqueResult();
		
		Assertions.assertEquals("PetPass Gold", planoQuery.getNome(), "Testando criação de Plano");
	}

	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("CT0003 - Testar Listagem de Planos")
	void testListarAll() {
		
		Criteria list = session.createCriteria(Plano.class);
		List<Plano> plano = list.list();
		
		assertEquals(3, plano.size());
	}

	@Test
	@DisplayName("CT0001 - Testar edição de cadastro de Planos")
	void testUpdatePlano() {

		Query<Plano> query = searchEngine("PetPass Gold");
		Plano planoUpdate = (Plano) query.uniqueResult();
		planoUpdate.setPreco(120.00);
		
		session.update(planoUpdate);
		
		planoUpdate = (Plano) query.uniqueResult();
		
		assertEquals(120.00, planoUpdate.getPreco());	
		
	}

	@Test
	@DisplayName("CT0001 - Testar função de deletar cadastro de Planos")
	void testDeletarPlano() {
		
		Query<Plano> query = searchEngine("PetPass Platinum");		
		Plano planoDelete = (Plano) query.uniqueResult();
		session.delete(planoDelete);
		
		assertNotNull(planoDelete);
		
	}

	private Query<Plano> searchCPF(String parameter) {
		String hql = "select p from Plano p where p.codig=:nome";
		Query<Plano> query = session.createQuery(hql);
		query.setString("nome", "%"+parameter+"%");
		return query;
		
	private Query<Plano> searchEngine(String parameter) {
		String hql = "select p from Plano p where p.codig=:nome";
		Query<Plano> query = session.createQuery(hql);
		query.setString("nome", "%"+parameter+"%");
		return query;
	}

	@Test
	void testAcharPlano() {
		fail("Not yet implemented");
	}

}
