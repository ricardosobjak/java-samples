<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<html>
    <body>
        <h1>Exemplo de Internacionalização</h1>

        <br/>
        <div>
            Obs: Mude o idioma do browser ou do SO para ver as mensagens em outro idioma.
            <br/>
            Idiomas disponíveis: Português (padrão), Inglês e Espanhol.
        </div>
        <br/>

        <!-- Definir o nome base para os arquivos de mensagems -->
        <fmt:setBundle basename="br.edu.utfpr.sobjak.jspjstlbasic.i18n.mensagens" />

        <c:choose>
            <c:when test="${not empty param.nome}">

                <fmt:message key="ola" /> ${param.nome},
                <fmt:message key="bemvindo" /> ${param.nome}

            </c:when>

            <c:otherwise>
                <form action="">
                    <fmt:message key="nome" /> 
                    <input type="text" name="nome" />
                    <input type="submit" value="-->"/>
                </form>
            </c:otherwise>
        </c:choose>	
    </body>
</html>