package com.ldon.covid19.controller;

import com.ldon.covid19.model.CurrencyPrice;
import com.ldon.covid19.repository.CurrencyPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
        List<CurrencyPrice> currencyPriceList = currencyDAO.findByOrderByPctChangeDesc();
        ModelAndView mv = new ModelAndView("/currency");
        mv.addObject("currencyList", currencyPriceList);
        return mv;
    }
}
