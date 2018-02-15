package br.com.desafio.to;

/**
 * Representa um Cliente de uma Pessoa Fisica
 * 
 * @author PEDRO HENRIQUE
 *
 */
public class ClientePF extends Cliente {
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
