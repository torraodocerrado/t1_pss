<%@page import="java.util.ArrayList"%>
<%@page import="model.Colaborador"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Consultar Colaborador</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">

        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" />
        <script type="text/javascript" src="scripts/jquery.min.js"></script>
        <form action="ControllerRelatorio?cmd=consultaColaborador" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post">
            <div class="title"><h2>Consultar Colaborador</h2></div>


            <%@page contentType="text/html" pageEncoding="UTF-8"%>
            <div class="element-select"><label class="title">Selecione um ou mais colaboradores<span class="required">*</span></label>
                <div class="large">
                    <select name="colaborador" required="required">
                        <option value=""></option>
                        <%
                            ArrayList<Object> pessoas = (ArrayList<Object>) request.getAttribute("listaColaboradores");
                            for (Object mem : pessoas) {
                        %>
                        <option value="<%=((Colaborador) mem).getId()%>"><%=((Colaborador) mem).getId() + "-" + ((Colaborador) mem).getNome()%></option>
                        <%}%>
                    </select>
                </div>
                <br><br>
                <table class="tg">
                    <% if (request.getAttribute("relColaborador") != null) {
                            Object colaborador = (Object) request.getAttribute("relColaborador");
                    %>
                    <tr>
                        <td class="tg-yw4l">
                            <%=colaborador.toString()%>
                        </td>
                    </tr>
                    <% }%>
                </table>

            </div>

            <jsp:include page="helpers/pesquisar.jsp"/>

            <input type="hidden" value="consultaColaborador" name="cmd">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>

