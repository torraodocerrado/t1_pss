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
        <form class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir publicação</h2></div>
            <div class="element-input"><label class="title">Título<span class="required">*</span></label><input class="large" type="text" name="input" required="required"/></div>
            <div class="element-input"><label class="title">Conferência<span class="required">*</span></label><input class="large" type="text" name="input1" required="required"/></div>
            <div class="element-number"><label class="title">Ano publicação</label><input class="small" type="text" min="1900" max="2015" name="number"  value=""/></div>
            <div class="element-select"><label class="title">Projeto<span class="required">*</span></label><div class="medium"><span><select name="select" required="required">

                            <option value="option 1">option 1</option>
                            <option value="option 2">option 2</option>
                            <option value="option 3">option 3</option></select><i></i></span></div></div>
            <div class="element-multiple"><label class="title">Selecione um ou mais colaboradores<span class="required">*</span></label>
                <div class="large">
                    <select data-no-selected="Nothing selected" name="multiple[]" multiple="multiple" required="required">

                        <option value="option 1">option 1</option>
                        <option value="option 2">option 2</option>
                        <option value="option 3">option 3</option></select>
                </div>
            </div>
            <div class="submit">
                <a href="index.html">Voltar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Incluir"/></div></form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>
