<%-- 
    Document   : index
    Created on : 24/03/2017, 15:50:46
    Author     : Sobjak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.File" %> 
<html>  
    <head><title>Listar diretório</title></head>  
    <body>  
        <h1>Exemplos de JSTL</h1>
        <h2>Listagem de arquivos deste projeto (contexto raíz):</h2>
        <ul>
            <%
                String cam = getServletContext().getRealPath("/");
                File dir = new File(cam);

                if (dir.isDirectory()) {
                    String arquivos[] = dir.list();

                    for (int i = 0; i < arquivos.length; i++) {
                        if (!arquivos[i].equals("META-INF") && !arquivos[i].equals("WEB-INF")) {
                            out.println("<li><a href=\"" + arquivos[i] + "\">");
                            out.println(arquivos[i]);
                            out.println("</a></li>");
                        }
                    }
                }
            %>  
        </ul>
    </body>  
</html>  
