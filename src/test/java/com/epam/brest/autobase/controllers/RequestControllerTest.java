package com.epam.brest.autobase.controllers;

import com.epam.brest.autobase.config.TestConfig;
import com.epam.brest.autobase.models.Request;
import com.epam.brest.autobase.services.RequestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class RequestControllerTest {

    private RequestController requestController;

    @Mock
    private RequestService requestService;

    private List<Request> requestList;


    @BeforeEach
    void setUp() {
        requestController = new RequestController(requestService);
        requestList = List.of(Request.builder()
                .request_id(1)
                .name("Vavan")
                .driver_id(1)
                .build(),
                Request.builder()
                .request_id(2)
                .name("Boris")
                .driver_id(2)
                .build());
    }

    @Test
    void getRequestList() {
        when(requestService.findAllRequest()).thenReturn(requestList);
//        ModelAndView actual = requestController.getRequestList();
        Assertions.assertEquals(requestList, requestController.getRequestList());
    }
}