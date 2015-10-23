<%@page import="model.Aluno"%>
<%@page import="controller.Memoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Memoria memoria = new Memoria();%>
<div class="element-select"><label class="title">Aluno</label>
    <div class="large">
        <span>
            <select name="aluno" >
                <% for (Object mem : memoria.getAll(Aluno.class)) {%>
                <option value="<%=((Aluno) mem).getId()%>"><%=((Aluno) mem).getId() + " - " + ((Aluno) mem).getNome()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>
