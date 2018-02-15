package br.com.desafio.bo;

import java.sql.SQLException;

import br.com.desafio.dao.ClienteDAO;

/**
 * Camada de negocio de Cliente
 * 
 * @author PEDRO HENRIQUE
 *
 */
public class ClienteBO {
	public void insereClientes() throws SQLException {
		new ClienteDAO().insereClientes();
	}

	public void deletaTodosClientes() throws SQLException {
		new ClienteDAO().deletaTodosClientes();
	}
}
