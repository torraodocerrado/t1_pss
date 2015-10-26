<%@page import="java.util.ArrayList"%>
<%@page import="model.Colaborador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="element-multiple"><label class="title">Selecione um ou mais colaboradores<span class="required">*</span></label>
    <div class="large">
        <select name="colaborador" multiple="multiple" required="required">
            <% ArrayList<Object> colaboradores = (ArrayList<Object>) request.getAttribute("listaColaboradores");
                for (Object mem : colaboradores) {%>
            <option value="<%=((Colaborador) mem).getId()%>"><%=((Colaborador) mem).getId() + "-" + ((Colaborador) mem).getNome()%></option>
            <%}%>
        </select>
    </div>
</div>


