package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Plano;

public class PlanoHibernate {

	public void salvar(Plano plano) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(plano);
		transaction.commit();

	}

	public List<Plano> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select c from Plano c";
		Query<Plano> query = session.createQuery(hql);
		return query.getResultList();

	}

	public Plano findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select p from Plano p where p.codigoPlano = :id";
		Query<Plano> query = session.createQuery(hql);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public void updatePlanName(Integer id, String newName) {

		findById(id).setNome(newName);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updatePiceOfPlan(Integer id, Double preco) {

		findById(id).setPreco(preco);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updateInitialCreditOfPlan(Integer id, String newName) {

		findById(id).setNome(newName);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(findById(id));
		transaction.commit();
	}
	
	public void updatePlanStatus(Integer id, boolean status) {

		findById(id).setStatusPlano(status);

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
