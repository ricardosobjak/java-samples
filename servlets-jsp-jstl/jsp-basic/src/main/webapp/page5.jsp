<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!
		//Fazendo a defini��o de uma vari�vel na classe no Servlet
		int contador = 0;
	
		//Declarando um m�todo no Servlet
		public String parOuImpar(int num) {
			return (num % 2 == 0) ? "Par" : "�mpar";
		}
	%>
	
	N�mero da requisi��o: 
	<%
		contador++;
		out.println(contador);
	%>
	
	<hr/>
	
	O n�mero da requisi��o �: <%= parOuImpar(contador) %> 
	
	
</body>
</html>