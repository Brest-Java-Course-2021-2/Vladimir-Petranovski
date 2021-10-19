package com.epam.brest.autobase.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IService {
    Logger log = LoggerFactory.getLogger(IService.class);

    default void initMethod() {
        log.info("Initialisation bean {}", getClass().getName());
    }

    default void destroyMethod() {
        log.info("Destroy bean {}", getClass().getName());
    }
}
