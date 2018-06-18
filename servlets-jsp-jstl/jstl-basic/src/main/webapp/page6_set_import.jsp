<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<html>
    <body>
        <%--
        Tags de atribuição e importação

        Tag <c:import>
                Permite importar páginas web do mesmo contexto web, 
                de contextos diferentes e até mesmo de máquinas diferentes.
        
        Tag <c:set>
                Permite a atribuir valores a variáveis em um determinado escopo.

        
        Exemplo
                Nesse exemplo, a variável "title" é criada com o valor "Welcome to Page 1" com escopo "request"
                Em seguida, a página "header.jsp" é carregada, e seu conteúdo é armazenado na variável "headerText"
                Finalmente, imprimimos o conteúdo da variável "title" e da variável "headerText"

        --%>

        <c:set scope="request" var="title" value="Bem vindo a Página 6" />
        <c:import var="headerText" url="page6_header.jsp" />

        <br>Minha página: ${title}
        <br>Texto importado: ${headerText}

    </body>
</html>