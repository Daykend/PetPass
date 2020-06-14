package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import br.unit.petpass.entities.Empresa;

public class EmpresaHibernateDAO {
	static Session session;
	
	public void salvar(Empresa empresa) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(empresa);
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
	
	public List<Empresa> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select c from Empresa c";
		Query<Empresa> query = session.createQuery(hql);
		return query.getResultList();

	}
	
	public void updateEmpresa(Empresa empresa) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(empresa);
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
	
	
	public void deletarEmpresa(Empresa empresa) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.delete(empresa);
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
	
	public Empresa acharEmpresa(Integer id) {
	
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select e from Empresa e where e.id = " + id);
			List<Empresa> empresa = query.list();
			if (empresa.size() > 0) {
				return empresa.get(0);
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
