<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Usuario</title>
</head>
<body>
<center><h1>Cadastro de usuario</h1></center>
<link rel="stylesheet" type="text/css" href="resources/css/cadastro.css">

<form action="salvarUsuario" method="Post">
<ul class="form-style-1">
<li>
<table>
<tr>
<td>Codigo:</td>
<td><input type="text"  readonly="readonly" id="id"  name="id" value="${user.id }"></td>
</tr>

<tr>
<td>Login:</td>
<td><input type="text" id="login" name="login" value="${user.login }"></td>
</tr>

<tr>
<td>Senha:</td>
<td><input type="password" id="senha" name="senha" value="${user.senha }"></td>
</tr>
<tr>
<td>Nome:</td>
<td><input type="text" id="nome" name="nome" value="${user.nome }"></td>
</tr>
</table>
<center><input type="submit" value="Salvar"></center>
</li>
</ul>
</form>
<div class="content">
<table class="rTable">
<caption>Usuários Cadastrados</caption>

<tr>
    <th>Id</th>
    <th>Login</th>
    <th>Nome</th>
    <th>Delete</th>
    <th>Editar</th>
</tr>

<c:forEach  items="${usuarios}" var="user" >
<tr>
<td style="with:150px"><c:out value="${user.id}"></c:out></td>
<td style="with:150px"><c:out value="${user.login}"></c:out></td>
<td><c:out value="${user.nome}"></c:out></td>
<td><a href="salvarUsuario?acao=delete&user=${user.login }"><img src="resources/img/delete.png" with="20px" height="20px" alt="excluir" title="excluir"></a></td>
<td><a href="salvarUsuario?acao=editar&user=${user.login }"><img src="resources/img/editar.png" with="20px" height="20px"></a></td>
</tr>
</c:forEach>

</table>
</div>


</body>
</html>