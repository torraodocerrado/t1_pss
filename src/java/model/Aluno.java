package model;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public abstract class Aluno extends Colaborador {

    private Professor orientador;
    private Date dataIngresso;

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    public Aluno(int id, String nome, String email, Professor orientador, Date dataIngresso) {
        super(id, nome, email);
        this.orientador = orientador;
        this.dataIngresso = dataIngresso;
    }

}
