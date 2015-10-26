<%@page import="java.util.ArrayList"%>
<%@page import="model.Professor"%>
<%@page import="model.Colaborador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="element-multiple"><label class="title">Selecione um ou mais colaboradores</label>
    <div class="large">
        <select name="colaborador" multiple="multiple">
            <%
                ArrayList<Object> pessoas = (ArrayList<Object>) request.getAttribute("listaParticipantesProjeto");
                for (Object mem : pessoas) {
                    if (!(mem instanceof Professor)) {
            %>
            <option value="<%=((Colaborador) mem).getId()%>"><%=((Colaborador) mem).getId() + "-" + ((Colaborador) mem).getNome()%></option>
            <%}
                }%>
        </select>
    </div>
</div>


