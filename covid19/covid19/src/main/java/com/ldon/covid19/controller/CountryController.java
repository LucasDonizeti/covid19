package com.ldon.covid19.controller;

import com.ldon.covid19.model.CountriesStat;
import com.ldon.covid19.repository.CountryRepository;
import com.ldon.covid19.service.GetDataFromExternalAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author LucasDonizeti
 */
@RestController
@RequestMapping("/covid19")
public class CountryController {

    private final CountryRepository countryDAO;

    @Autowired
    public CountryController(CountryRepository countryDAO) {
        this.countryDAO = countryDAO;
    }

    @GetMapping("/admin")
    public ResponseEntity<?> saveCountries() {
        Boolean x = saveListCountry();
        if (x) {
            return new ResponseEntity<>(countryDAO.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            System.out.println("falha ao salvar country - " + dateFormat.format(date) + " - " + e);
            return false;
        }
    }
}
