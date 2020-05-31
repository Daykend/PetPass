package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Empresa;

public class ServicosHibernate {

	public void salvar(Empresa empresa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(empresa);
		transaction.commit();

	}

	public List<Empresa> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select c from Empresa c";
		Query<Empresa> query = session.createQuery(hql);
		return query.getResultList();

	}

	public Empresa findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select p from Empresa p where p.codigoEmpresa = :id";
		Query<Empresa> query = session.createQuery(hql);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public void updateCompanyName(Integer id, String newName) {

		findById(id).setNome(newName);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updateCompanyPhone(Integer id, String telefone) {

		findById(id).setTelefone(telefone);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updateCompanyAddress(Integer id, String endereco) {

		findById(id).setEndereco(endereco);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updateCompanyStatus(Integer id, boolean status) {

		findById(id).setStatusEmpresa(status);

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
