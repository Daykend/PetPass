package br.unit.petpass.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Empresa;
import br.unit.petpass.exception.ClienteException;
import br.unit.petpass.repository.EmpresaHibernateDAO;

public class EmpresaController {

	private EmpresaHibernateDAO empresaHibernateDAO;

	public EmpresaController() {
		empresaHibernateDAO = new EmpresaHibernateDAO();
	}

	public boolean salvar(Empresa empresa) {

		empresaHibernateDAO.salvar(empresa);
		return true;
	}

	public List<Empresa> listar() {
		return empresaHibernateDAO.listAll();
	}

	public void atualizar(Empresa empresa) {

		empresaHibernateDAO.updateEmpresa(empresa);
	}

	public void deletar(Empresa empresa) {

		empresaHibernateDAO.deletarEmpresa(empresa);
	}

	public Empresa getEmpresa(Integer id) {
		return empresaHibernateDAO.acharEmpresa(id);
	}

}
