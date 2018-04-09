package com.jalasoft.search.controller;

import java.io.FileNotFoundException;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.io.FileInputStream;
import java.io.IOException;

public class LoggerCreator {
    private static LoggerCreator loggerCreator;
    private static Logger logger;

    private LoggerCreator(){

        try (FileInputStream configFile = new FileInputStream("./log.properties")) {
            LogManager.getLogManager().readConfiguration(configFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static LoggerCreator getInstance (){
        if(loggerCreator==null)
            loggerCreator= new LoggerCreator();
        return loggerCreator;
    }
}
