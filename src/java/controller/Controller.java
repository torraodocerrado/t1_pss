package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.AlunoGraduacao;
import model.AlunoPosGraduacao;
import model.Colaborador;
import model.Orientacao;
import model.Pesquisador;
import model.Professor;
import model.Projeto;
import model.Publicacao;

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
                this.getProfessor(Integer.valueOf(this.request.getParameter("professor"))),
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
                this.getProfessor(Integer.valueOf(this.request.getParameter("professor"))),
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
        ArrayList<Integer> colSelecionados = new ArrayList<>();
        if (this.request.getParameterValues("colaborador") != null) {
            for (String col : this.request.getParameterValues("colaborador")) {
                colSelecionados.add(Integer.valueOf(col));
            }
        }
        ArrayList<Integer> profSelecionados = new ArrayList<>();
        for (String col : this.request.getParameterValues("professores")) {
            profSelecionados.add(Integer.valueOf(col));
        }
        for (Object proj : mem.getAll()) {
            if ((proj instanceof Projeto) && (((Projeto) proj).getTitulo().equals(this.request.getParameter("projeto")))) {
                for (Object col : mem.getAll()) {
                    if ((col instanceof Colaborador) && (colSelecionados.contains(((Colaborador) col).getId()))) {
                        if (!((Projeto) proj).colaboradores.contains((Colaborador) col)) {
                            ((Projeto) proj).colaboradores.add((Colaborador) col);
                        }
                    } else if ((col instanceof Professor) && (profSelecionados.contains(((Professor) col).getId()))) {
                        if (!((Projeto) proj).professores.contains((Professor) col)) {
                            ((Projeto) proj).professores.add((Professor) col);
                        }
                    }
                }
            }
        }
        this.param = "?status=1";
    }

    public void incluirOrientacao() {
        Professor professor = this.getProfessor(Integer.valueOf(this.request.getParameter("professor")));
        Aluno aluno = this.getAluno(Integer.valueOf(this.request.getParameter("aluno")));
        Orientacao orientacao = new Orientacao(this.request.getParameter("titulo"), this.request.getParameter("tipo"), professor, aluno);
        mem.add(orientacao);
        this.param = "?status=1";
    }

    public Professor getProfessor(int id) {
        for (Object obj : mem.getAll()) {
            if ((obj instanceof Professor) && (((Professor) obj).getId() == id)) {
                return (Professor) obj;
            }
        }
        return null;
    }

    private Aluno getAluno(int id) {
        for (Object ojb : mem.getAll()) {
            if ((ojb instanceof Aluno) && (((Aluno) ojb).getId() == id)) {
                return (Aluno) ojb;
            }
        }
        return null;
    }

    private Projeto getProjeto(String parameter) {
        for (Object obj : mem.getAll()) {
            if ((obj instanceof Projeto) && (((Projeto) obj).getTitulo().equals(parameter))) {
                return (Projeto) obj;
            }
        }
        return null;
    }

    public void incluirPublicacao() {
        Publicacao publicacao = new Publicacao(
                this.request.getParameter("titulo"),
                this.request.getParameter("conferencia"),
                Integer.valueOf(this.request.getParameter("anoPublicacao")),
                this.getProjeto(this.request.getParameter("projeto"))
        );

        ArrayList<Integer> colSelecionados = new ArrayList<>();
        if (this.request.getParameterValues("colaborador") != null) {
            for (String col : this.request.getParameterValues("colaborador")) {
                colSelecionados.add(Integer.valueOf(col));
            }
        }
        for (Object col : mem.getAll()) {
            if ((col instanceof Colaborador) && (colSelecionados.contains(((Colaborador) col).getId()))) {
                if (!publicacao.colaboradores.contains(((Colaborador) col))) {
                    publicacao.colaboradores.add(((Colaborador) col));
                }
            }
        }
        for (Object col : mem.getAll()) {
            if ((col instanceof Projeto) && (((Projeto) col).getTitulo().equals(this.request.getParameter("projeto")))) {
                if (!((Projeto) col).publicacoes.contains(publicacao)) {
                    ((Projeto) col).publicacoes.add(publicacao);
                }
            }
        }
        mem.add(publicacao);
        this.param = "?status=1";
    }

    public void alterarStatusProjeto() {
        for (Object obj : mem.getAll()) {
            if ((obj instanceof Projeto) && (((Projeto) obj).getTitulo().equals(this.request.getParameter("projeto")))) {
                ((Projeto) obj).mudarSituacao();
            }
        }
        this.param = "?status=1";
    }

}
