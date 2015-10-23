<%@page import="model.Projeto"%>
<%@page import="controller.Memoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Memoria memoria = new Memoria();%>
<div class="element-select"><label class="title">Selecionar o projeto<span class="required">*</span></label>
    <div class="large">
        <span>
            <select name="projeto" required="required">
                <% for (Object mem : memoria.getAll(Projeto.class)) {%>
                <option value="<%=((Projeto) mem).getTitulo()%>"><%=((Projeto) mem).getTitulo()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>
