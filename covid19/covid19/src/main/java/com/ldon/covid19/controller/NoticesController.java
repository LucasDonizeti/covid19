package com.ldon.covid19.controller;


import com.ldon.covid19.model.Notice;
import com.ldon.covid19.repository.NoticeRepository;
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
@RequestMapping("/news")
public class NoticesController {
    private final NoticeRepository noticeDAO;

    @Autowired
    public NoticesController(NoticeRepository noticeDAO) {
        this.noticeDAO = noticeDAO;
    }

    @GetMapping("/notices")
    public ModelAndView allNotices() {
        List<Notice> newsList = noticeDAO.findByOrderByTimestampDesc();
        ModelAndView mv = new ModelAndView("/news");
        mv.addObject("newsList", newsList);
        return mv;
    }
}
