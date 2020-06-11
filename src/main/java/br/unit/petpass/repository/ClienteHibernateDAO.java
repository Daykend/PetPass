package br.unit.petpass.repository;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Cliente;

public class ClienteHibernateDAO {

	public void salvarCliente(Cliente cliente) {
		
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();  
			session.save(cliente);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
			  transaction.rollback();
			}
		}
	}
	
	public void updateCliente(Cliente cliente) {
			
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();  
			session.saveOrUpdate(cliente);;
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
			  transaction.rollback();
			}
		}
	}
	public Cliente getClientById(Integer codigoCliente) {
			
			Transaction transaction = null;
			Cliente cliente = null;
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				transaction = session.beginTransaction();  
				cliente = session.get(Cliente.class, codigoCliente);
				transaction.commit();
			} catch (Exception e) {
				if(transaction != null) {
				  transaction.rollback();
				}
			}
			return cliente;
		}
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllClients(Integer codigoCliente) {
		
		Transaction transaction = null; 
		List<Cliente> cliente = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();  
			cliente = session.createQuery("FROM CLIENTE").list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
			  transaction.rollback();
			}
		}
		return cliente;
	}	
	

	public void deletarCliente (Integer codigoCliente) {
		
		Transaction transaction = null;
		Cliente cliente = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();  
			cliente = session.get(Cliente.class, codigoCliente);
			session.delete(cliente);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
			  transaction.rollback();
			}
		}
}
}
