package br.com.desafio.to;

/**
 * Representa um Cliente de uma Pessoa Juridica
 * 
 * @author PEDRO HENRIQUE
 *
 */
public class ClientePJ extends Cliente {
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
