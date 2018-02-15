package br.com.desafio.calculo;

import java.util.ArrayList;

import br.com.desafio.to.ClientePF;
import br.com.desafio.to.ClientePJ;

/**
 * Responsavel por realizar os calculos do sistema
 * 
 * @author PEDRO HENRIQUE
 *
 */
public class Calculo {
	/**
	 * Calcula a media do saldo de todos os clientes
	 * 
	 * @param listaPF
	 *            Lista de Clientes de Pessoa Fisica
	 * @param listaPJ
	 *            Lista de Clientes de Pessoa Juridica
	 * @return Media solicitada
	 */
	public double calculaMediaSaldo(ArrayList<ClientePF> listaPF, ArrayList<ClientePJ> listaPJ) {
		int soma = 0;
		int q = 0;
		for (int i = 0; i < listaPF.size(); i++) {
			soma += listaPF.get(i).getSaldo();
			q++;
		}

		for (int i = 0; i < listaPJ.size(); i++) {
			soma += listaPJ.get(i).getSaldo();
			q++;
		}

		return soma / q;
	}
}
