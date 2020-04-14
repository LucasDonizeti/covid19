package com.ldon.covid19.controller;

import com.ldon.covid19.service.riskanalisys.Diagnostico;
import com.ldon.covid19.service.riskanalisys.RiskAnalisys;
import com.ldon.covid19.service.riskanalisys.RiskAnalisysData;
import com.ldon.covid19.service.riskanalisys.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * author LucasDonizeti
 */
@RestController
@RequestMapping("/riskanalisys")
public class RiskAnalisysController {

    @GetMapping
    public ModelAndView formulario(){
        ModelAndView mv=new ModelAndView("/riskanalisysform");
        mv.addObject("sintomas", RiskAnalisys.getSintomas());
        mv.addObject("doencas",RiskAnalisys.getDoenca());

        return mv;
    }

    @PostMapping
    public ModelAndView resultado(@ModelAttribute("rad")Rad rad){
        System.out.println("idade: " + rad.getIdade());
        System.out.println("sexo: " + rad.getIsM());
        System.out.println("sintomas:");
        rad.getSintomas().forEach(s-> System.out.println(s));
        System.out.println("doencas:");
        rad.getDoencas().forEach(d-> System.out.println(d));
        List<String> s = rad.getSintomas();
        List<Integer> scov=new ArrayList<>();
        for (String a:s){
            scov.add(Integer.parseInt(a));
        }
        s=rad.getDoencas();
        List<Integer> dcov=new ArrayList<>();
        for (String a:s){
            dcov.add(Integer.parseInt(a));
        }
        RiskAnalisysData radata = RiskAnalisys.radObjectConvert(dcov,scov,(rad.getIsM().equals("0")?true:false), Integer.parseInt(rad.getIdade()));

        Diagnostico d = radata.calcularDiagnostico();


        ModelAndView mv=new ModelAndView("/riskanalisysresult");
        mv.addObject("data",radata);
        mv.addObject("res", d);
        return mv;
    }

    class Rad{
        private String idade;
        private String isM;
        private List<String> sintomas = new ArrayList<>();
        private List<String> doencas=new ArrayList<>();

        public Rad() {
        }

        public String getIdade() {
            return idade;
        }

        public void setIdade(String idade) {
            this.idade = idade;
        }

        public String getIsM() {
            return isM;
        }

        public void setIsM(String isM) {
            this.isM = isM;
        }

        public List<String> getSintomas() {
            return sintomas;
        }

        public void setSintomas(List<String> sintomas) {
            this.sintomas = sintomas;
        }

        public List<String> getDoencas() {
            return doencas;
        }

        public void setDoencas(List<String> doencas) {
            this.doencas = doencas;
        }
    }
}
