<%-- EXEMPLO DE UTILIZA��O DE P�GINA DE ERRO --%>

<%@ page errorPage="outros/erroDivisaoPorZero.jsp" %>
<html>
<body>
	<%= 4 / 0 %>
</body>
</html>