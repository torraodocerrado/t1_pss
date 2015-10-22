package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Projeto;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    private Memoria mem;
    private HttpServletRequest request;
    private String output = "";
    private String param = "";

    public Controller() {
        if (mem == null) {
            mem = new Memoria();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.output = "";
        response.setContentType("text/html;charset=UTF-8");
        if (this.request.getParameterMap().containsKey("memoria")) {
            this.getMemoria(this.request.getParameter("memoria"));
            try (PrintWriter out = response.getWriter()) {
                out.print(output);
            }
        } else if (this.request != null && this.request.getParameterMap().containsKey("command") && !this.request.getParameter("command").isEmpty()) {
            try {
                Method method = this.getClass().getMethod(this.request.getParameter("command"));
                method.invoke(this);
                String jspName = this.request.getParameter("command") + ".jsp" + param;
                response.sendRedirect(jspName);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public void consultaColaborador() {
        this.param = "?status=1";
    }

    public void incluirProjeto() {
        Projeto projeto = new Projeto();
        projeto.setTitulo(this.request.getParameter("titulo"));
        projeto.setDataInicio(Date.valueOf(this.request.getParameter("dataInicio")));
        projeto.setValorFinanciado(this.request.getParameter("valorFinanciado"));
        projeto.setAgenciaFinanciadora(this.request.getParameter("agenciaFinanciadora"));
        projeto.setObjetivo(this.request.getParameter("objetivo"));
        projeto.setDescricao(this.request.getParameter("descricao"));
        mem.add(projeto.getTitulo(), projeto);
        this.param = "?status=1";
    }

    private void getMemoria(String parameter) {
        switch (parameter.toLowerCase()) {
            case "all":
                for (Object mem1 : mem.getAll().values()) {
                    output += mem1.toString();
                }
                break;
            default:
        }
    }

}
