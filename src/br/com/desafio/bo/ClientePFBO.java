package br.com.desafio.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.desafio.dao.ClientePFDAO;
import br.com.desafio.to.ClientePF;

/**
 * Camada de negocio de Cliente Pessoa Fisica
 * 
 * @author PEDRO HENRIQUE
 *
 */
public class ClientePFBO {
	public ArrayList<ClientePF> listaClientesPFMedia() throws SQLException {
		return new ClientePFDAO().listaClientesPFMedia();
	}
}
