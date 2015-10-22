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

        <form class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir colaboradores a um projeto</h2></div>
            <div class="element-select"><label class="title">Selecionar o projeto<span class="required">*</span></label><div class="large"><span>
                        <select name="select" required="required">
                            <option value="option 1">option 1</option>
                            <option value="option 2">option 2</option>
                            <option value="option 3">option 3</option>
                        </select></span>
                </div>
            </div>

            <div class="element-multiple"><label class="title">Selecione um ou mais colaboradores<span class="required">*</span></label>
                <div class="large">
                    <select data-no-selected="Selecione os colaboradores" name="multiple[]" multiple="multiple" required="required">

                        <option value="option 1">option 1</option>
                        <option value="option 2">option 2</option>
                        <option value="option 3">option 3</option>
                    </select>
                </div>
            </div>

            <div class="submit">
                <a href="index.html">Voltar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Incluir"/></div></form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js"></script>
    </body>
</html>
