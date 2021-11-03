package com.epam.brest.motor_depot.interfaces;

import static com.epam.brest.motor_depot.logger.Logging.*;

public interface InitAndDestroyBean {

    default void initMethod() {
        log.info("Initialisation bean {}", getClass().getName());
    }

    default void destroyMethod() {
        log.info("Destroy bean {}", getClass().getName());
    }
}
