package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Plano;

public class PlanoHibernateDAO {

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

		Plano pl = findById(id);
		pl.setNome(newName);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(pl);
		transaction.commit();
	}
	
	public void updatePriceOfPlan(Integer id, Double preco) {

		Plano pl = findById(id);
		pl.setPreco(preco);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(pl);
		transaction.commit();
	}
	
	public void updateInitialCreditOfPlan(Integer id, String newName) {

		Plano pl = findById(id);
		pl.setNome(newName);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(pl);
		transaction.commit();
	}
	
	public void updatePlanStatus(Integer id, Integer status) {

		Plano pl = findById(id);
		pl.setStatusPlano(status);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(pl);
		transaction.commit();
	}

	public void deleteById(Integer id) {
		Plano pl = findById(id);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(pl);
		transaction.commit();
	}
}
