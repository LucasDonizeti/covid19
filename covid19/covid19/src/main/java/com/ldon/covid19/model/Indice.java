package com.ldon.covid19.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * author LucasDonizeti
 */
@Entity
public class Indice {
    @Id
    private String simbolo;
    private String nome;
    private float preco;
    private float variacao;
    private float variacaoRange;
    private String dateAtt;

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getVariacao() {
        return variacao;
    }

    public void setVariacao(float variacao) {
        this.variacao = variacao;
    }

    public float getVariacaoRange() {
        return variacaoRange;
    }

    public void setVariacaoRange(float variacaoRange) {
        this.variacaoRange = variacaoRange;
    }

    public String getDateAtt() {
        return dateAtt;
    }

    public void setDateAtt(String dateAtt) {
        this.dateAtt = dateAtt;
    }

    @Override
    public String toString() {
        return "IndiceCO{" +
                "simbolo:" + simbolo +
                ", nome:" + nome +
                ", preco:" + preco +
                ", variacao:" + variacao +
                ", variacaoRange:" + variacaoRange +
                ", dateAtt:" + dateAtt +
                '}';
    }
}
