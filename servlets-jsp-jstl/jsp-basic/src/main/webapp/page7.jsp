<%@ page info="Copyright (c) 2013 by UTFPR"%>
<html>
<head></head>

<body>
	<%-- Mostrando a informação do servlet configurado no atributo "info" da diretiva page --%>
	<%= getServletInfo() %>
	
	
	<hr/>
	A requisição desta página partiu do endereço IP <%= request.getRemoteAddr() %>.
	
</body>
</html>