/*
 * JsonReader .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.jalasoft.search.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * JsonReader : Implements a  json reader methods in base to json simple library
 * @author Brayan Rosas
 * @version 0.1
 * @since 03/25/2018
 */
public class JsonReader {

    /**
     * Read the a json file
     * @param jsonFile path of the json file to read
     * @param key of avriable to read in json file
     * @return the value in string type according to the key passed
     */
    public static String getJsonValue(String jsonFile,String key){
        JSONParser parser= new JSONParser();
        try {

            Object fileObject = parser.parse(new FileReader(jsonFile));
            JSONObject jsonObject = (JSONObject) fileObject;
            return (String) jsonObject.get(key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Has been a exception";
    }
}



