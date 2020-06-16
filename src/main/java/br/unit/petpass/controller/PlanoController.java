package br.unit.petpass.controller;

import java.util.List;

import br.unit.petpass.entities.Plano;
import br.unit.petpass.exception.ServicosException;
import br.unit.petpass.repository.PlanoHibernateDAO;

public class PlanoController {

	private static PlanoHibernateDAO planoHibernateDAO;
	
	public PlanoController() {
		planoHibernateDAO = new PlanoHibernateDAO();
	}

	public boolean salvarPlano(Plano plano) {
		validaPlano(plano);
		planoHibernateDAO.salvarPlano(plano);
		return true;
	}

	public static List<Plano> listar() {
		return planoHibernateDAO.listarAll();
	}

	public void atualizar(Plano plano) {
		planoHibernateDAO.updatePlano(plano);
	}

	public void deletar(Plano plano) {
		planoHibernateDAO.deletarPlano(plano);
	}


	public Plano getPlano(Integer codigoPlano) {
		return planoHibernateDAO.acharPlano(codigoPlano);
	}

	private void validaPlano(Plano plano) {
		if (plano.getPacoteInicialCredito() > 1000.00) {
			throw new ServicosException("Operação não é válida. Pacote inicial a cima do máximo permitido.");
		}
		if (plano.getPreco() < 50.00) {
			throw new ServicosException("Operação não é válida. Preço abaixo do mínimo permitido.");
		}
	}
}