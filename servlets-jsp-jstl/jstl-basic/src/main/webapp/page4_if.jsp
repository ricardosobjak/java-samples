<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body bgcolor="#FFFFFF">
        <!-- 
                Tag c:if
                        Equivamente ao comando if 
        -->

        <h1>Exemplo da tag c:if</h1>
        <br/>

        Elementos pares:
        <c:forTokens var="i" delims="," items="1,2,3,4,5,6,7,8,9,10">
            <c:if test="${i % 2 == 0}">
                <c:out value="${i}" />
            </c:if>
        </c:forTokens>
    </body>
</html>