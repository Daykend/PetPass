package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Raca;

public class RacaHibernateDAO {
	static Session session;
	
	public List<Raca> getAllRacas() {
		
		
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select r from Raca r";
		Query<Raca> query = session.createQuery(hql);
		return query.getResultList();
		}catch(Exception sqlException) {
			sqlException.printStackTrace();
			return null;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	public static Raca getRacaById(Integer codigoRaca) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select e from Raca e where e.id = " + codigoRaca);
			List<Raca> raca = query.list();
			if (raca.size() > 0) {
				return raca.get(0);
			}
			else {
				return null;
			}
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
