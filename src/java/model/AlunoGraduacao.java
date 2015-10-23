package model;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class AlunoGraduacao extends Aluno {

    public AlunoGraduacao(int id, String nome, String email, int orientador, Date dataIngresso) {
        super(id, nome, email, orientador, dataIngresso);
    }

    @Override
    public String toString() {
        String result = "";
        result += "<b>Aluno de Graduação: </b>" + getNome() + "<br><ul>";
        result += "<li><b>ID: </b>" + getId() + "<br></li>";
        result += "<li><b>Nome: </b>" + getNome() + "<br></li>";
        result += "<li><b>Email: </b>" + getEmail() + "<br></li>";
        result += "<li><b>Data ingresso: </b>" + getDataIngresso() + "<br></li>";
        result += "<li><b>Orientador: </b>" + getOrientador() + "<br></li>";
        return result + "</ul>";
    }

}
