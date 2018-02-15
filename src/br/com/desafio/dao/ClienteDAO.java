package br.com.desafio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * Representa o DAO da classe Cliente
 * 
 * @author PEDRINHO
 *
 */
public class ClienteDAO {
	private Connection conn = null;

	public ClienteDAO() {
		ConnectionManager.getInstance();
		conn = ConnectionManager.getConnection();
	}

	/**
	 * Metodo para inserir dados com valores aleatórios na tabela de CLIENTES no
	 * BANCO DE DADOS
	 * 
	 * @throws SQLException
	 */
	public void insereClientes() throws SQLException {
		PreparedStatement ps = null;
		String sql = null;
		Random gerador = new Random();

		// ID menor que 1500
		// PESSOA FISICA
		for (int i = 1; i < 6; i++) {
			sql = "INSERT INTO tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ps.setString(2, "123.123.123-" + i);
			ps.setString(3, "Cliente000" + i);
			ps.setInt(4, gerador.nextInt(2));
			ps.setInt(5, gerador.nextInt(1000));

			ps.executeUpdate();
		}

		// PESSOA JURIDICA
		for (int i = 10; i < 16; i++) {
			sql = "INSERT INTO tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ps.setString(2, "12.123.123/0000-" + i);
			ps.setString(3, "Cliente000" + i);
			ps.setInt(4, gerador.nextInt(2));
			ps.setInt(5, gerador.nextInt(1000));

			ps.executeUpdate();
		}

		// ID maior que 1500
		int numero;
		// PESSOA FISICA
		for (int i = 0; i < 5; i++) {
			numero = gerador.nextInt((2700 - 1500) + 1) + 1500;
			sql = "INSERT INTO tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, numero);
			ps.setString(2, "123.123.123-" + numero);
			ps.setString(3, "Cliente" + numero);
			ps.setInt(4, gerador.nextInt(2));
			ps.setInt(5, gerador.nextInt(1000));

			ps.executeUpdate();
		}

		// PESSOA JURIDICA
		for (int i = 0; i < 5; i++) {
			numero = gerador.nextInt((2700 - 1500) + 1) + 1500;
			sql = "INSERT INTO tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, numero);
			ps.setString(2, "12.123.123/0000-" + numero);
			ps.setString(3, "Cliente" + numero);
			ps.setInt(4, gerador.nextInt(2));
			ps.setInt(5, gerador.nextInt(1000));

			ps.executeUpdate();
		}
		ps.close();
		conn.close();
	}

	/**
	 * Metodo para deletar todos dados da tabela de CLIENTES no BANCO DE DADOS
	 * 
	 * @throws SQLException
	 */
	public void deletaTodosClientes() throws SQLException {
		String sql = "DELETE FROM tb_customer_account";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
}
