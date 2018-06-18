<%-- Inclusão de diretivas com import --%>
<%@page import="java.util.Locale" %>
<%@page import="java.text.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>

<head>
	<title>JSP</title>
</head>

<body>
	<%
		java.util.Date agora = new java.util.Date();

	%>

	
	Hoje é <%= agora.getDate() %>/<%= agora.getMonth()+1 %>/<%= agora.getYear()+1900 %>
	
	<hr/>
	<%
		out.println(agora);
	%>
	<hr/>


	<%
		java.util.Locale l = new Locale("pt", "BR");
		DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL, l);
	%>	
	Hora corrente no servidor: <%= df.format(new java.util.Date()) %>.
	
	<hr/>
	
	<% int valor = agora.getMinutes() % 2; %>
	<b>
	O minuto atual é 
	<%
		if (valor == 0) {
	%>
	par
	<%
		} else {
	%>
	ímpar
	<%
		}
	%>
</b>


</body>
</html>