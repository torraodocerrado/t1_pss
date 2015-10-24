<%@page import="model.Aluno"%>
<%@page import="controller.Memoria"%>
<%@page import="model.Professor"%>
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

        <jsp:include page="helpers/msgSalvo.jsp" />

        <form action="Controller" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir orientação</h2></div>
            <div class="element-input"><label class="title">Título<span class="required">*</span></label><input class="large" type="text" name="titulo" required="required"/></div>
            <div class="element-select"><label class="title">Tipo<span class="required">*</span></label>
                <div class="large">
                    <span>
                        <select name="tipo" required="required">
                            <option value="Trabalho de conclusão de curso">Trabalho de conclusão de curso</option>
                            <option value="Dissertação">Dissertação</option>
                            <option value="Tese">Tese</option></select><i></i>
                    </span>
                </div>
            </div>

            <jsp:include page="helpers/boxProfessor.jsp"/>
            <jsp:include page="helpers/boxAluno.jsp"/>

            <jsp:include page="helpers/submit.jsp"/>

            <input type="hidden" name="command" value="incluirOrientacao">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>
