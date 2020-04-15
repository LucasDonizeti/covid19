package com.ldon.covid19.controller;


import com.ldon.covid19.repository.CityDataRepository;
import com.ldon.covid19.repository.StateDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * author LucasDonizeti
 */
@RestController
@RequestMapping("/pandemicbr")
public class PandemicBrController {

    @Autowired
    public CityDataRepository cityDAO;
    @Autowired
    public StateDataRepository stateDAO;

    @GetMapping("/state")
    public ModelAndView states() {
        ModelAndView mv = new ModelAndView("pbr_states");
        mv.addObject("stt", stateDAO.findByOrderByState());
        return mv;
    }

    @GetMapping("/city")
    public ModelAndView citys(Pageable pageable) {
        ModelAndView mv = new ModelAndView("pbr_allcity");
        mv.addObject("pgc",cityDAO.findAll(pageable));
        return mv;
    }

    @GetMapping("/state/{state}")
    public ModelAndView citysByState(Pageable pageable, @PathVariable String state) {
        ModelAndView mv = new ModelAndView("pbr_citybystate");
        mv.addObject("pgc",cityDAO.findByStateOrderByCity(pageable, state));
        return mv;
    }


}
