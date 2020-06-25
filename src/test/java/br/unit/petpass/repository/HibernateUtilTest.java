package br.unit.petpass.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unit.petpass.entities.Cliente;

class HibernateUtilTest {
	private static SessionFactory sessionFactory;
	private Session session;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println("SessionFactory Created");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		sessionFactory.close();
		System.out.println("SessionFactory Destroyed");
	}

	@BeforeEach
	void setUp() throws Exception {
		session = sessionFactory.openSession();
		System.out.println("Session Created");
		}

	@AfterEach
	void tearDown() throws Exception {
		sessionFactory.close();
		System.out.println("Session Destroyed");
	}

}
