package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Cliente;
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

public Plano getPlanoById(Integer codigoPlano) {

	Transaction transaction = null;
	Plano plano = null;

	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		transaction = session.beginTransaction();
		plano = session.get(Plano.class, codigoPlano);
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
		}
	}
	return plano;
}


public List<Plano> getAllPlano(Integer codigoPlano) {

	Transaction transaction = null;
	List<Plano> plano = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		transaction = session.beginTransaction();
		plano = session.createQuery("FROM PLANO").list();
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
		}
	}
	return plano;
}

public void deletarPlano(Integer codigoPlano) {

	Transaction transaction = null;
	Plano plano = null;

	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		transaction = session.beginTransaction();
		plano = session.get(Plano.class, codigoPlano);
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
}