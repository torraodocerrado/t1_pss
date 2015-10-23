<%@page import="model.Colaborador"%>
<%@page import="model.Projeto"%>
<%@ page import="controller.Memoria"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Incluir colaboradores a um projeto</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">
        <%
            Memoria memoria = new Memoria();
        %>
        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" />
        <script type="text/javascript" src="scripts/jquery.min.js"></script>



        <% String status = request.getParameter("status");
            if ((status != null) && (status.equals("1"))) {%>
        <div class="formoid-metro-cyan" style="text-align: center; background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#999999;max-width:800px;min-width:150px">
            <h3 class="section-break-title">Inclusão realizada com sucesso!</h3>
        </div>
        <%}%>

        <form action="Controller" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir colaboradores a um projeto</h2></div>
            <div class="element-select"><label class="title">Selecionar o projeto<span class="required">*</span></label><div class="large"><span>
                        <select name="projeto" required="required">
                            <% for (Object mem : memoria.getAll(Projeto.class)) {%>
                            <option value="<%=((Projeto) mem).getTitulo()%>"><%=((Projeto) mem).getTitulo()%></option>
                            <%}%>
                        </select></span>
                </div>
            </div>

            <div class="element-select"><label class="title">Selecione um ou mais colaboradores<span class="required">*</span></label>
                <div class="large">
                    <select name="colaborador" required="required">
                        <% for (Object mem : memoria.getAll(Colaborador.class)) {%>
                        <option value="<%=((Colaborador) mem).getId()%>"><%=((Colaborador) mem).getId() + "-" + ((Colaborador) mem).getNome()%></option>
                        <%}%>
                    </select>
                </div>
            </div>

            <div class="submit">
                <a href="index.html">Voltar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Incluir"/></div>
            <input type="hidden" name="command" value="incluirColaboradoresProjeto">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js"></script>
    </body>
</html>
