package com.epam.brest.autobase.config;

import com.epam.brest.autobase.controllers.RequestController;
import com.epam.brest.autobase.dao.RequestDAO;
import com.epam.brest.autobase.dao.dto.RequestDTO;
import com.epam.brest.autobase.services.RequestService;
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
