package com.ldon.covid19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * author LucasDonizeti
 */
@RestController
@RequestMapping("/home")
public class HomePage {
    @GetMapping()
    public ModelAndView getCases() {
        return new ModelAndView("/home");
    }
}
