<%@page import="dao.JDBCContatoDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="dao.FabricaConexao"%>
<%@page import="model.Contato"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listas de Contatos</title>
</head>
<body>

	<%
		FabricaConexao fabrica = new FabricaConexao();
		java.sql.Connection conexao = fabrica.fazConexao();

		JDBCContatoDAO dao = new JDBCContatoDAO(conexao);

		java.util.List<Contato> contatos = dao.listarTodos();

		fabrica.fecharConexao();
	%>
	<table border="1" cellpadding="10">

		<tr>
			<th>Nome:</th>
			<th>E-mail</th>
			<th>Telefone:</th>
		</tr>

		<% for(Contato c:contatos){ %>
		<tr>
		
			<td><%= c.getNome() %></td>
			<td><%= c.getEmail() %></td>
			<td><%= c.getTelefone() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>