<%@page isErrorPage="true" %>

<html>
<body>
	<h2>N�o foi poss�vel executar sua requisi��o.</h2>
	Exce��o gerada em <%= new java.util.Date().toString() %>
	<br/>
	<br/>
	<%= exception.getMessage() %>
</body>
</html>