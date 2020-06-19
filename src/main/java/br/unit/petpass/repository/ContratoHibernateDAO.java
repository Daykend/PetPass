package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Cliente;


public class ContratoHibernateDAO {
	static Session session;
	
	public void salvarContrato(Contrato contrato) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(contrato);
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

	public List<Contrato> getAllContratos() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from Contrato").list();
			 
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
	
	public List<Contrato> getContratos() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from Contrato co inner join co.cliente").list();
			 
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
	public Contrato getContratoById(Integer codigoContrato) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select e from Contrato e where e.id = " + codigoContrato);
			List<Contrato> contrato = query.list();
			if (contrato.size() > 0) {
				return contrato.get(0);
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
	public void updateContrato(Contrato contrato) {
        Transaction transaction = null;
       
   
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(contrato);
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
