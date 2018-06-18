<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body bgcolor="#FFFFFF">
        <%--
                EXEMPLO:
                        Acessando uma coleção de objetos Java
                        Seja a classe Java ColecaoDeNomes
                        
                - Queremos iterar a coleção de nomes existente dentro da classe ColecaoDeNomes (veja o exemplo abaixo)
                        - Observe que o objeto da classe ColecaoDeNomes foi instanciado utilizando a tag <jsp:useBean>.
                        - Além disso, o nome da instância criada é "colecao".
                        - Note que o atributo items da tag <c:forEach> faz referência à instância criada (batizada como "colecao").
                        - Os objetos existentes dentro da coleção nomes (java.util.Collection) dentro da classe ColecaoDeNomes está sendo acessado da seguinte forma: ${colecao.nomes}
                                - ${colecao.nomes}: colecao é o nome da instância da classe ColecaoDeNomes recém criada
                                - ${colecao.nomes}: nomes faz referência ao nome do método getNomes()
        --%>

        <h1>Exemplo de utilização de objetos Java com JSTL</h1>
        <jsp:useBean id="colecao" class="br.edu.utfpr.sobjak.jspjstlbasic.ColecaoDeNomes" />

        <c:forEach var="nome" items="${colecao.nomes}">
            <br>${nome}
        </c:forEach>

    </body>
</html>