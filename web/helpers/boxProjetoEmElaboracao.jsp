<%@page import="java.util.ArrayList"%>
<%@page import="model.Projeto"%>
<%@page import="controller.Memoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="element-select"><label class="title">Selecione o projeto em elaboração<span class="required">*</span></label>
    <div class="large">
        <span>
            <select name="projeto" required="required">
                <% ArrayList<Projeto> projetos = (ArrayList<Projeto>) request.getAttribute("listaProjetosElaboracao");
                    for (Projeto mem : projetos) {%>
                <option value="<%=mem.getTitulo()%>"><%=mem.getTitulo()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>

