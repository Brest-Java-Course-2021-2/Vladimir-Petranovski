package com.epam.brest.autobase.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IController {
    Logger log = LoggerFactory.getLogger(IController.class);

    default void initMethod() {
        log.info("Initialisation bean {}", getClass().getName());
    }

    default void destroyMethod() {
        log.info("Destroy bean {}", getClass().getName());
    }
}
