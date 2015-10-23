package model;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class Aluno extends Colaborador {

    private int orientador;
    private Date dataIngresso;

    public int getOrientador() {
        return orientador;
    }

    public void setOrientador(int orientador) {
        this.orientador = orientador;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public Aluno(int id, String nome, String email, int orientador, Date dataIngresso) {
        super(id, nome, email);
        this.orientador = orientador;
        this.dataIngresso = dataIngresso;
    }

}
