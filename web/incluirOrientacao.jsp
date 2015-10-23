<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Incluir orientação</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">

        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" />
        <script type="text/javascript" src="scripts/jquery.min.js"></script>




        <% String status = request.getParameter("status");
            if ((status != null) && (status.equals("1"))) {%>
        <div class="formoid-metro-cyan" style="text-align: center; background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#999999;max-width:800px;min-width:150px">
            <h3 class="section-break-title">Orientação salva com sucesso!</h3>
        </div>
        <%}%>


        <form action="Controller" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir orientação</h2></div>
            <div class="element-input"><label class="title">Título<span class="required">*</span></label><input class="large" type="text" name="input" required="required"/></div>
            <div class="element-select"><label class="title">Tipo<span class="required">*</span></label><div class="large"><span><select name="select2" required="required">

                            <option value="Trabalho de conclusão de curso">Trabalho de conclusão de curso</option>
                            <option value="Dissertação">Dissertação</option>
                            <option value="Tese">Tese</option></select><i></i></span></div></div>
            <div class="element-select"><label class="title">Professor<span class="required">*</span></label><div class="large"><span><select name="select1" required="required">

                            <option value="option 1">option 1</option>
                            <option value="option 2">option 2</option>
                            <option value="option 3">option 3</option></select><i></i></span></div></div>
            <div class="element-select"><label class="title">Aluno</label><div class="large"><span><select name="select3" >

                            <option value="option 1">option 1</option>
                            <option value="option 2">option 2</option>
                            <option value="option 3">option 3</option></select><i></i></span></div></div>
            <div class="submit">
                <a href="index.html">Voltar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Incluir"/></div>
            <input type="hidden" name="command" value="incluirColaboradoresProjeto">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>
