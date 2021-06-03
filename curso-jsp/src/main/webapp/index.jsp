<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"/>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
</head>
<body>

<%-- esse c abaixo se refere ao prefix do <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %> --%>
tag para saída de dados no html
<p/>
<c:out value="${'Bem Vindo ao Jstl'}"></c:out>
<br/>
tag para ser utilizada de include pega o codigo html da pagina
<p/>
<c:import var="data" url="https://www.google.com.br"/>
<c:out value="${data}"></c:out>
<br/>
tag para setar variaveis
<p/>
<c:set var="data1" scope="page" value="${500*6 }"></c:set>
<c:out value="${data1}"></c:out>
<br/>
tag para tratamento de erro
<c:catch var="erro">
<% int var = 100/2; %>
</c:catch>
<!-- tag de If -->
<c:if test="${erro != null }">
${erro.message}
</c:if>


<p/>
 setando valor
 <c:set var = "salary" scope = "session" value = "${2000*2}"/>
 <br/>
verificação de dados
<p/>
      <p>Your salary is : <c:out value = "${salary}"/></p>
      <c:choose>
         
         <c:when test = "${salary <= 0}">
            Salary is very low to survive.
         </c:when>
         
         <c:when test = "${salary > 1000}">
            Salary is very good.
         </c:when>
         
         <c:otherwise>
            No comment sir...
         </c:otherwise>
      </c:choose>

<c:set var="numero" value="${100/2 }"/>
<c:choose>
<c:when test="${numero >= 50}">
<c:out value="${'Maior que 50'}"/>
</c:when>

<c:when test="${numero < 50}">
<c:out value="${'Menor que 50'}"/>
</c:when>


 <c:otherwise> 
     <c:out value="${'Não encontrou nenhum valor'}"/>
</c:otherwise> 

</c:choose>

 <!-- caso diferente da primeira e segunda condição otherwise nao encontrou nenhuma condição --> 
<p/>
<p/>
 utilição do for
<p/>
<c:forEach var="n" begin="1" end="${numero}">
item:${n}
<br/>

</c:forEach>

<br/>
quebra de texto  token quebra string a partir de um delimitador
<p/>
<c:forTokens items="edmar-dias-santos" delims="-" var="nome">
Nome:<c:out value="${nome}"></c:out>
<br/>
</c:forTokens>

pegando url e passando parâmetro
<br/>
<p/>
<c:url value="/acessoliberado.jsp" var="acesso">
<c:param name="param1" value="111"></c:param>
<c:param name="param2" value="222"></c:param>
</c:url>
${acesso}
<p/>
<br/>
fazendo redirecionamento
<%--  <c:set var="numero3" value="50" scope="request"/>   --%>
<%--   <c:if test="${numero3 <= 50}">   --%>
<%--      <c:redirect url="http://javatpoint.com"/>   --%>
<%--   </c:if>   --%>
<%--   <c:if test="${numero3 > 50}">   --%>
<%--      <c:redirect url="https://www.javatpoint.com/jstl-core-redirect-tag"/>   --%>
<%--   </c:if>   --%>

<p/>
<p/>

<h1>Bem Vindo ao Curso de JSP</h1>
<% out.print("Sucesso Garantido"); %>

<form action = "LoginServet" method="post">
Login:
<input type="text" id= "login" name="login">
<br/>
Senha:
<input type="text" id= "senha" name="senha">
<br/>
<input type="submit" value="Logar">
</form>



<%-- <jsp:setProperty property="*" name="calcula"/> --%>







<!-- <form action ="cabecalho.jsp" method="post"> -->
<%-- 
<% session.setAttribute("user","Javaavançado"); %>	
<input type="text" id="nome" name="nome" value="alex">
<input type="text" id="ano" name="ano" value="53">
<input type="text" id="sexo" name="sexo" value="masculino">
<input type="submit" value="teste"/> --%>
</form>

<jsp:include page="rodape.jsp"/>


</body>
</html>