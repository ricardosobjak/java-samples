<%-- Inclusão de outras páginas --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JSP - Includes</title>
</head>
<body>

	<jsp:include page="/outros/cabecalho.jsp" />
	
	Este é o corpo da minha página.
	<br/>
	Cabeçalho e rodapé padronizados.
	
	<jsp:include page="/outros/rodape.jsp" />

</body>
</html>