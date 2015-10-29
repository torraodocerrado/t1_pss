/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rafael
 */
public class RelatorioProducaoAcademica {

    private int numeroColaboradores;
    private int numeroProjetosElaboracao;
    private int numeroProjetosAndamento;
    private int numeroProjetosConcluidos;
    private int numeroProjetos;
    private int numeroPublicacao;
    private int numeroOrientacao;

    public int getNumeroColaboradores() {
        return numeroColaboradores;
    }

    public void setNumeroColaboradores(int numeroColaboradores) {
        this.numeroColaboradores = numeroColaboradores;
    }

    public int getNumeroProjetosElaboracao() {
        return numeroProjetosElaboracao;
    }

    public void setNumeroProjetosElaboracao(int numeroProjetosElaboracao) {
        this.numeroProjetosElaboracao = numeroProjetosElaboracao;
    }

    public int getNumeroProjetosAndamento() {
        return numeroProjetosAndamento;
    }

    public void setNumeroProjetosAndamento(int numeroProjetosAndamento) {
        this.numeroProjetosAndamento = numeroProjetosAndamento;
    }

    public int getNumeroProjetosConcluidos() {
        return numeroProjetosConcluidos;
    }

    public void setNumeroProjetosConcluidos(int numeroProjetosConcluidos) {
        this.numeroProjetosConcluidos = numeroProjetosConcluidos;
    }

    public int getNumeroProjetos() {
        return numeroProjetos;
    }

    public void setNumeroProjetos(int numeroProjetos) {
        this.numeroProjetos = numeroProjetos;
    }

    public int getNumeroPublicacao() {
        return numeroPublicacao;
    }

    public void setNumeroPublicacao(int numeroPublicacao) {
        this.numeroPublicacao = numeroPublicacao;
    }

    public int getNumeroOrientacao() {
        return numeroOrientacao;
    }

    public void setNumeroOrientacao(int numeroOrientacao) {
        this.numeroOrientacao = numeroOrientacao;
    }

    public RelatorioProducaoAcademica(int numeroColaboradores, int numeroProjetosElaboracao, int numeroProjetosAndamento, int numeroProjetosConcluidos, int numeroProjetos, int numeroPublicacao, int numeroOrientacao) {
        this.numeroColaboradores = numeroColaboradores;
        this.numeroProjetosElaboracao = numeroProjetosElaboracao;
        this.numeroProjetosAndamento = numeroProjetosAndamento;
        this.numeroProjetosConcluidos = numeroProjetosConcluidos;
        this.numeroProjetos = numeroProjetos;
        this.numeroPublicacao = numeroPublicacao;
        this.numeroOrientacao = numeroOrientacao;
    }

    @Override
    public String toString() {
        String result = "";
        result += "<b>Relatório de produção acadêmica do laboratório</b><br><ul>";
        result += "<li><b>Número de colaboradores: </b>" + getNumeroColaboradores() + "<br></li>";
        result += "<li><b>Número de projetos em elaboração: </b>" + getNumeroProjetosElaboracao() + "<br></li>";
        result += "<li><b>Número de projetos em andamento: </b>" + getNumeroProjetosAndamento() + "<br></li>";
        result += "<li><b>Número de projetos concluídos: </b>" + getNumeroProjetosConcluidos() + "<br></li>";
        result += "<li><b>Número total de projetos: </b>" + getNumeroProjetos() + "<br></li>";
        result += "<li><b>Número de produções acadêmcias: </b>" + (getNumeroPublicacao() + getNumeroOrientacao()) + "<br></li>";
        result += "<li><b>Número de publicações: </b>" + getNumeroPublicacao() + "<br></li>";
        result += "<li><b>Número de orientações: </b>" + getNumeroOrientacao() + "<br></li>";
        return result + "</ul>";
    }

}
