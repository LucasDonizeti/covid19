package com.ldon.covid19.service.riskanalisys;

import java.util.ArrayList;
import java.util.List;

/**
 * author LucasDonizeti
 */
public class RiskAnalisysData {
    private List<Sintoma> sintomas = new ArrayList<>();
    private List<Doenca> doenca = new ArrayList<>();
    private int idade;
    private boolean isM;

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public List<Doenca> getDoenca() {
        return doenca;
    }

    public void setDoenca(List<Doenca> doenca) {
        this.doenca = doenca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isM() {
        return isM;
    }

    public void setM(boolean m) {
        isM = m;
    }

    public float calcGravidade(){
        float x=0;
        for (Doenca v : doenca) {
            if (v.getCondicao())
                x += v.getFatorAcc();
        }
        if(x>1)
            return 1;
        return x;
    }

    public float calcRisco(){
        float x;
        if (idade < 20) {
            x = 0;
        } else if (idade < 40) {
            x = (float) 0.1;
        } else if (idade < 50) {
            x = (float) 0.2;
        } else if (idade < 60) {
            x = (float) 0.4;
        } else if (idade < 70) {
            x = (float) 0.6;
        } else if (idade < 80) {
            x = (float) 0.8;
        } else {
            x = (float) 0.95;
        }
        if(isM){
            x+=0.05;
        }
        return x;
    }

    public float calcProb(){
        float x=0;
        for (Sintoma v : sintomas) {
            if (v.getCondicao())
                x += v.getFatorAcc();
        }
        if(x>1)
            return 1;
        return x;
    }
    public Diagnostico calcularDiagnostico() {
        Diagnostico d=new Diagnostico();
        d.setGravidade(calcGravidade());
        d.setProbabilidade(calcProb());
        d.setRisco(calcRisco());
        return d;
    }
}


