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
<center>
<h1>Cadastro de usuario</h1>
<h3 style="color:red;">${msg}</h3>
</center>

<link rel="stylesheet" type="text/css" href="resources/css/cadastro.css">
	
<form action="salvarUsuario" method="Post" id="formUser"
      onsubmit="return validarCampos() ? true : false;">
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
<tr>
     <td></td>
     <td>
     <input type="submit" value="Salvar">
     <input type="submit" value="Cancelar" onclick="document.getElementById('formUser').action = 'salvarUsuario?acao=reset'">
     </td>
</tr>
</table>

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
<td><a href="salvarUsuario?acao=delete&user=${user.id }"><img src="resources/img/deletar.png" with="20px" height="20px" alt="excluir" title="excluir"></a></td>
<td><a href="salvarUsuario?acao=editar&user=${user.id }"><img src="resources/img/editar.png" with="20px" height="20px" alt="Editar" title="Editar"></a></td>


</tr>
</c:forEach>

</table>
</div>
<script type="text/javascript">
		function validarCampos() {
			if (document.getElementById("login").value == '') {
				alert('Informe o Login');
				return false;
			} else if (document.getElementById("senha").value == '') {
				alert('Informe o Senha');
				return false;
			} else if (document.getElementById("nome").value == '') {
				alert('Informe o Nome');
				return false;
			} 
			
			return true;
		}
	</script>



</body>
</html>