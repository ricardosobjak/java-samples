<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!
		//Fazendo a definição de uma variável na classe no Servlet
		int contador = 0;
	
		//Declarando um método no Servlet
		public String parOuImpar(int num) {
			return (num % 2 == 0) ? "Par" : "Ímpar";
		}
	%>
	
	Número da requisição: 
	<%
		contador++;
		out.println(contador);
	%>
	
	<hr/>
	
	O número da requisição é: <%= parOuImpar(contador) %> 
	
	
</body>
</html>