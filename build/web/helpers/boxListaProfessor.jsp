<%@page import="java.util.ArrayList"%>
<%@page import="model.Professor"%>
<%@page import="controller.Memoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Object> professores = (ArrayList<Object>) request.getAttribute("listaProfessores");%>
<div class="element-multiple">
    <label class="title">Selecione um ou mais professores<span class="required">*</span></label>
    <div class="large">
        <span>
            <select name="professores" multiple="multiple"  required="required">
                <% for (Object mem : professores) {%>
                <option value="<%=((Professor) mem).getId()%>"><%=((Professor) mem).getId() + " - " + ((Professor) mem).getNome()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>
