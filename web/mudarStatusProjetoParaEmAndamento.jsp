<%@page import="controller.Memoria"%>
<%@page import="model.Projeto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Alterar status do projeto</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">
        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" charset="UTF-8"/>
        <script type="text/javascript" src="scripts/jquery.min.js" charset="UTF-8"></script>

        <jsp:include page="helpers/msgSalvo.jsp" />

        <form action="Controller" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post">
            <div class="title"><h2>Mudar situação de um projeto para Em Andamento</h2></div>
            <%@page contentType="text/html" pageEncoding="UTF-8"%>
            <%Memoria memoria = new Memoria();%>
            <div class="element-select"><label class="title">Selecionar o projeto<span class="required">*</span></label>
                <div class="large">
                    <span>
                        <select name="projeto" required="required">
                            <% for (Projeto mem : memoria.getProjetoMudancaSituacaoEmAndamento()) {%>
                            <option value="<%=((Projeto) mem).getTitulo()%>"><%=((Projeto) mem).getTituloMudancaSituacao()%></option>
                            <%}%>
                        </select>
                    </span>
                </div>
            </div>

            <jsp:include page="helpers/submit.jsp"/>

            <input type="hidden" name="command" value="mudarStatusProjetoParaEmAndamento">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>

    </body>
</html>
