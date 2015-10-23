<%@page import="model.Professor"%>
<%@page import="controller.Memoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Memoria memoria = new Memoria();%>
<div class="element-select">
    <label class="title">Professor Orientador<span class="required">*</span></label>
    <div class="large">
        <span>
            <select name="professor" required="required">
                <% for (Object mem : memoria.getAll(Professor.class)) {%>
                <option value="<%=((Professor) mem).getId()%>"><%=((Professor) mem).getId() + " - " + ((Professor) mem).getNome()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>
