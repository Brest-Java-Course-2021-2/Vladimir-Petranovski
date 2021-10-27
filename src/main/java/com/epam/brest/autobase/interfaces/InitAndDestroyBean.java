package com.epam.brest.autobase.interfaces;

import static com.epam.brest.autobase.logger.Logging.*;

public interface InitAndDestroyBean {

    default void initMethod() {
        log.info("Initialisation bean {}", getClass().getName());
    }

    default void destroyMethod() {
        log.info("Destroy bean {}", getClass().getName());
    }
}