package controller;

import java.util.ArrayList;
import model.AlunoGraduacao;
import model.Colaborador;
import model.Professor;
import model.Projeto;

/**
 *
 * @author Rafael
 */
public class Memoria {

    private static ArrayList<Object> memoria;

    public Memoria() {
        if (memoria == null) {
            memoria = new ArrayList<>();
        }
    }

    public void add(Object object) {
        memoria.add(object);
    }

    public ArrayList<Object> getAll() {
        return memoria;
    }

    public ArrayList<Object> getAll(Class className) {
        ArrayList<Object> temp = new ArrayList<>();
        for (Object mem : memoria) {
            if (className.isInstance(mem)) {
                temp.add(mem);
            }
        }
        return temp;
    }

    public ArrayList<Object> getParticipantesProjeto() {
        ArrayList<Object> temp = new ArrayList<>();
        for (Object mem : memoria) {
            if ((mem instanceof Colaborador) && (!(mem instanceof Professor))) {
                if (!(mem instanceof AlunoGraduacao) || (this.getNumeroProjetosAndamentoAlunoParticipa((AlunoGraduacao) mem) < 2)) {
                    temp.add(mem);
                }
            }
        }
        return temp;
    }

    public int getNumeroProjetosAndamentoAlunoParticipa(AlunoGraduacao aluno) {
        int num = 0;
        for (Projeto mem : this.getProjetosEmAndamento()) {
            if (mem.colaboradores.contains(aluno)) {
                num++;
            }
        }
        return num;
    }

    public ArrayList<Projeto> getProjetosEmElaboracao() {
        ArrayList<Projeto> result = new ArrayList<>();
        for (Object mem : memoria) {
            if ((mem instanceof Projeto) && ((Projeto) mem).getSituacao().equals("Em elaboração")) {
                result.add((Projeto) mem);
            }
        }
        return result;
    }

    public ArrayList<Projeto> getProjetosEmAndamento() {
        ArrayList<Projeto> result = new ArrayList<>();
        for (Object mem : memoria) {
            if ((mem instanceof Projeto) && ((Projeto) mem).getSituacao().equals("Em andamento")) {
                result.add((Projeto) mem);
            }
        }
        return result;
    }

    public ArrayList<Projeto> getProjetoMudancaSituacaoEmAndamento() {
        ArrayList<Projeto> result = new ArrayList<>();
        result.addAll(this.getProjetosEmElaboracao());
        result = this.validaProjetosMudancaSituacao(result);
        return result;
    }

    public ArrayList<Projeto> getProjetoMudancaSituacaoConcluido() {
        ArrayList<Projeto> result = new ArrayList<>();
        result.addAll(this.getProjetosEmAndamento());
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

}
