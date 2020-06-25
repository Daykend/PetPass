package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Pet;
import br.unit.petpass.entities.Plano;

public class PlanoHibernateDAO {

	static Session session;

	public void salvarPlano(Plano plano) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(plano);
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

	public Plano getPlanoById(Integer codigoPlano) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select pl from Plano pl where pl.id = " + codigoPlano);
			List<Plano> plano = query.list();
			if (plano.size() > 0) {
				return plano.get(0);
			}
			else {
				return null;
			}
		} catch(Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	public List<Plano> listarAll() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "select pl from Plano pl";
			Query<Plano> query = session.createQuery(hql);
			return query.getResultList();
		
	}
	
	public void updatePlano(Plano plano) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(plano);
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
	
	public void deletarPlano(Plano plano) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.delete(plano);
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
	
	public Plano acharPlano(Integer codigoPlano) {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select pl from Plano pl where pl.codigoPlano = " + codigoPlano);
			List<Plano> plano = query.list();
			if (plano.size() > 0) {
				return plano.get(0);
			}
			else {
				return null;
			}
		} catch(Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}	
}