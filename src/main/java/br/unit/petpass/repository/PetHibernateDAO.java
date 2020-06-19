package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Pet;

public class PetHibernateDAO {
	
	static Session session;

	public boolean inserirPet(Pet pet) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(pet);
			transaction.commit();
			System.out.println("Pet " + pet.getNome() + " salvo com sucesso");
			System.out.println("\n\n");
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Pet getPetById(Integer codigoPet) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Pet tmppet = session.load(Pet.class, codigoPet);
			return tmppet;
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Pet> getAllPets() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select p from Pet p";
		Query<Pet> query = session.createQuery(hql);
		return query.getResultList();
	}
	
	public List<Pet> getPetsCliente(Integer codigoCliente) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select p from Pet p where fkcliente =" + codigoCliente;
		Query<Pet> query = session.createQuery(hql);
		return query.getResultList();
	}

}
