<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INICIO</title>

</head>
<body>
	<div>
		<h2>PAGINA WEB QUE RETORNA OS DADOS E A MÉDIA DE ACORDO COM ESTES
			REQUISITOS:</h2>
		<h3>- ID (1500-2700)</h3>
		<h3>- SALDO (MAIOR QUE 560)</h3>
	</div>

	<div>
		<fieldset>
			<div>
				<h4>Clientes - Pessoa Fisica</h4>

				<table border="1px">
					<tr>
						<td>ID</td>
						<td>CPF</td>
						<td>NOME</td>
						<td>ATIVO</td>
						<td>SALDO</td>
					</tr>
					<c:forEach items="${ListaClientesPF}" var="clientePF">
						<tr>
							<td>${clientePF.id}</td>
							<td>${clientePF.cpf}</td>
							<td>${clientePF.nome}</td>
							<c:choose>
								<c:when test="${clientePF.ativo == true}">
									<td>ATIVO</td>
								</c:when>
								<c:otherwise>
									<td>INATIVO</td>
								</c:otherwise>
							</c:choose>
							<td>R$ ${clientePF.saldo}0</td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<div>
				<h4>Clientes - Pessoa Juridica</h4>
				<table border="1px">
					<tr>
						<td>ID</td>
						<td>CPF</td>
						<td>NOME</td>
						<td>ATIVO</td>
						<td>SALDO</td>
					</tr>
					<c:forEach items="${ListaClientesPJ}" var="clientePJ">
						<tr>
							<td>${clientePJ.id}</td>
							<td>${clientePJ.cnpj}</td>
							<td>${clientePJ.nome}</td>
							<c:choose>
								<c:when test="${clientePJ.ativo == true}">
									<td>ATIVO</td>
								</c:when>
								<c:otherwise>
									<td>INATIVO</td>
								</c:otherwise>
							</c:choose>
							<td>R$ ${clientePJ.saldo}0</td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<br>
			<div>
				<a href="controle?opt=1"><input type="button"
					value="TRAZER DADOS"></a>
			</div>
		</fieldset>
	</div>

	<br>
	<div>
		<fieldset>
			<div>
				<h4>MEDIA - R$ ${MediaClientes}0</h4>
				<a href="controle?opt=2"><input type="button"
					value="CALCULAR MEDIA"></a>
			</div>
		</fieldset>
	</div>
</body>
</html>