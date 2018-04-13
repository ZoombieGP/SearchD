/*
 * LoggerCreator.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.jalasoft.search.controller;

import java.io.FileNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Implements the log creation using to configure the log , a log properties file.
 * @author Brayan Rosas
 * @version 0.1
 * @since 04/8/2018
 */
public class LoggerCreator {
    private static LoggerCreator loggerCreator;
    private static Logger logger;

    /**
     * Construct method that read the log.properties
     * and create a LogManger object to capture logs.
     */
    private LoggerCreator(){
        logger = Logger.getLogger(getClass().getName());
        try (FileInputStream configFile = new FileInputStream("./log.properties")) {
            LogManager.getLogManager().readConfiguration(configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to implement the Singleton pattern
     * @return a instance og LoggerCreator class
     */
    public static LoggerCreator getInstance (){
        if(loggerCreator==null)
            loggerCreator= new LoggerCreator();
        return loggerCreator;
    }

    /**
     * Getter for logger
     * @return the current instance for logger;
     */
    public Logger getLogger(){
        return logger;
    }
}
