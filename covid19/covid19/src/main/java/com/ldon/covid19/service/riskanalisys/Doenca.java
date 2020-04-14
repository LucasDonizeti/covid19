package com.ldon.covid19.service.riskanalisys;

/**
 * author LucasDonizeti
 */
public class Doenca {
    private String nome;
    private float fatorAcc;
    private boolean condicao;
    public int id;

    public Doenca(String nome, float fatorAcc, boolean condicao, int id) {
        this.nome = nome;
        this.fatorAcc = fatorAcc;
        this.condicao = condicao;
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getFatorAcc() {
        return fatorAcc;
    }

    public void setFatorAcc(float fatorAcc) {
        this.fatorAcc = fatorAcc;
    }

    public boolean getCondicao() {
        return condicao;
    }

    public void setCondicao(boolean condicao) {
        this.condicao = condicao;
    }

    public boolean isCondicao() {
        return condicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
