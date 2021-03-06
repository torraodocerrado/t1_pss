<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Incluir projeto</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">
        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" />
        <script type="text/javascript" src="scripts/jquery.min.js"></script>

        <jsp:include page="helpers/msgSalvo.jsp"/>

        <form action="ControllerProjeto?cmd=incluirProjeto" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir projeto</h2></div>
            <div class="element-input"><label class="title">Titulo<span class="required">*</span></label><input class="small" type="text" name="titulo" required="required"/></div>
            <div class="element-date"><label class="title">Data de in�cino<span class="required">*</span></label><input class="small" data-format="dd/mm/yyyy" type="date" name="dataInicio" required="required" placeholder="dd/mm/yyyy"/></div>
            <div class="element-input"><label class="title">Valor financiado<span class="required">*</span></label><input class="small" type="number" name="valorFinanciado" required="required"/></div>
            <div class="element-input"><label class="title">Ag�ncia financiadora<span class="required">*</span></label><input class="medium" type="text" name="agenciaFinanciadora" required="required"/></div>
            <div class="element-textarea"><label class="title">Objetivo<span class="required">*</span></label><textarea class="small" name="objetivo" cols="20" rows="5" required="required"></textarea></div>
            <div class="element-textarea"><label class="title">Descri��o<span class="required">*</span></label><textarea class="small" name="descricao" cols="20" rows="5" required="required"></textarea></div>

            <jsp:include page="helpers/submit.jsp"/>
            <input type="hidden" name="cmd" value="incluirProjeto">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>
