package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Servicos;

public class ServicosHibernateDAO {
	
	static Session session;

	public void salvar(Servicos servicos) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(servicos);
		transaction.commit();

	}

	public List<Servicos> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select c from Servicos c";
		Query<Servicos> query = session.createQuery(hql);
		return query.getResultList();

	}

	public Servicos getServicosById(Integer codigoServicos) {

		Transaction transaction = null;
		Servicos servicos = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			servicos = session.get(Servicos.class, codigoServicos);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
				;
			}
		}
		return servicos;
	}

	public void updateServicosName(Integer codigoServicos, String newName) {

		getServicosById(codigoServicos).setNome(newName);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(getServicosById(codigoServicos));
		transaction.commit();
	}

	public void salvarServicos(Integer codigoServicos) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(codigoServicos);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				;
			}
		}
		return;
	}

	public void updateServicos(Integer codigoServicos) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(codigoServicos);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				;
			}
		}
		return;
	}

	public void deletarServicos(Integer codigoServicos) {

		Transaction transaction = null;
		Servicos servicos = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			servicos = session.get(Servicos.class, codigoServicos);
			session.delete(servicos);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
		if (session != null) {
			session.close();
			;
		}
	}
	return;
	}
	public Servicos acharServicos(Integer codigoServicos) {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select s from Servicos s where s.codigoServicos = " + codigoServicos);
			List<Servicos> servicos = query.list();
			if (servicos.size() > 0) {
				return servicos.get(0);
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
