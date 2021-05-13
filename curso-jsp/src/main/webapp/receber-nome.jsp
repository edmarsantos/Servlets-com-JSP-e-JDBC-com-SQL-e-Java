<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<% 
String nome = "Nome recebido " + request.getParameter("nome");	

out.print(nome);%>

<!--Exemplos abaixo de como utilizar os objetos implicitos-->
<!-- String nome = "Nome recebido " + request.getParameter("nome"); -->
<%-- <% response.sendRedirect("https://github.com/edmarsantos") %>> --%>
</body>
</html>