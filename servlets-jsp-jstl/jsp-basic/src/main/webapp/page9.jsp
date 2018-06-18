<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="" method="get">
	Data:
	
	<select name="dia">
		<option value="1">1</option>
	</select>
	
	<select name="mes">
		<option value="1">Janeiro</option>
	</select>
	
	<select name="ano">
		<option value="2013">2013</option>
	</select>
	
	<button type="submit">Ver</button>
</form>

<hr/>
<%
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String dia = request.getParameter("dia");
	String mes = request.getParameter("mes");
	String ano = request.getParameter("ano");

	if(dia != null && mes != null && ano != null) {
		out.print("A data escolhida foi: ");
		out.println( df.format( new Date(Integer.parseInt(ano)-1900, Integer.parseInt(mes)-1, Integer.parseInt(dia))) );

	}
		
%>

</body>
</html>