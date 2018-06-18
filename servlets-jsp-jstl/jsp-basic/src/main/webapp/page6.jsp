<%-- EXEMPLO DE UTILIZAÇÃO DE PÁGINA DE ERRO --%>

<%@ page errorPage="outros/erroDivisaoPorZero.jsp" %>
<html>
<body>
	<%= 4 / 0 %>
</body>
</html>