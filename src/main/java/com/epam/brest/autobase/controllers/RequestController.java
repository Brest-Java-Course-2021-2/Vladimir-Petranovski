package com.epam.brest.autobase.controllers;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.services.RequestService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/requests")
public class RequestController implements InitAndDestroyBean {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

//    @GetMapping()
//    public String getRequestList(Model model) {
//            model.addAttribute("requestList", requestService.findAllRequest());
//            return "requests/request";
//    }

    @GetMapping()
    public ModelAndView getRequestList() {
        ModelAndView modelAndView = new ModelAndView("requests/request");
        modelAndView.addObject("requestList", requestService.findAllRequest());
        return modelAndView;
    }
}
