package com.ldon.covid19.controller;

import com.ldon.covid19.model.CountriesStat;
import com.ldon.covid19.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/cases")
    public ModelAndView getCases() {
        List<CountriesStat> countriesStats = countryDAO.findByOrderByCasesDesc();
        ModelAndView mv = new ModelAndView("/cases");
        mv.addObject("countriesStats", countriesStats);
        return mv;
    }

    @GetMapping("/cases/{pais}")
    public ModelAndView getCases(@PathVariable String pais) {
        CountriesStat cs = countryDAO.findByCountry(pais).get(0);
        ModelAndView mv = new ModelAndView("/pais");
        mv.addObject("data", cs);
        return mv;
    }
}
