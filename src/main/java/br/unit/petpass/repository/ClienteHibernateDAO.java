package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Empresa;

public class ClienteHibernateDAO {
	static Session session;

	public void salvarCliente(Cliente cliente) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(cliente);
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

	public void updateCliente(Cliente cliente) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(cliente);
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

	public Cliente getClientById(Integer codigoCliente) {

		Transaction transaction = null;
		Cliente cliente = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			cliente = session.get(Cliente.class, codigoCliente);
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
		return cliente;
	}

	public List<Cliente> getAllClients() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select c from Cliente c";
		Query<Cliente> query = session.createQuery(hql);
		return query.getResultList();
	}

	public void deletarCliente(Cliente cliente) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			cliente = session.get(Cliente.class, cliente);
			session.delete(cliente);
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

	/*
	 * public boolean ativa(String contaValida) { Cliente cliente =
	 * getClientById(codigoCliente); if (cliente != null) { return true; } return
	 * false; }
	 */


}
