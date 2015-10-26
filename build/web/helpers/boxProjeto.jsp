<%@page import="java.util.ArrayList"%>
<%@page import="model.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="element-select"><label class="title">Selecionar o projeto<span class="required">*</span></label>
    <div class="large">
        <span>
            <select name="projeto" required="required">
                <% ArrayList<Object> projetos = (ArrayList<Object>) request.getAttribute("listaProjetos");
                    for (Object mem : projetos) {%>
                <option value="<%=((Projeto) mem).getTitulo()%>"><%=((Projeto) mem).getTitulo()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>
