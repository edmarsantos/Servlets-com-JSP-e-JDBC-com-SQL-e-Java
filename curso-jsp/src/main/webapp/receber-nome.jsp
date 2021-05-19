<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>receber nome</title>
</head>
<body>

<%= request.getParameter("paramforward") %>

<!-- Pegando objeto da session -->
<%=session.getAttribute("curso")%>

<!-- outro exemplo de Directiva para redirecionar erros -->
<%@ page isErrorPage="true" %>

<!-- utilizando a Direciva  para redirecionar em caso de erro -->
<%= exception %>


<% 
String nome = "Nome recebido " + request.getParameter("nome");	

out.print(nome);%>

<!--Exemplos abaixo de como utilizar os objetos implicitos-->
<!-- String nome = "Nome recebido " + request.getParameter("nome"); -->
<%-- <% response.sendRedirect("https://github.com/edmarsantos") %>> --%>
</body>
</html>