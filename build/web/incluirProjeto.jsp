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

        <% String status = request.getParameter("status");
            if ((status != null) && (status.equals("1"))) {%>
        <div class="formoid-metro-cyan" style="text-align: center; background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#999999;max-width:800px;min-width:150px">
            <h3 class="section-break-title">Projeto salvo com sucesso!</h3>
        </div>
        <%}%>

        <form action="Controller" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir projeto</h2></div>
            <div class="element-input"><label class="title">Titulo<span class="required">*</span></label><input class="small" type="text" name="titulo" required="required"/></div>
            <div class="element-date"><label class="title">Data de inícino<span class="required">*</span></label><input class="small" data-format="yyyy-mm-dd" type="date" name="dataInicio" required="required" placeholder="yyyy-mm-dd"/></div>
            <div class="element-input"><label class="title">Valor financiado<span class="required">*</span></label><input class="small" type="text" name="valorFinanciado" required="required"/></div>
            <div class="element-input"><label class="title">Agência financiadora<span class="required">*</span></label><input class="medium" type="text" name="agenciaFinanciadora" required="required"/></div>
            <div class="element-textarea"><label class="title">Objetivo<span class="required">*</span></label><textarea class="small" name="objetivo" cols="20" rows="5" required="required"></textarea></div>
            <div class="element-textarea"><label class="title">Descrição<span class="required">*</span></label><textarea class="small" name="descricao" cols="20" rows="5" required="required"></textarea></div>
            <div class="submit">
                <a href="index.html">Voltar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Incluir"/>
            </div>
            <input type="hidden" name="command" value="incluirProjeto">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>
