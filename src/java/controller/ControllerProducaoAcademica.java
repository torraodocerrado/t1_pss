package controller;

import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import model.Aluno;
import model.Colaborador;
import model.Orientacao;
import model.Professor;
import model.Projeto;
import model.Publicacao;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "ControllerProducaoAcademica", urlPatterns = {"/ControllerProducaoAcademica"})
public class ControllerProducaoAcademica extends Base {

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controle de produção acadêmica";
    }

    public void incluirPublicacao() {
        Publicacao publicacao = new Publicacao(
                this.request.getParameter("titulo"),
                this.request.getParameter("conferencia"),
                Integer.valueOf(this.request.getParameter("anoPublicacao"))
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

    public void incluirOrientacao() {
        Professor professor = this.getProfessor(Integer.valueOf(this.request.getParameter("professor")));
        Aluno aluno = this.getAluno(Integer.valueOf(this.request.getParameter("aluno")));
        Orientacao orientacao = new Orientacao(this.request.getParameter("titulo"), this.request.getParameter("tipo"), professor, aluno);
        mem.add(orientacao);
        this.param = "?status=1";
    }

}
