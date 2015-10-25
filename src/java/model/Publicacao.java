package model;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class Publicacao {

    private String titulo;
    private String conferencia;
    private int anoPublicacao;
    public ArrayList<Colaborador> colaboradores;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Publicacao(String titulo, String conferencia, int anoPublicacao) {
        this.titulo = titulo;
        this.conferencia = conferencia;
        this.anoPublicacao = anoPublicacao;
        this.colaboradores = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "";
        result += "<b>Publicação: </b>" + getTitulo() + "<br><ul>";
        result += "<li><b>Conferência: </b>" + getConferencia() + "<br></li>";
        result += "<li><b>Ano: </b>" + getAnoPublicacao() + "<br></li>";
        for (Colaborador colaborador : colaboradores) {
            result += "<li><b>Colaborador: </b><br> " + colaborador.toString() + "<br></li>";
        }
        return result + "</ul>";
    }

}
