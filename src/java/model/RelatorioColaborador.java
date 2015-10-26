/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class RelatorioColaborador {

    private final Colaborador colaborador;

    public RelatorioColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        String result = "";
        result += "<b>Relatório Colaborador: </b>" + colaborador.getNome() + "<ul>";
        result += "<li><b>Nome: </b>" + colaborador.getNome() + "</li>";
        result += "<li><b>Email: </b>" + colaborador.getEmail() + "</li>";

        if (colaborador.projetos.size() > 0) {
            result += "<br><li><b>Projetos que participou:</b></li>";
            result += "<ul>";
            for (Projeto prod : colaborador.projetos) {
                result += "<li>Projeto: " + prod.getTitulo() + "<br></li>";
                result += "<li>Data inicio:" + prod.getSituacao() + "<br></li>";
                if (prod.getDataFim() != null) {
                    result += "<li>Data fim:" + prod.getSituacao() + "<br></li>";
                }
            }
            result += "</ul><br><br>";
        }

        result += "<br><br><li><b>Produção acadêmcia:<b></li>";
        for (Object prod : this.getPublicacoesOrdenadas(colaborador)) {
            if (prod instanceof Publicacao) {
                result += "<br><b>Publicação: </b>" + ((Publicacao) prod).getTitulo() + "<br><ul>";
                result += "<li><b>Conferência: </b>" + ((Publicacao) prod).getConferencia() + "<br></li>";
                result += "<li><b>Ano: </b>" + ((Publicacao) prod).getAnoPublicacao() + "<br></li>";
                result += "</ul>";
            }
            if (prod instanceof Orientacao) {
                result += "<br><b>Orientação: </b>" + ((Orientacao) prod).getTitulo() + "<br><ul>";
                result += "<li><b>tipo: </b>" + ((Orientacao) prod).getTipo() + "<br></li>";
                if (((Orientacao) prod).getProfessor().equals(colaborador)) {
                    result += "<li><b>Aluno: </b>" + ((Orientacao) prod).getAluno().getNome() + "<br></li>";
                } else {
                    result += "<li><b>Professor: </b>" + ((Orientacao) prod).getProfessor().getNome() + "<br></li>";
                }
                return result + "</ul>";
            }
        }
        return result + "</ul>";
    }

    private ArrayList<ProducaoAcademica> getPublicacoesOrdenadas(Colaborador colaborador) {
        ArrayList<ProducaoAcademica> pub = new ArrayList<>();
        ArrayList<ProducaoAcademica> ori = new ArrayList<>();
        for (Object prod : colaborador.producoes) {
            if (prod instanceof Publicacao) {
                pub.add((Publicacao) prod);
            }
            if (prod instanceof Orientacao) {
                ori.add((Orientacao) prod);
            }
        }
        pub.sort((Object o1, Object o2) -> ((Publicacao) o2).getAnoPublicacao() - ((Publicacao) o1).getAnoPublicacao());
        pub.addAll(ori);
        return pub;

    }

}
