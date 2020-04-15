package com.ldon.covid19.service.riskanalisys;

/**
 * author LucasDonizeti
 */
public class Diagnostico {
    private float gravidade=0;
    private float risco=0;
    private float probabilidade=0;
    private float total=0;

    public float getGravidade() {
        return gravidade;
    }

    public void setGravidade(float gravidade) {
        this.gravidade = gravidade;
        attTotal();
    }

    public float getRisco() {
        return risco;
    }

    public void setRisco(float risco) {
        this.risco = risco;
        attTotal();
    }

    public float getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(float probabilidade) {
        this.probabilidade = probabilidade;
        attTotal();
    }

    public float getTotal() {
        return total;
    }

    private void attTotal(){
        total=(gravidade+risco+probabilidade)/3;
    }

}
