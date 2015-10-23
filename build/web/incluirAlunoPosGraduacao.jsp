<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Incluir aluno de pós-graduação</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">
        <link rel="stylesheet" href="scripts/formoid-metro-cyan.css" type="text/css" />
        <script type="text/javascript" src="scripts/jquery.min.js"></script>


        <jsp:include page="helpers/msgSalvo.jsp.jsp" />

        <form action="Controller" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#666666;max-width:800px;min-width:150px" method="post"><div class="title"><h2>Incluir aluno de pós-graduação</h2></div>
            <div class="element-input"><label class="title">Id<span class="required">*</span></label><input class="small" type="number" name="id" required="required"/></div>
            <div class="element-input"><label class="title">Nome<span class="required">*</span></label><input class="large" type="text" name="nome" required="required"/></div>
            <div class="element-input"><label class="title">E-mail<span class="required">*</span></label><input class="medium" type="text" name="email" required="required"/></div>
            <div class="element-date"><label class="title">Data de ingresso<span class="required">*</span></label><input class="small" data-format="yyyy-mm-dd" type="date" name="dataIngresso" required="required" placeholder="yyyy-mm-dd"/></div>



            <div class="element-select"><label class="title">Curso<span class="required">*</span></label><div class="small"><span>
                        <select name="curso" required="required">
                            <option value="Mestrado">Mestrado</option>
                            <option value="Doutorado">Doutorado</option>
                        </select></span>
                </div>
            </div>
            <div class="element-select"><label class="title">Regime de curso<span class="required">*</span></label><div class="small"><span>
                        <select name="regime" required="required">
                            <option value="Parcial">Parcial</option>
                            <option value="Integral">Integral</option>
                        </select></span>
                </div>
            </div>

            <jsp:include page="helpers/boxProfessor.jsp" />

            <div class="submit">
                <a href="index.html">Voltar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Incluir"/></div>
            <input type="hidden" name="command" value="incluirAlunoPosGraduacao">
        </form>
        <script type="text/javascript" src="scripts/formoid-metro-cyan.js" charset="UTF-8"></script>
    </body>
</html>
