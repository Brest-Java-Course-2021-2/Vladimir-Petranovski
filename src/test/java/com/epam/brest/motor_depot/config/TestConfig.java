package com.epam.brest.motor_depot.config;

import com.epam.brest.motor_depot.controllers.RequestController;
import com.epam.brest.motor_depot.dao.RequestDAO;
import com.epam.brest.motor_depot.dao.dto.RequestDTO;
import com.epam.brest.motor_depot.services.RequestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {

    @Bean
    RequestController requestController() {
        return new RequestController(requestService());
    }

    @Bean
    RequestService requestService() {
        return new RequestService(requestDAO(), requestDTO());
    }

    @Bean
    RequestDAO requestDAO() {
        return new RequestDAO();
    }

    @Bean
    RequestDTO requestDTO() {
        return new RequestDTO();
    }
}
