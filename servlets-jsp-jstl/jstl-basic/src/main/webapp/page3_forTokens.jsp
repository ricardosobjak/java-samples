<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body bgcolor="#FFFFFF">

        <%--
                Tag <c:forTokens>
                        Quebra uma string em substrings, de acordo com o delimitador indicado como atributo 
        --%>

        <h1>Exemplo de forTokens</h1>

        <c:forTokens var="i" delims="," items="1,2,3,4,5">
            <c:out value="${i}" /> <br/>
        </c:forTokens>

    </body>
</html>