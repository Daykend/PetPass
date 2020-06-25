package br.unit.petpass.repository;

import static org.junit.jupiter.api.Assertions.fail;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Pet;
@DisplayName("Cenários_0002 - Testar Cadastro de Pets")
class PetDAOTest {
	PetDAOTest petDAO;
	Pet pet;

	private Transaction transaction;
	private Session session;
	
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
		pet = new Pet();
		System.out.println("====Início dos Testes de Cadastro dos Pets====");
		Cliente cliente = null;
		CategoriaPet categoriaPet = null;
		Integer codigoPet = -1;
//		new Pet(1, "Golden Retriever", "Xuxu", null, "F", cliente, categoriaPet);
		}

	
	
	@Test
	@DisplayName("CT0001 - Testar criação de cadastro de Categoria")
	void testSalvarPet() {
		System.out.println("Testando salvar Categorias");
		
		session.beginTransaction();
		
//		Pet petEsperado = new Pet(1, "Golden Retriever", "Xuxu", null, "F", cliente, categoriaPet);
//		Pet petReal = new Pet(1, "Golden Retriever", "Balu", null, "F", cliente, categoriaPet);
		
		session.getTransaction();
		
		Assertions.assertEquals(categoriaPetEsperado, categoriaPetReal, "Testando criação de Cadastro");
		System.out.println("Teste de criar Cadastros realizado");
	}

	@Test
	void testListAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUpdatePet() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetAllPets() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAcharPet() {
		fail("Not yet implemented"); // TODO
	}

}
