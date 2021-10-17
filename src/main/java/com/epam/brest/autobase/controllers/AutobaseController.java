package com.epam.brest.autobase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/autobase")
public class AutobaseController {

    @GetMapping()
    public ModelAndView showAutobase() {
        ModelAndView modelAndView = new ModelAndView("autobase");
        return modelAndView;
    }
}
