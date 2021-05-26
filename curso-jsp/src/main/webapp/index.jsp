<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
</head>
<body>
<h1>Bem Vindo ao Curso de JSP</h1>
<% out.print("Sucesso Garantido"); %>

<jsp:setProperty property="*" name="calcula"/>

<form action ="cabecalho.jsp" method="post">	
	
<input type="text" id="nome" name="nome" value="alex">

<input type="text" id="ano" name="ano" value="53">

<input type="text" id="sexo" name="sexo" value="masculino">

<input type="submit" value="teste"/>

</form>

<jsp:include page="rodape.jsp"/>


</body>
</html>