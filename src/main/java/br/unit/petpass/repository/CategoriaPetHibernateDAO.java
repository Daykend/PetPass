package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.repository.HibernateUtil;
import br.unit.petpass.repository.CategoriaPetHibernateDAO;

public class CategoriaPetHibernateDAO {

	public void salvar(CategoriaPet categoria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(categoria);
		transaction.commit();

	}

	public List<CategoriaPet> listarTodos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select c from CategoriaPet c";
		Query<CategoriaPet> query = session.createQuery(hql);
		return query.getResultList();

	}

	public CategoriaPet findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select c from CategoriaPet c where c.codigoCategoria = :id";
		Query<CategoriaPet> query = session.createQuery(hql);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public void updateById(Integer id, String newType) {

		CategoriaPet catPet = findById(id);
		catPet.setTipo(newType);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(catPet);
		transaction.commit();
	}

	public void deleteById(Integer id) {
		CategoriaPet catPet = findById(id);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(catPet);
		transaction.commit();
	}

}
