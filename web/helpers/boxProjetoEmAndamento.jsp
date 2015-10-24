<%@page import="model.Projeto"%>
<%@page import="controller.Memoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Memoria memoria = new Memoria();%>
<div class="element-select"><label class="title">Selecione o projeto em elaboração (opcional)</label>
    <div class="large">
        <span>
            <select name="projeto">
                <option value=""></option>
                <% for (Projeto mem : memoria.getProjetosEmAndamento()) {%>
                <option value="<%=mem.getTitulo()%>"><%=mem.getTitulo()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>

