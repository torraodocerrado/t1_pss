<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Incluir Pesquisador</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">
        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" />
        <script type="text/javascript" src="scripts/jquery.min.js"></script>


        <% String status = request.getParameter("status");
            if ((status != null) && (status.equals("1"))) {%>
        <div class="formoid-metro-cyan" style="text-align: center; background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#999999;max-width:800px;min-width:150px">
            <h3 class="section-break-title">Pesquisador salvo com sucesso!</h3>
        </div>
        <%}%>


        <form action="Controller" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir Pesquisador</h2></div>
            <div class="element-input"><label class="title">Id<span class="required">*</span></label><input class="small" type="number" name="id" required="required"/></div>
            <div class="element-input"><label class="title">Nome<span class="required">*</span></label><input class="large" type="text" name="nome" required="required"/></div>
            <div class="element-input"><label class="title">E-mail<span class="required">*</span></label><input class="medium" type="text" name="email" required="required"/></div>
            <div class="submit">
                <a href="index.html">Voltar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Incluir"/>
            </div>
            <input type="hidden" name="command" value="incluirPesquisador">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>
