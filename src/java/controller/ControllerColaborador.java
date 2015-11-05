package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import model.AlunoGraduacao;
import model.AlunoPosGraduacao;
import model.Pesquisador;
import model.Professor;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "ControllerColaborador", urlPatterns = {"/ControllerColaborador"})
public class ControllerColaborador extends Controller {

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controller colaborador";
    }

    public void incluirAlunoGraduacao() {
        if (this.request.getParameter("id") != null) {
            try {
                AlunoGraduacao aluno = new AlunoGraduacao(
                        Integer.valueOf(this.request.getParameter("id")),
                        this.request.getParameter("nome"),
                        this.request.getParameter("email"),
                        this.getProfessor(Integer.valueOf(this.request.getParameter("professor"))),
                        new SimpleDateFormat("dd/MM/yyyy").parse(this.request.getParameter("dataIngresso"))
                );
                mem.add(aluno);
                this.param = "?status=1";
            } catch (ParseException ex) {
                Logger.getLogger(ControllerColaborador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.request.setAttribute("listaProfessores", mem.getAll(Professor.class));
    }

    public void incluirAlunoPosGraduacao() {
        if (this.request.getParameter("id") != null) {
            try {
                AlunoPosGraduacao aluno = new AlunoPosGraduacao(
                        Integer.valueOf(this.request.getParameter("id")),
                        this.request.getParameter("nome"),
                        this.request.getParameter("email"),
                        this.getProfessor(Integer.valueOf(this.request.getParameter("professor"))),
                        new SimpleDateFormat("dd/MM/yyyy").parse(this.request.getParameter("dataIngresso")),
                        this.request.getParameter("regime"),
                        this.request.getParameter("curso")
                );
                mem.add(aluno);
                this.param = "?status=1";
            } catch (ParseException ex) {
                Logger.getLogger(ControllerColaborador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.request.setAttribute("listaProfessores", mem.getAll(Professor.class));
    }

    public void incluirProfessor() {
        if (this.request.getParameter("id") != null) {
            Professor professor = new Professor(
                    Integer.valueOf(this.request.getParameter("id")),
                    this.request.getParameter("nome"),
                    this.request.getParameter("email")
            );
            mem.add(professor);
            this.param = "?status=1";
        }
    }

    public void incluirPesquisador() {
        if (this.request.getParameter("id") != null) {
            Pesquisador pesquisador = new Pesquisador(
                    Integer.valueOf(this.request.getParameter("id")),
                    this.request.getParameter("nome"),
                    this.request.getParameter("email")
            );
            mem.add(pesquisador);
            this.param = "?status=1";
        }
    }

}
