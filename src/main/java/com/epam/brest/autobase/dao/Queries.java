package com.epam.brest.autobase.dao;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;

public class Queries implements InitAndDestroyBean {

    public static final String REQUEST_FIND_ALL = "SELECT * FROM `request`;";

    public static final String DRIVER_FIND_ALL = "SELECT * FROM `driver`;";
    public static final String DRIVER_SAVE =
            "INSERT INTO `driver` (`name`, `date_start_work`, `salary`) VALUES (?1, ?2, ?3);";
    public static final String DRIVER_FIND_BY_ID = "SELECT * FROM `driver` WHERE `driver_id` = ?;";
    public static final String DRIVER_UPDATE =
            "UPDATE `driver` SET `name` = ?2, `date_start_work` = ?3, `salary` = ?4 WHERE `driver_id` = ?1;";
    public static final String DRIVER_DELETE = "DELETE FROM `driver` WHERE `driver_id` = ?;";
}
