<%@page import="controller.Memoria"%>
<%@page import="model.Professor"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Incluir aluno de graduação</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">
        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" charset="UTF-8"/>
        <script type="text/javascript" src="scripts/jquery.min.js" charset="UTF-8"></script>

        <jsp:include page="helpers/msgSalvo.jsp" />


        <form action="ControllerColaborador?cmd=incluirAlunoGraduacao" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir aluno de graduação</h2></div>
            <div class="element-input"><label class="title">Id<span class="required">*</span></label><input class="small" type="number" name="id" required="required"/></div>
            <div class="element-input"><label class="title">Nome<span class="required">*</span></label><input class="large" type="text" name="nome" required="required"/></div>
            <div class="element-input"><label class="title">E-mail<span class="required">*</span></label><input class="medium" type="text" name="email" required="required"/></div>
            <div class="element-date"><label class="title">Data de ingresso<span class="required">*</span></label><input class="small" data-format="yyyy-mm-dd" type="date" name="dataIngresso" required="required" placeholder="yyyy-mm-dd"/></div>

            <jsp:include page="helpers/boxProfessor.jsp" />
            <jsp:include page="helpers/submit.jsp"/>

            <input type="hidden" name="cmd" value="incluirAlunoGraduacao">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>

    </body>
</html>
