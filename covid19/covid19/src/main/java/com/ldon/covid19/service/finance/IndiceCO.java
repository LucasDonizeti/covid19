package com.ldon.covid19.service.finance;

/**
 * author LucasDonizeti
 */
public class IndiceCO {
    private String simbolo;
    private String nome;
    private String preco;
    private String variacao;
    private String variacaoRange;

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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getVariacao() {
        return variacao;
    }

    public void setVariacao(String variacao) {
        this.variacao = variacao;
    }

    public String getVariacaoRange() {
        return variacaoRange;
    }

    public void setVariacaoRange(String variacaoRange) {
        this.variacaoRange = variacaoRange;
    }

    @Override
    public String toString() {
        return "IndiceCO{" +
                "simbolo:" + simbolo +
                ", nome:" + nome +
                ", preco:" + preco +
                ", variacao:" + variacao +
                ", variacaoRange:" + variacaoRange +
                '}';
    }
}
