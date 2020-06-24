package br.unit.petpass.controller;

import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Raca;
import br.unit.petpass.repository.RacaHibernateDAO;

public class RacaController {
	
	private static RacaHibernateDAO racaHibernateDAO;
	
	public RacaController() {
		racaHibernateDAO = new RacaHibernateDAO();
	}
	
	public static List<Raca> getAllRacas(){
		return racaHibernateDAO.getAllRacas();
	}
	public Raca getRacaById(Integer codigoRaca) {
		return RacaHibernateDAO.getRacaById(codigoRaca);
	}
	
}
