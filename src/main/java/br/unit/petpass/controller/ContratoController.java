package br.unit.petpass.controller;

import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.repository.ContratoHibernateDAO;

public class ContratoController {
	private static ContratoHibernateDAO contratoHibernateDAO;
	
	public ContratoController() {
		contratoHibernateDAO = new ContratoHibernateDAO();
	}
	
	public boolean salvarContrato(Contrato contrato) {
		contratoHibernateDAO.salvarContrato(contrato);
		return true;
	}
	
	public static List<Contrato> getAllContratos() {
		return contratoHibernateDAO.getAllContratos();
	}
	
	public Contrato getContratoById(Integer codigoContrato) {
		return contratoHibernateDAO.getContratoById(codigoContrato);
	}
	
	public static List<Contrato> getContratos() {
		return contratoHibernateDAO.getContratos();
	}

}
