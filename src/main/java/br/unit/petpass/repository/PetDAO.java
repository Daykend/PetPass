package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Pet;

public class PetDAO {
	
static Session session;
	
	public void salvarPet(Pet pet) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(pet);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
//	public List<Pet> getAllPets() {
//
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		String hql = "select p from Pet p where fkcliente = 10";
//		Query<Pet> query = session.createQuery(hql);
//		return query.getResultList();
//	}

	public List<Pet> getAllPets() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("select codigopet, nome, sexo_pet from Pet").list();
			 
		} catch(Exception sqlException) {
            if(null != session.getTransaction()) {
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
            return null;
        } finally {
            if(session != null) {
            	session.close();
            }
        }
	}

}
