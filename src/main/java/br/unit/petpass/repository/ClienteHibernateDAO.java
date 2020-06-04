package br.unit.petpass.repository;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Cliente;

public class ClienteHibernateDAO {

	public void salvar(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(cliente);
		transaction.commit();

	}

	public List<Cliente> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select c from Cliente c";
		Query<Cliente> query = session.createQuery(hql);
		return query.getResultList();

	}

	public Cliente findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select p from Cliente p where p.codigoCliente = :id";
		Query<Cliente> query = session.createQuery(hql);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public void updateClientName(Integer id, String newName) {

		findById(id).setNome(newName);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}

	public void updateClientPhone(Integer id, String telefone) {

		findById(id).setTelefone(telefone);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}

	public void updateClientAddress(Integer id, String endereco) {

		findById(id).setEndereco(endereco);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updateClientCPF(Integer id, String endereco) {

		findById(id).setCpf(endereco);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updateClientDateOfBirth(Integer id, LocalDate dtNascimento) {

		findById(id).setDtNascimento(dtNascimento);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updateClientSex(Integer id, String sexo) {

		findById(id).setSexo(sexo);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updateClientEmail(Integer id, String email) {

		findById(id).setEmail(email);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updateClientRG(Integer id, String rg) {

		findById(id).setRg(rg);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}

	public void updateClientStatus(Integer id, Integer status) {

		findById(id).setStatusCliente(status);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}

	public void deleteById(Integer id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(findById(id));
		transaction.commit();
	}

}
