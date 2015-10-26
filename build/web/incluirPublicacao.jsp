<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Incluir publicação</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">

        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" />
        <script type="text/javascript" src="scripts/jquery.min.js"></script>

        <jsp:include page="helpers/msgSalvo.jsp"/>

        <form action="Controller" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir publicação</h2></div>
            <div class="element-input"><label class="title">Título<span class="required">*</span></label><input class="large" type="text" name="titulo" required="required"/></div>
            <div class="element-input"><label class="title">Conferência<span class="required">*</span></label><input class="large" type="text" name="conferencia" required="required"/></div>
            <div class="element-number"><label class="title">Ano publicação</label><input class="small" type="number" min="1900" max="2015" name="anoPublicacao"  value=""/></div>

            <jsp:include page="helpers/boxListaProfessor.jsp"/>

            <jsp:include page="helpers/boxProjetoEmAndamento.jsp"/>

            <jsp:include page="helpers/boxListaColaboradoresSemProfessores.jsp"/>

            <jsp:include page="helpers/submit.jsp"/>

            <input type="hidden" name="cmd" value="incluirPublicacao">

        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>
