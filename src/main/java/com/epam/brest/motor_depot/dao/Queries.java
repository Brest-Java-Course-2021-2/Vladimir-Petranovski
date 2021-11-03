package com.epam.brest.motor_depot.dao;

import com.epam.brest.motor_depot.interfaces.InitAndDestroyBean;

public class Queries implements InitAndDestroyBean {

    public static final String REQUEST_FIND_ALL = "SELECT * FROM `request`;";
    public static final String REQUEST_SAVE = "INSERT INTO `request` (`name`, `driver_id`) VALUES (?1, ?2);";
    public static final String REQUEST_FIND_BY_ID = "SELECT * FROM `request` WHERE `request_id` = ?;";
    public static final String REQUEST_UPDATE = "UPDATE `request` SET `name` = ?2, `driver_id` = ?3 WHERE `request_id` = ?1;";
    public static final String REQUEST_DELETE = "DELETE FROM `request` WHERE `request_id` = ?;";
    public static final String DRIVER_FIND_NAME_DRIVER_BY_ID =
            "SELECT d.name FROM request as r RIGHT JOIN driver as d ON r.driver_id=d.driver_id WHERE r.request_id=?;";
    public static final String REQUEST_COUNT_CARS_FOR_DRIVER = "SELECT COUNT( c.driver_id) FROM request r RIGHT JOIN driver d ON r.driver_id=d.driver_id RIGHT JOIN car c ON d.driver_id = c.driver_id WHERE r.driver_id=?;";

    public static final String DRIVER_FIND_ALL = "SELECT * FROM `driver`;";
    public static final String DRIVER_SAVE =
            "INSERT INTO `driver` (`name`, `date_start_work`, `salary`) VALUES (?1, ?2, ?3);";
    public static final String DRIVER_FIND_BY_ID = "SELECT * FROM `driver` WHERE `driver_id` = ?;";
    public static final String DRIVER_UPDATE =
            "UPDATE `driver` SET `name` = ?2, `date_start_work` = ?3, `salary` = ?4 WHERE `driver_id` = ?1;";
    public static final String DRIVER_DELETE = "DELETE FROM `driver` WHERE `driver_id` = ?;";
    public static final String DRIVER_AVG_SALARY = "SELECT AVG(salary) FROM driver;";

    public static final String CAR_FIND_ALL = "SELECT * FROM `car`;";
    public static final String CAR_SAVE =
            "INSERT INTO `car` (`model`, `driver_id`) VALUES (?1, ?2);";
    public static final String CAR_FIND_BY_ID = "SELECT * FROM `car` WHERE `car_id` = ?;";
    public static final String CAR_UPDATE
            = "UPDATE `car` SET `model` = ?2, `driver_id` = ?3 WHERE `car_id` = ?1;";
    public static final String CAR_DELETE = "DELETE FROM `car` WHERE `car_id` = ?;";
}
