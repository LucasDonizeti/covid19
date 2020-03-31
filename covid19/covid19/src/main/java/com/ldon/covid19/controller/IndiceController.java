package com.ldon.covid19.controller;

import com.ldon.covid19.model.Indice;
import com.ldon.covid19.repository.IndiceRepository;
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
@RequestMapping("/finance")
public class IndiceController {
    private final IndiceRepository indiceDAO;

    @Autowired
    public IndiceController(IndiceRepository indiceDAO) {
        this.indiceDAO = indiceDAO;
    }

    @GetMapping("/indices")
    public ModelAndView getCases() {
        List<Indice> indiceList = indiceDAO.findAll();
        ModelAndView mv = new ModelAndView("/finance");
        mv.addObject("indiceList", indiceList);
        return mv;
    }
}
