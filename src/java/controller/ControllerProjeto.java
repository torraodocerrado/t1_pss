package controller;

import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import model.Colaborador;
import model.Professor;
import model.Projeto;

/**
 *
 * @author Rafael
 */
@WebServlet(urlPatterns = {"/ControllerProjeto"})
public class ControllerProjeto extends Controller {

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controller Projeto";
    }

    public void incluirProjeto() {
        if (this.request.getParameter("titulo") != null) {
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
    }

    public void incluirColaboradoresProjeto() {
        if (this.request.getParameter("projeto") != null) {
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
                    for (Object col : mem.getAll(Colaborador.class)) {
                        if ((col instanceof Professor) && (profSelecionados.contains(((Professor) col).getId()))) {
                            if (!((Projeto) proj).professores.contains((Professor) col)) {
                                ((Projeto) proj).professores.add((Professor) col);
                                ((Colaborador) col).projetos.add((Projeto) proj);
                            }
                        } else if ((colSelecionados.contains(((Colaborador) col).getId()))) {
                            if (!((Projeto) proj).colaboradores.contains((Colaborador) col)) {
                                ((Projeto) proj).colaboradores.add((Colaborador) col);
                                ((Colaborador) col).projetos.add((Projeto) proj);
                            }
                        }
                    }
                }
            }
            this.param = "?status=1";
        }
        this.request.setAttribute("listaProfessores", mem.getAll(Professor.class));
        this.request.setAttribute("listaProjetosElaboracao", this.getAllProjetosPorSituacao("Em elaboração"));
        this.request.setAttribute("listaParticipantesProjeto", this.getParticipantesProjeto());
    }

    public void mudarStatusProjetoParaEmAndamento() {
        if (this.request.getParameter("projeto") != null) {
            for (Object obj : mem.getAll()) {
                if ((obj instanceof Projeto) && (((Projeto) obj).getTitulo().equals(this.request.getParameter("projeto")))) {
                    ((Projeto) obj).setSituacao("Em andamento");
                }
            }
            this.param = "?status=1";
        }
        this.request.setAttribute("listaProjetosMudancaSituacaoEmAndamento", this.getProjetoMudancaSituacaoEmAndamento());
    }

    public void mudarStatusProjetoParaConcluido() {
        if (this.request.getParameter("projeto") != null) {
            for (Object obj : mem.getAll()) {
                if ((obj instanceof Projeto) && (((Projeto) obj).getTitulo().equals(this.request.getParameter("projeto")))) {
                    ((Projeto) obj).setSituacao("Concluído");
                    ((Projeto) obj).setDataFim(Date.valueOf(this.request.getParameter("dataFim")));
                }
            }
            this.param = "?status=1";
        }
        this.request.setAttribute("listaProjetosMudancaSituacaoConcluido", this.getProjetoMudancaSituacaoConcluido());
    }

    private ArrayList<Projeto> getProjetoMudancaSituacaoConcluido() {
        ArrayList<Projeto> result = new ArrayList<>();
        result.addAll(this.getAllProjetosPorSituacao("Em andamento"));
        result = this.validaProjetosMudancaSituacao(result);
        return result;
    }

    private ArrayList<Projeto> validaProjetosMudancaSituacao(ArrayList<Projeto> projetos) {
        ArrayList<Projeto> result = new ArrayList<>();
        for (Projeto proj : projetos) {
            if (proj.validoMudancaStatus()) {
                result.add(proj);
            }
        }
        return result;
    }

    private ArrayList<Projeto> getProjetoMudancaSituacaoEmAndamento() {
        ArrayList<Projeto> result = new ArrayList<>();
        result.addAll(this.getAllProjetosPorSituacao("Em elaboração"));
        result = this.validaProjetosMudancaSituacao(result);
        return result;
    }

}
