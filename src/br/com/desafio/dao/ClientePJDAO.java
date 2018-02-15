package br.com.desafio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.desafio.to.ClientePJ;

/**
 * Representa o DAO da classe Cliente Pessoa Juridica
 * 
 * @author PEDRO HENRIQUE
 *
 */
public class ClientePJDAO {
	private Connection conn = null;

	public ClientePJDAO() {
		ConnectionManager.getInstance();
		conn = ConnectionManager.getConnection();
	}

	/**
	 * Lista os clientes com ID (1500-2700) e SALDO (< 500) direto do BANCCO DE
	 * DADOS
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ClientePJ> listaClientesPJMedia() throws SQLException {
		String sql = "SELECT id_customer, cpf_cnpj, nm_customer, is_active, vl_total FROM tb_customer_account WHERE cpf_cnpj LIKE '%/%' AND id_customer >= 1500 AND id_customer <= 2700 AND vl_total >= 560";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<ClientePJ> lista = new ArrayList<ClientePJ>();
		ClientePJ cliente = null;
		while (rs.next()) {
			cliente = new ClientePJ();
			cliente.setId(rs.getInt(1));
			cliente.setCnpj(rs.getString(2));
			cliente.setNome(rs.getString(3));
			if (rs.getInt(4) == 0) {
				cliente.setAtivo(false);
			} else {
				cliente.setAtivo(true);
			}
			cliente.setSaldo(rs.getDouble(5));

			lista.add(cliente);
		}
		rs.close();
		ps.close();
		conn.close();

		return lista;
	}
}
