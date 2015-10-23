<%@page import="model.Colaborador"%>
<%@page import="controller.Memoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Memoria memoria = new Memoria();%>
<div class="element-select"><label class="title">Selecione um ou mais colaboradores<span class="required">*</span></label>
    <div class="large">
        <select name="colaborador" required="required">
            <% for (Object mem : memoria.getAll(Colaborador.class)) {%>
            <option value="<%=((Colaborador) mem).getId()%>"><%=((Colaborador) mem).getId() + "-" + ((Colaborador) mem).getNome()%></option>
            <%}%>
        </select>
    </div>
</div>
