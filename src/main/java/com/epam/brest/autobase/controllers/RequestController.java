package com.epam.brest.autobase.controllers;

import com.epam.brest.autobase.interfaces.IInitAndDestroyBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/autobase/requests")
public class RequestController implements IInitAndDestroyBean {

    @GetMapping()
    public ModelAndView getRequestList() {
        ModelAndView modelAndView = new ModelAndView("requests/request");
        return modelAndView;
    }
}
