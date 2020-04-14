package com.ldon.covid19.service.riskanalisys;

import java.util.ArrayList;
import java.util.List;

/**
 * author LucasDonizeti
 */
public class RiskAnalisys {
    public static List<Sintoma> getSintomas(){
        List<Sintoma> sintomas=new ArrayList<>();
        sintomas.add(new Sintoma("Febre", (float) 0.2, false,1));
        sintomas.add(new Sintoma("Cansaso", (float) 0.2, false,2));
        sintomas.add(new Sintoma("Tosse", (float) 0.2, false,3));
        sintomas.add(new Sintoma("Espirro", (float) 0.1, false,4));
        sintomas.add(new Sintoma("Dores musculares", (float) 0.2, false,5));
        sintomas.add(new Sintoma("Secreção nasal", (float) 0.1, false,6));
        sintomas.add(new Sintoma("Dor de garganta", (float) 0.2, false,7));
        sintomas.add(new Sintoma("Diarreia", (float) 0.1, false,8));
        sintomas.add(new Sintoma("Dor de cabeca", (float) 0.2, false,9));
        sintomas.add(new Sintoma("Falta de ar", (float) 0.8, false,10));
        return sintomas;
    }

    public static List<Doenca> getDoenca(){
        List<Doenca> saude=new ArrayList<>();
        saude.add(new Doenca("Hipertensão", (float) 0.4, false,1));
        saude.add(new Doenca("Doenças respiratórias", (float) 0.5, false,2));
        saude.add(new Doenca("Diabetes", (float) 0.7, false,3));
        saude.add(new Doenca("Doenças Cardiovasculares", (float) 0.9, false,4));

        return saude;
    }

    public static RiskAnalisysData radObjectConvert(List<Integer> doencasId, List<Integer> sintomasId, Boolean isM, int idade){
        List<Sintoma> sintomas=getSintomas();
        for(Sintoma s:sintomas){
            for(int sid:sintomasId){
                if (s.getId()==sid){
                    s.setCondicao(true);
                }
            }
        }
        List<Doenca> doencas=getDoenca();
        for(Doenca s:doencas){
            for(int did:doencasId){
                if (s.getId()==did){
                    s.setCondicao(true);
                }
            }
        }
        RiskAnalisysData rad=new RiskAnalisysData();
        rad.setIdade(idade);
        rad.setM(isM);
        rad.setSintomas(sintomas);
        rad.setDoenca(doencas);

        return rad;
    }
}
