<%@ page info="Copyright (c) 2013 by UTFPR"%>
<html>
<head></head>

<body>
	<%-- Mostrando a informa��o do servlet configurado no atributo "info" da diretiva page --%>
	<%= getServletInfo() %>
	
	
	<hr/>
	A requisi��o desta p�gina partiu do endere�o IP <%= request.getRemoteAddr() %>.
	
</body>
</html>