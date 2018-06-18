<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body bgcolor="#FFFFFF">

        <h1>Exemplo de forEach</h1>

        <c:forEach var="i" begin="1" end="10">
            I = <c:out value="${i}" /> <br/>
        </c:forEach>

    </body>
</html>