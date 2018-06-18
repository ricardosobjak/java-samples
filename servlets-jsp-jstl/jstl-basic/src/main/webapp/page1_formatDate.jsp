<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
    <body>
        <jsp:useBean id="agora" class="java.util.Date"/>

        <h1>Exemplo de fmt:formatDate</h1>

        <br>
        Vers�o Curta: <fmt:formatDate value="${agora}" />
        <br>
        Vers�o Longa: <fmt:formatDate value="${agora}" dateStyle="full"/>
        <br>
        Usando pattern: <fmt:formatDate value="${agora}" pattern="yyyy-MM-dd"/>

    </body>
</html>