<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body bgcolor="#FFFFFF">
        <%--
                EXEMPLO:
                        Acessando uma cole��o de objetos Java
                        Seja a classe Java ColecaoDeNomes
                        
                - Queremos iterar a cole��o de nomes existente dentro da classe ColecaoDeNomes (veja o exemplo abaixo)
                        - Observe que o objeto da classe ColecaoDeNomes foi instanciado utilizando a tag <jsp:useBean>.
                        - Al�m disso, o nome da inst�ncia criada � "colecao".
                        - Note que o atributo items da tag <c:forEach> faz refer�ncia � inst�ncia criada (batizada como "colecao").
                        - Os objetos existentes dentro da cole��o nomes (java.util.Collection) dentro da classe ColecaoDeNomes est� sendo acessado da seguinte forma: ${colecao.nomes}
                                - ${colecao.nomes}: colecao � o nome da inst�ncia da classe ColecaoDeNomes rec�m criada
                                - ${colecao.nomes}: nomes faz refer�ncia ao nome do m�todo getNomes()
        --%>

        <h1>Exemplo de utiliza��o de objetos Java com JSTL</h1>
        <jsp:useBean id="colecao" class="br.edu.utfpr.sobjak.jspjstlbasic.ColecaoDeNomes" />

        <c:forEach var="nome" items="${colecao.nomes}">
            <br>${nome}
        </c:forEach>

    </body>
</html>