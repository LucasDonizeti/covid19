package com.ldon.covid19.controller;

import com.ldon.covid19.model.CurrencyPrice;
import com.ldon.covid19.repository.CurrencyPriceRepository;
import com.ldon.covid19.service.currency.GetCurrencyFromAwesomeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/currency")
public class CurrencyPriceController {

    private final CurrencyPriceRepository currencyDAO;

    @Autowired
    public CurrencyPriceController(CurrencyPriceRepository currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @GetMapping("/price")
    public ModelAndView getCases() {
        List<CurrencyPrice> currencyPriceList = currencyDAO.findAll();

        ModelAndView mv = new ModelAndView("/currency");
        mv.addObject("currencyList", currencyPriceList);
        return mv;
    }

}