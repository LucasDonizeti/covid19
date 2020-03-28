package com.ldon.covid19.controller;

import com.ldon.covid19.model.CountriesStat;
import com.ldon.covid19.model.CurrencyPrice;
import com.ldon.covid19.repository.CountryRepository;
import com.ldon.covid19.repository.CurrencyPriceRepository;
import com.ldon.covid19.service.currency.GetCurrencyFromAwesomeApi;
import com.ldon.covid19.service.pandemic.GetDataFromExternalAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author LucasDonizeti
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public CountryRepository countryDAO;

    @Autowired
    public CurrencyPriceRepository currencyDAO;

    @GetMapping()
    public ModelAndView adminHome() {
        return new ModelAndView("/adminhome");
    }

    @GetMapping("/att/cases")
    public ModelAndView saveCountries() {
        Boolean x = saveListCountry();
        ModelAndView mv=new ModelAndView("/adminatt");
        if (x) {
            mv.addObject("horario",horarioAtual());
            mv.addObject("modulo","pandemic");
            return mv;
        } else {
            mv.addObject("horario",horarioAtual());
            mv.addObject("modulo","Falha pandemic");
            return mv;
        }
    }

    @GetMapping("/att/currency")
    public ModelAndView saveCurrency() {
        Boolean x = saveListCurrency();
        ModelAndView mv=new ModelAndView("/adminatt");
        if (x) {
            mv.addObject("horario",horarioAtual());
            mv.addObject("modulo","currency");
            return mv;
        } else {
            mv.addObject("horario",horarioAtual());
            mv.addObject("modulo","Falha currency");
            return mv;
        }
    }


    private String horarioAtual(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private Boolean saveListCurrency() {
        try {
            List<CurrencyPrice> cp = GetCurrencyFromAwesomeApi.getCurrencyFromAwesomeApi();
            for (CurrencyPrice currencyPrice : cp) {
                currencyDAO.save(currencyPrice);
            }
            return true;
        } catch (Exception e) {
            System.out.println("falha ao salvar currency price - " + horarioAtual() + " - " + e);
            return false;
        }
    }

    private Boolean saveListCountry() {

        try {
            List<CountriesStat> csl = GetDataFromExternalAPI.getAllData();
            for (CountriesStat cs : csl) {
                countryDAO.save(cs);
            }
            return true;
        } catch (Exception e) {
            System.out.println("falha ao salvar country - " + horarioAtual() + " - " + e);
            return false;
        }
    }
}
