<%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP - Scripts</title>
</head>

<body>
	<%--
		Este � o primeira p�gina JSP
	 --%>
	 
	<%-- Exemplo de utiliza��o de scriptlets --%>
	
	
	
	<%
		//Declara��o de vari�veis
		int a = 1;
		int b = 2;
		int c = a + b;
	%>


	<%
		out.println(a + " + " + b + " = " + c);
	%>
</body>

</html>