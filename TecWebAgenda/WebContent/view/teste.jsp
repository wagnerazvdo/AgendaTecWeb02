<%@page import="model.Contato"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
</head>
<body>
<form action="InserirContato" method="post">
nome: <input type="text" name="nome"> <br>
e-mail: <input type="email" name="email"><br>
Telefone: <input type="tel" name="telefone"><br>
<input type="submit" value="Cadastrar">
</form>
</body>
</html>