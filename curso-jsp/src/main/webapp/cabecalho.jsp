<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
</head>
<body>
<jsp:setProperty property="*" name="calcula"/>
<h3>cabeçalho</h3>

Nome : ${param.nome}
<br>
Ano :  ${param.ano}
<br>
Sexo :  ${param.sexo}
<br>
${sessionScope.user}

<%-- <jsp:getProperty property="nome" name="calcula"/>
<jsp:getProperty property="ano" name="calcula"/>
<jsp:getProperty property="sexo" name="calcula"/> --%>

</body>
</html>