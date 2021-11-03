package com.epam.brest.motor_depot.controllers;

import com.epam.brest.motor_depot.config.TestConfig;
import com.epam.brest.motor_depot.models.Request;
import com.epam.brest.motor_depot.services.RequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

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
//        when(requestService.findAllRequest()).thenReturn(requestList);
//        ModelAndView actual = requestController.getRequestList();
//        Assertions.assertEquals(requestList, requestController.getRequestList());
    }
}