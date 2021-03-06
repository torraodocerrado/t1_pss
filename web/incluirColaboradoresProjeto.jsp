<%@page import="model.Colaborador"%>
<%@page import="model.Projeto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Incluir colaboradores a um projeto</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">
        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" />
        <script type="text/javascript" src="scripts/jquery.min.js"></script>
        <jsp:include page="helpers/msgSalvo.jsp" />
        <form action="ControllerProjeto?cmd=incluirColaboradoresProjeto" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir colaboradores a um projeto</h2></div>
            <jsp:include page="helpers/boxProjetoEmElaboracao.jsp" />
            <jsp:include page="helpers/boxListaProfessor.jsp" />
            <jsp:include page="helpers/boxListaColaboradoresSemProfessores.jsp" />
            <jsp:include page="helpers/submit.jsp"/>
            <input type="hidden" name="cmd" value="incluirColaboradoresProjeto">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>
