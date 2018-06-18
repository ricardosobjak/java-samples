<%-- 
    Document   : index
    Created on : 24/03/2017, 16:02:38
    Author     : Sobjak
--%>

<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exemplos de JSP</h1>
        <h2>Listagem de arquivos deste projeto (contexto raíz):</h2>
        <ul>
            <%
                String cam = getServletContext().getRealPath(".");
                File dir = new File(cam);

                if (dir.isDirectory()) {
                    File arquivos[] = dir.listFiles();

                    for (int i = 0; i < arquivos.length; i++) {
                        if (arquivos[i].isFile()) {
                            out.println("<li><a href=\"" + arquivos[i].getName() + "\">");
                            out.println(arquivos[i].getName());
                            out.println("</a></li>");
                        }
                    }
                }
            %>  
        </ul>
    </body>
</html>