<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String status = request.getParameter("status");
    if ((status != null) && (status.equals("1"))) {%>
<div class="formoid-metro-cyan" style="text-align: center; background-color:#FFFFFF;font-size:14px;font-family:'Trebuchet MS',Helvetica,sans-serif;color:#999999;max-width:800px;min-width:150px">
    <h3 class="section-break-title">Salvo com sucesso!</h3>
</div>
<%}%>