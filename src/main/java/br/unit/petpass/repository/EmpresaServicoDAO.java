package br.unit.petpass.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.unit.petpass.entities.Servicos;

public class EmpresaServicoDAO {
	static Session session;
	
	public List<Servicos> listAll3() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select c from EmpresaServicos c";
		Query<Servicos> query = session.createQuery(hql);
		return query.getResultList();
	}

}
