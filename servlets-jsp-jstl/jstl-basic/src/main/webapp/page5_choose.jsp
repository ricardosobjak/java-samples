<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body bgcolor="#FFFFFF">

        <%-- 
                TAG CONDICIONAL: <c:choose>
                        Equivalente ao comando switch
                        
                        Tags utilizadas
                                <c:when>, realiza o teste condicional;
                                <c:otherwise>, se todos os testes condicionais falharem, ele será utilizado.
        
        --%>

        <h1>Exemplo da tag c:choose</h1>
        <br/>

        <c:forTokens var="i" delims="," items="1,2,3,4,5,6,7,8,9,10">
            <c:choose>
                <c:when test="${i % 2 == 0}">${i} (par)</c:when>
                <c:otherwise>${i} (ímpar)</c:otherwise>
            </c:choose>
            <br/>
        </c:forTokens >

    </body>
</html>