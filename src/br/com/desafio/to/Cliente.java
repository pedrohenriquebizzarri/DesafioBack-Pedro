package br.com.desafio.to;

/**
 * Representa um Cliente abstrato
 * 
 * @author PEDRO HENRIQUE
 *
 */
public abstract class Cliente {
	private int id;
	private String nome;
	private boolean ativo;
	private double saldo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
