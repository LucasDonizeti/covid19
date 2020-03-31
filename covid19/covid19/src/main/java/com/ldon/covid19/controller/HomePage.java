package com.ldon.covid19.controller;

import com.ldon.covid19.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    public NoticeRepository noticeDAO;

    @GetMapping()
    public ModelAndView getCases() {
        return new ModelAndView("/home").addObject("notices", noticeDAO.findByOrderByTimestampDesc());
    }
}
