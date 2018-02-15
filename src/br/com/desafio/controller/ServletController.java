package br.com.desafio.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desafio.bo.ClientePFBO;
import br.com.desafio.bo.ClientePJBO;
import br.com.desafio.calculo.Calculo;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/controle")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sessao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcao = request.getParameter("opt");

		switch (opcao) {
		case "1":
			retornaClientes(request, response);
			break;
		case "2":
			retornaMedia(request, response);
			break;
		}
	}

	protected void retornaClientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sessao = request.getSession(true);
		try {
			sessao.setAttribute("ListaClientesPF", new ClientePFBO().listaClientesPFMedia());
			sessao.setAttribute("ListaClientesPJ", new ClientePJBO().listaClientesPJMedia());
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ServletErro().erro(request, response, "ERRO AO CALCULAR MÉDIA",
					"O erro pode ter sido ocasionado devido a uma falha interna do sistema. TENTE NOVAMENTE");
		}
	}

	protected void retornaMedia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sessao = request.getSession(true);
		try {
			sessao.setAttribute("MediaClientes", new Calculo().calculaMediaSaldo(
					new ClientePFBO().listaClientesPFMedia(), new ClientePJBO().listaClientesPJMedia()));
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ServletErro().erro(request, response, "ERRO AO CALCULAR MÉDIA",
					"O erro pode ter sido ocasionado devido a uma falha interna do sistema. TENTE NOVAMENTE");
		}
	}
}
