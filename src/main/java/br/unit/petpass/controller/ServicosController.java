package br.unit.petpass.controller;

import java.util.List;

import br.unit.petpass.entities.Plano;
import br.unit.petpass.entities.Servicos;
import br.unit.petpass.exception.ServicosException;
import br.unit.petpass.repository.ServicosHibernateDAO;

public class ServicosController {
	private static ServicosHibernateDAO servicosHibernateDAO;
	
	public ServicosController() {
		servicosHibernateDAO = new ServicosHibernateDAO();
	}

	public boolean salvar(Servicos servicos) {
		servicosHibernateDAO.salvarServicos(servicos);
		return true;
	}

	public void criarServicos(Servicos servicos) {
		Servicos verificaServicos = servicosHibernateDAO.acharServicos(servicos.getCodigoServicos());
		if (verificaServicos != null) {
			throw new ServicosException("Seriço já cadastrado.");
		}
		validaServicos(servicos);
		servicosHibernateDAO.salvarServicos(servicos);
	}

	public List<Servicos> listAll() {
		return servicosHibernateDAO.listAll();
	}

	public void atualizarServicos(Integer codigoServicos) {
		servicosHibernateDAO.updateServicos(codigoServicos);
	}

	public void deletarServicos(Integer codigoServicos) {
		servicosHibernateDAO.deletarServicos(codigoServicos);
	}

	public Servicos getServicos(Integer codigoServicos) {
		return servicosHibernateDAO.acharServicos(codigoServicos);
	}

	private void validaServicos(Servicos servicos) {
		if (servicos.getCustoCredito() < 5.00) {
			throw new ServicosException("Operação não é válida. Custo de servico abaixo do permitido.");
		}
	}

}
