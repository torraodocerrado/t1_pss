/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class Projeto {

    private String titulo;
    private String agenciaFinanciadora;
    private String valorFinanciado;
    private String objetivo;
    private String descricao;
    private String situacao;
    private Date dataInicio;
    private Date dataFim;
    public ArrayList<Colaborador> colaboradores;

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAgenciaFinanciadora() {
        return agenciaFinanciadora;
    }

    public void setAgenciaFinanciadora(String agenciaFinanciadora) {
        this.agenciaFinanciadora = agenciaFinanciadora;
    }

    public String getValorFinanciado() {
        return valorFinanciado;
    }

    public void setValorFinanciado(String valorFinanciado) {
        this.valorFinanciado = valorFinanciado;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Projeto(String titulo, String agenciaFinanciadora, String valorFinanciado, String objetivo, String descricao, Date dataInicio) {
        this.titulo = titulo;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.situacao = "Em elaboração";
        this.colaboradores = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "";
        result += "<b>Projeto: </b>" + getTitulo() + "<br><ul>";
        result += "<li><b>Descrição: </b>" + getDescricao() + "<br></li>";
        result += "<li><b>Valor Financiado: </b>" + getValorFinanciado() + "<br></li>";
        result += "<li><b>Agência Financiadora: </b>" + getAgenciaFinanciadora() + "<br></li>";
        result += "<li><b>Objetivo: </b>" + getObjetivo() + "<br></li>";
        result += "<li><b>Situação: </b>" + getSituacao() + "<br></li>";
        result += "<li><b>Data Início: </b>" + getDataInicio() + "<br></li>";
        if (this.getDataFim() != null) {
            result += "<li><b>Data Fim: </b>" + getDataFim() + "<br></li>";
        }
        for (Colaborador colaborador : colaboradores) {
            result += "<li><b>Colaborador: </b><br> " + colaborador.toString() + "<br></li>";
        }
        return result + "</ul>";
    }
}
