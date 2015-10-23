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
public class Orientacao extends ProducaoAcademica {

    private String tipo;
    private final Professor professor;
    private final Aluno aluno;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Orientacao(String titulo, String tipo, Professor professor, Aluno aluno) {
        super(titulo);
        this.tipo = tipo;
        this.professor = professor;
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    @Override
    public String toString() {
        String result = "";
        result += "<b>Orientação: </b>" + getTitulo() + "<br><ul>";
        result += "<li><b>tipo: </b>" + getTipo() + "<br></li>";
        result += "<li>" + this.professor.toString() + "<br></li>";
        result += "<li>" + this.aluno.toString() + "<br></li>";
        return result + "</ul>";
    }
}
