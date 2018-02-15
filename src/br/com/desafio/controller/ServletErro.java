package br.com.desafio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletErro
 */
@WebServlet("/ControleErro")
public class ServletErro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sessErro = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletErro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void erro(HttpServletRequest request, HttpServletResponse response, String erro, String detalhe)
			throws ServletException, IOException {
		sessErro = request.getSession(true);
		sessErro.setAttribute("Erro", erro);
		sessErro.setAttribute("Detalha", detalhe);
		response.sendRedirect("erro.jsp");
	}
}
