<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Bem Vindo ao Curso de JSP</h1>
<% out.print("Sucesso Garantido"); %>

<form action="receber-nome.jsp">
<input type="text"  id="nome" name="nome">
<input type="submit" value="enviar"></input>
<br/>
<br/>
<!-- Declarando a Directiva -->
<%@ page import="java.util.Date" %>

<!-- utilizando a Direciva -->
<%= "Data Hoje é " + new Date() %>

<%@ page errorPage="receber-nome.jsp" %>
<%= 100/2 %>

<!--Declarando a Session -->
<%session.setAttribute("curso", "curso de Jsp"); %>

<!-- tag declarativa -->
<%! int cont = 2; 

/* tag declarativa permite tambem escrever metodos */
public int  retorna(int n){
	return n * 3;
}
%>

<!-- tag de Expressão -->
<br/>
<%= cont %>
<br/>
<%= retorna(10) %>
<br/>
<%= application.getInitParameter("estado") %>


<%@ include file="pagina_Include.jsp" %>
  <myprefix:minhatag/>


</form>




</body>
</html>