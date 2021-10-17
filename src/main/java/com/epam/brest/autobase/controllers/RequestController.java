package com.epam.brest.autobase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/autobase/requests")
public class RequestController {

    @GetMapping()
    public ModelAndView getRequestList() {
        ModelAndView modelAndView = new ModelAndView("requests/request");
        return modelAndView;
    }
}
