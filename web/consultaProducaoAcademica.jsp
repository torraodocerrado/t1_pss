<%@page import="model.RelatorioProducaoAcademica"%>
<%@page import="model.Projeto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Relatório de produção acadêmica</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;margin:0px auto;width: 100%; }
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:17px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:17px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
            .tg .tg-yw4l{vertical-align:top}
        </style>
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">
        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" />
        <script type="text/javascript" src="scripts/jquery.min.js"></script>
        <form class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Relatório de produção acadêmica</h2></div>
            <table class="tg">
                <% if (request.getAttribute("relatorio") != null) {
                        RelatorioProducaoAcademica relatorio = (RelatorioProducaoAcademica) request.getAttribute("relatorio");
                %>
                <tr>
                    <td class="tg-yw4l">
                        <%=relatorio.toString()%>
                    </td>
                </tr>


                <% }%>
            </table>
            <%@page contentType="text/html" pageEncoding="UTF-8"%>
            <div class="submit">
                <a style="  padding-right: 40px;" href="index.html">Voltar</a>
            </div>

        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>


