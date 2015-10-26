<%@page import="java.util.ArrayList"%>
<%@page import="model.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="element-select"><label class="title">Aluno<span class="required">*</span></label>
    <div class="large">
        <span>
            <select name="aluno" required="required">
                <% ArrayList<Object> alunos = (ArrayList<Object>) request.getAttribute("listaAlunos");
                    for (Object mem : alunos) {%>
                <option value="<%=((Aluno) mem).getId()%>"><%=((Aluno) mem).getId() + " - " + ((Aluno) mem).getNome()%></option>
                <%}%>
            </select>
        </span>
    </div>
</div>
