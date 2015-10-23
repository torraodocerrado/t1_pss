package model;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class AlunoPosGraduacao extends Aluno {

    private String regime;
    private String curso;

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public AlunoPosGraduacao(int id, String nome, String email, int orientador, Date dataIngresso, String regime, String curso) {
        super(id, nome, email, orientador, dataIngresso);
        this.regime = regime;
        this.curso = curso;
    }

    @Override
    public String toString() {
        String result = "";
        result += "<b>Aluno de " + getCurso() + ": </b>" + getNome() + "<br><ul>";
        result += "<li><b>ID: </b>" + getId() + "<br></li>";
        result += "<li><b>Nome: </b>" + getNome() + "<br></li>";
        result += "<li><b>Email: </b>" + getEmail() + "<br></li>";
        result += "<li><b>Data ingresso: </b>" + getDataIngresso() + "<br></li>";
        result += "<li><b>Orientador: </b>" + getOrientador() + "<br></li>";
        result += "<li><b>Regime de curso: </b>" + getRegime() + "<br></li>";
        return result + "</ul>";
    }

}
