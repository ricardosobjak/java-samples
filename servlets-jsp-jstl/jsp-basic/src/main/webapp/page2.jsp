<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP</title>
</head>
<body>
	<%
		//Recebendo um par�metro
		String nome = request.getParameter("nome");
	%>
	
	Nome do Usu�rio:
	
	<%-- Utiliza��o de express�es --%>
	<%= nome %>
	
	<br />
	<hr />

	
	<%
		for (int i = 1; i <= 10; i++) {
	%>
	O valor de I �: <%= i %>
	<br />
	<%
		}
	%>

</body>
</html>