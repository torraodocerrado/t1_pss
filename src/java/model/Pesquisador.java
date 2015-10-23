package model;

/**
 *
 * @author Rafael
 */
public class Pesquisador extends Colaborador {

    public Pesquisador(int id, String nome, String email) {
        super(id, nome, email);
    }

    @Override
    public String toString() {
        String result = "";
        result += "<b>Pesquisador: </b>" + getNome() + "<br><ul>";
        result += "<li><b>ID: </b>" + getId() + "<br></li>";
        result += "<li><b>Nome: </b>" + getNome() + "<br></li>";
        result += "<li><b>Email: </b>" + getEmail() + "<br></li>";
        return result + "</ul>";
    }

}
