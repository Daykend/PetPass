package br.unit.petpass.controller;

import java.util.List;

import br.unit.petpass.entities.Plano;
import br.unit.petpass.exception.ServicosException;
import br.unit.petpass.repository.PlanoHibernateDAO;

public class PlanoController {

	private static PlanoHibernateDAO planoHibernateDAO;

	public static boolean salvarPlano(Plano plano) {
		validaPlano(plano);
		planoHibernateDAO.salvarPlano();
		return true;
	}
	
	public static void criarPlano(Plano plano) {
		Plano verificaPlano = planoHibernateDAO.acharPlano(plano.getCodigoPlano());
		if (verificaPlano != null) {
			throw new ServicosException("Plano j� cadastrado.");
		}
		validaPlano(plano);
		planoHibernateDAO.salvarPlano();
	}

	public static List<Plano> listar() {
		return planoHibernateDAO.listarAll();
	}

	public static void atualizar(Plano plano) {

		planoHibernateDAO.updatePlano(plano);
	}

	public void deletar(Plano plano) {

		planoHibernateDAO.deletarPlano(plano);
	}



	public Plano getPlano(Integer codigoPlano) {
		return planoHibernateDAO.acharPlano(codigoPlano);
	}

	private static void validaPlano(Plano plano) {
		if (plano.getPacoteInicialCredito() < 1000.00) {
			throw new ServicosException("Opera��o n�o � v�lida. Pacote inicial a cima do m�ximo permitido.");
		}
		if (plano.getPreco() < 50.00) {
			throw new ServicosException("Opera��o n�o � v�lida. Pre�o abaixo do m�nimo permitido.");
		}
	}
}