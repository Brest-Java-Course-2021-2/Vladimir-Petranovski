package com.epam.brest.motor_depot.controllers;

import com.epam.brest.motor_depot.interfaces.InitAndDestroyBean;
import com.epam.brest.motor_depot.models.Request;
import com.epam.brest.motor_depot.services.RequestService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/requests")
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

    @GetMapping("/new-request")
    public String showForAddRequest(@ModelAttribute("request") Request request) {
        return "requests/new-request";
    }

    @PostMapping()
    public String addRequest(@ModelAttribute("request") Request request) {
        requestService.saveRequest(request);
        return "redirect:/requests";
    }

    @GetMapping("/{request_id}/update")
    public String showFormForUpdateRequest(@PathVariable("request_id") Integer request_id, Model model) {
        model.addAttribute("request", requestService.findRequestById(request_id));
        return "/requests/update-request";
    }

    @PostMapping("/{request_id}")
    public String updateRequest(@ModelAttribute("request") Request request, @PathVariable("request_id") Integer request_id) {
        requestService.updateRequest(request_id, request);
        return "redirect:/requests";
    }

    @GetMapping("/{request_id}/delete")
    public String deleteRequest(@PathVariable("request_id") Integer request_id) {
        requestService.deleteRequest(request_id);
        return "redirect:/requests";
    }

//    @GetMapping("/{id}")
//    public String getNameDriverById(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("name", requestService.getNameDriverById(id));
//        return "/requests/request";
//    }

}
