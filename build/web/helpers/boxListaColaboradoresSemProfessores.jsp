<%@page import="model.Professor"%>
<%@page import="model.Colaborador"%>
<%@page import="controller.Memoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Memoria memoria = new Memoria();%>
<div class="element-multiple"><label class="title">Selecione um ou mais colaboradores</label>
    <div class="large">
        <select name="colaborador" multiple="multiple">
            <% for (Object mem : memoria.getParticipantesProjeto()) {
                    if (!(mem instanceof Professor)) {
            %>
            <option value="<%=((Colaborador) mem).getId()%>"><%=((Colaborador) mem).getId() + "-" + ((Colaborador) mem).getNome()%></option>
            <%}
                }%>
        </select>
    </div>
</div>


