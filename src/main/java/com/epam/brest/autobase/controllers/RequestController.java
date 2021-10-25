package com.epam.brest.autobase.controllers;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.services.RequestService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/autobase/requests")
public class RequestController implements InitAndDestroyBean {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping()
    public String getRequestList(Model model) {
            model.addAttribute("requestList", requestService.findAllRequest());
            return "requests/request";
    }
}
