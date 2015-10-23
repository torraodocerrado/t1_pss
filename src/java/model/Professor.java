package model;

/**
 *
 * @author Rafael
 */
public class Professor extends Colaborador {

    public Professor(int id, String nome, String email) {
        super(id, nome, email);
    }

    @Override
    public String toString() {
        String result = "";
        result += "<b>Professor: </b>" + getNome() + "<br><ul>";
        result += "<li><b>ID: </b>" + getId() + "<br></li>";
        result += "<li><b>Nome: </b>" + getNome() + "<br></li>";
        result += "<li><b>Email: </b>" + getEmail() + "<br></li>";
        return result + "</ul>";
    }

}
