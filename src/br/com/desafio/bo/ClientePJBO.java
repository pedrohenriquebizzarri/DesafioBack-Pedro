package br.com.desafio.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.desafio.dao.ClientePJDAO;
import br.com.desafio.to.ClientePJ;

/**
 * Camada de negocio de Cliente Pessoa Juridica
 * 
 * @author PEDRO HENRIQUE
 *
 */
public class ClientePJBO {
	public ArrayList<ClientePJ> listaClientesPJMedia() throws SQLException {
		return new ClientePJDAO().listaClientesPJMedia();
	}
}
