package com.ldon.covid19.service.riskanalisys;

import java.util.ArrayList;
import java.util.List;

/**
 * author LucasDonizeti
 */
public class RiskAnalisys {
    public static List<Sintoma> getSintomas(){
        List<Sintoma> sintomas=new ArrayList<>();
        sintomas.add(new Sintoma("febre", (float) 0.2, false,1));
        sintomas.add(new Sintoma("cansaso", (float) 0.2, false,2));
        sintomas.add(new Sintoma("tosse", (float) 0.2, false,3));
        sintomas.add(new Sintoma("espirro", (float) 0.1, false,4));
        sintomas.add(new Sintoma("dores musculares", (float) 0.2, false,5));
        sintomas.add(new Sintoma("secreção nasal", (float) 0.1, false,6));
        sintomas.add(new Sintoma("dor de garganta", (float) 0.2, false,7));
        sintomas.add(new Sintoma("diarreia", (float) 0.1, false,8));
        sintomas.add(new Sintoma("dor de cabeca", (float) 0.2, false,9));
        sintomas.add(new Sintoma("falta de ar", (float) 0.8, false,10));
        return sintomas;
    }

    public static List<Doenca> getDoenca(){
        List<Doenca> saude=new ArrayList<>();

        saude.add(new Doenca("nada", (float) 0, false,1));
        saude.add(new Doenca("hipertensao", (float) 0.4, false,2));
        saude.add(new Doenca("doencasResp", (float) 0.5, false,3));
        saude.add(new Doenca("diabetes", (float) 0.7, false,4));
        saude.add(new Doenca("doencasCard", (float) 0.9, false,5));

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
