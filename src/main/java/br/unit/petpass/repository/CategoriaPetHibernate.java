package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.repository.HibernateUtil;
import br.unit.petpass.repository.CategoriaPetHibernate;

public class CategoriaPetHibernate {

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
		
		findById(id).setTipo(newType);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(findById(id));
		transaction.commit();
	}

	public static void main(String[] args) {
		CategoriaPetHibernate reporCategoriaHibernate = new CategoriaPetHibernate();

		CategoriaPet categoria1 = new CategoriaPet(4, "Gato");
		reporCategoriaHibernate.salvar(categoria1);

		CategoriaPet categoria2 = new CategoriaPet(5, "Ave");
		reporCategoriaHibernate.salvar(categoria2);

		CategoriaPet categoria3 = new CategoriaPet(6, "Réptil");
		reporCategoriaHibernate.salvar(categoria3);

		List<CategoriaPet> listaDeCategoriaPet = reporCategoriaHibernate.listarTodos();
		for (CategoriaPet categorias : listaDeCategoriaPet) {
			System.out.println(categorias);
		}

		reporCategoriaHibernate.updateById(5, "Passarinho");

		CategoriaPet categoriaX = reporCategoriaHibernate.findById(5);
		System.out.println(categoriaX);
	}
}
