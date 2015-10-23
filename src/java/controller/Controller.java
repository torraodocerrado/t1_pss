package controller;

import java.io.IOException;
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
import model.AlunoGraduacao;
import model.AlunoPosGraduacao;
import model.Colaborador;
import model.Pesquisador;
import model.Professor;
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
            response.sendRedirect("memoria.jsp?memoria=" + this.request.getParameter("memoria"));
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
        Projeto projeto = new Projeto(
                this.request.getParameter("titulo"),
                this.request.getParameter("agenciaFinanciadora"),
                this.request.getParameter("valorFinanciado"),
                this.request.getParameter("objetivo"),
                this.request.getParameter("descricao"),
                Date.valueOf(this.request.getParameter("dataInicio"))
        );
        mem.add(projeto);
        this.param = "?status=1";
    }

    public void incluirAlunoGraduacao() {
        AlunoGraduacao aluno = new AlunoGraduacao(
                Integer.valueOf(this.request.getParameter("id")),
                this.request.getParameter("nome"),
                this.request.getParameter("email"),
                Integer.valueOf(this.request.getParameter("orientador")),
                Date.valueOf(this.request.getParameter("dataIngresso"))
        );
        mem.add(aluno);
        this.param = "?status=1";
    }

    public void incluirAlunoPosGraduacao() {
        AlunoPosGraduacao aluno = new AlunoPosGraduacao(
                Integer.valueOf(this.request.getParameter("id")),
                this.request.getParameter("nome"),
                this.request.getParameter("email"),
                Integer.valueOf(this.request.getParameter("orientador")),
                Date.valueOf(this.request.getParameter("dataIngresso")),
                this.request.getParameter("regime"),
                this.request.getParameter("curso")
        );
        mem.add(aluno);
        this.param = "?status=1";
    }

    public void incluirProfessor() {
        Professor professor = new Professor(
                Integer.valueOf(this.request.getParameter("id")),
                this.request.getParameter("nome"),
                this.request.getParameter("email")
        );
        mem.add(professor);
        this.param = "?status=1";
    }

    public void incluirPesquisador() {
        Pesquisador pesquisador = new Pesquisador(
                Integer.valueOf(this.request.getParameter("id")),
                this.request.getParameter("nome"),
                this.request.getParameter("email")
        );
        mem.add(pesquisador);
        this.param = "?status=1";
    }

    public void incluirColaboradoresProjeto() {
        for (Object proj : mem.getAll()) {
            if ((proj instanceof Projeto) && (((Projeto) proj).getTitulo().equals(this.request.getParameter("projeto")))) {
                for (Object col : mem.getAll()) {
                    if ((col instanceof Colaborador) && (((Colaborador) col).getId() == Integer.valueOf(this.request.getParameter("colaborador")))) {
                        if (!((Projeto) proj).colaboradores.contains((Colaborador) col)) {
                            ((Projeto) proj).colaboradores.add((Colaborador) col);
                        }
                    }
                }
            }
        }
        this.param = "?status=1";
    }

}
