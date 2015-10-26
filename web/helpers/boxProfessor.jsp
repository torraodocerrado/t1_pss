<%@page import="java.util.ArrayList"%>
<%@page import="model.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="element-select">
    <label class="title">Professor Orientador<span class="required">*</span></label>
    <div class="large">
        <span>
            <select name="professor" required="required">
                <%
                    ArrayList<Object> professores = (ArrayList<Object>) request.getAttribute("listaProfessores");
                    for (Object mem : professores) {%>
                <option value="<%=((Professor) mem).getId()%>"><%=((Professor) mem).getId() + " - " + ((Professor) mem).getNome()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>
