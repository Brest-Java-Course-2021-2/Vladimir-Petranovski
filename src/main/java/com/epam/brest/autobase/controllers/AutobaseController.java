package com.epam.brest.autobase.controllers;

import com.epam.brest.autobase.interfaces.IInitAndDestroyBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/autobase")
public class AutobaseController implements IInitAndDestroyBean {

    @GetMapping()
    public ModelAndView showAutobase() {
        ModelAndView modelAndView = new ModelAndView("autobase");
        return modelAndView;
    }
}
