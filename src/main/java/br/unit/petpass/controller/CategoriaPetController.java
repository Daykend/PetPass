package br.unit.petpass.controller;

import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.repository.CategoriaPetHibernateDAO;

public class CategoriaPetController {
private static CategoriaPetHibernateDAO categoriaPetHibernateDAO;
	
	public CategoriaPetController() {
		categoriaPetHibernateDAO = new CategoriaPetHibernateDAO();
	}
	
	public CategoriaPet getCategoriaById(Integer codigoCategoria) {
		return categoriaPetHibernateDAO.findById(codigoCategoria);
	}

}
