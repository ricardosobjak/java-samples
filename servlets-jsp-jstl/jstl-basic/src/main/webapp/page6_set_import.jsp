<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<html>
    <body>
        <%--
        Tags de atribui��o e importa��o

        Tag <c:import>
                Permite importar p�ginas web do mesmo contexto web, 
                de contextos diferentes e at� mesmo de m�quinas diferentes.
        
        Tag <c:set>
                Permite a atribuir valores a vari�veis em um determinado escopo.

        
        Exemplo
                Nesse exemplo, a vari�vel "title" � criada com o valor "Welcome to Page 1" com escopo "request"
                Em seguida, a p�gina "header.jsp" � carregada, e seu conte�do � armazenado na vari�vel "headerText"
                Finalmente, imprimimos o conte�do da vari�vel "title" e da vari�vel "headerText"

        --%>

        <c:set scope="request" var="title" value="Bem vindo a P�gina 6" />
        <c:import var="headerText" url="page6_header.jsp" />

        <br>Minha p�gina: ${title}
        <br>Texto importado: ${headerText}

    </body>
</html>