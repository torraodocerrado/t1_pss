<%@page import="java.util.ArrayList"%>
<%@page import="model.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="element-select"><label class="title">Selecione o projeto em elaboração (opcional)</label>
    <div class="large">
        <span>
            <select name="projeto">
                <option value=""></option>
                <% ArrayList<Projeto> projetos = (ArrayList<Projeto>) request.getAttribute("listaProjetosEmAndamento");
                    for (Projeto mem : projetos) {%>
                <option value="<%=mem.getTitulo()%>"><%=mem.getTitulo()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>

