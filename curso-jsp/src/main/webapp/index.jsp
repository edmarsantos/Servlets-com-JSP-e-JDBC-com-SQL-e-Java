<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlets Jsp</title>

<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
	


</head>
<body>

	<div class="login-page">
		<div class="form">
		
	<h1>Bem Vindo ao Curso de JSP</h1>
	<%
	out.print("Sucesso Garantido");
	%>
		
			<form action="LoginServet" method="post" class="login-form">
				Login: <input type="text" id="login" name="login"> <br />
				Senha: <input type="password" id="senha" name="senha"> <br />
				<button type="submit" value="Logar">Logar</button>
			</form>
		</div>
	</div>

</body>
</html>