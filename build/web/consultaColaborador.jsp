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
        <form action="Controller" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post">
            <div class="title"><h2>Consultar Colaborador</h2></div>
            <div class="element-input"><label class="title">Código do colaborador<span class="required">*</span></label><input class="small" type="text" name="input1" required="required"/></div>
            <div class="submit">
                <a href="index.html">Voltar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Pesquisar"/>
            </div>
            <input type="hidden" value="consultaColaborador" name="command">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>

