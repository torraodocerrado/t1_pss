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
        if (this.request.getParameter("titulo") != null) {
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
            if (this.request.getParameterValues("professores") != null) {
                for (String col : this.request.getParameterValues("professores")) {
                    colSelecionados.add(Integer.valueOf(col));
                }
            }

            for (Object col : mem.getAll(Colaborador.class)) {
                if ((colSelecionados.contains(((Colaborador) col).getId()))) {
                    if (!publicacao.colaboradores.contains(((Colaborador) col))) {
                        publicacao.colaboradores.add(((Colaborador) col));
                        ((Colaborador) col).producoes.add(publicacao);
                    }
                }
            }
            for (Object col : mem.getAll(Projeto.class)) {
                if ((((Projeto) col).getTitulo().equals(this.request.getParameter("projeto")))) {
                    if (!((Projeto) col).publicacoes.contains(publicacao)) {
                        ((Projeto) col).publicacoes.add(publicacao);
                    }
                }
            }
            mem.add(publicacao);
            this.param = "?status=1";
        }
        this.request.setAttribute("listaProfessores", mem.getAll(Professor.class));
        this.request.setAttribute("listaAlunos", mem.getAll(Aluno.class));
        this.request.setAttribute("listaColaboradores", mem.getAll(Colaborador.class));
        this.request.setAttribute("listaProjetosEmAndamento", this.getProjetosEmAndamento());
        this.request.setAttribute("listaParticipantesProjeto", this.getParticipantesProjeto());
    }

    public void incluirOrientacao() {
        if (this.request.getParameter("titulo") != null) {
            Professor professor = this.getProfessor(Integer.valueOf(this.request.getParameter("professor")));
            Aluno aluno = this.getAluno(Integer.valueOf(this.request.getParameter("aluno")));
            Orientacao orientacao = new Orientacao(this.request.getParameter("titulo"), this.request.getParameter("tipo"), professor, aluno);
            aluno.producoes.add(orientacao);
            professor.producoes.add(orientacao);
            mem.add(orientacao);
            this.param = "?status=1";
        }
        this.request.setAttribute("listaProfessores", mem.getAll(Professor.class));
        this.request.setAttribute("listaAlunos", mem.getAll(Aluno.class));
    }

}
