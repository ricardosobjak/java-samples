<%@page isErrorPage="true" %>

<html>
<body>
	<h2>Não foi possível executar sua requisição.</h2>
	Exceção gerada em <%= new java.util.Date().toString() %>
	<br/>
	<br/>
	<%= exception.getMessage() %>
</body>
</html>