<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            table {
                width: 50% ;
                margin-left: auto;
                margin-right: auto;
            }
        </style>
    </head>
    <body>
        <%@ page import="memoria.Memoria"%>
        <table border='1'>
            <% Memoria memoria = new Memoria();
                String type = "";
                if (request.getParameterMap().containsKey("memoria")) {
                    type = request.getParameter("memoria");
                }
                switch (type) {
                    case "all":
                        for (Object mem : memoria.getAll()) {%>
            <tr><td><%=mem.toString()%></td></tr>
            <% }
                        break;
                    default:
                        out.print("não entrou");
                }
                if (memoria.getAll().size() == 0) {%>
            <tr><td align='center'>A memória está vazia.</td></tr>
            <% }%>
            <tr><td align='center'><a href="index.html">Voltar</a></td></tr>
        </table>
    </body>
</html>
