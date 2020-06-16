package br.unit.petpass.controller;

import java.util.List;

import br.unit.petpass.entities.Empresa;
import br.unit.petpass.repository.EmpresaHibernateDAO;

public class EmpresaController {

	private static EmpresaHibernateDAO empresaHibernateDAO;

	public EmpresaController() {
		empresaHibernateDAO = new EmpresaHibernateDAO();
	}

	public static boolean salvar(Empresa empresa) {

		empresaHibernateDAO.salvar(empresa);
		return true;
	}

	public List<Empresa> listarEmpresa() {
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
