/*
 * InterfaceValidator .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */

package com.jalasoft.search.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.jalasoft.search.GlobalVariables;

import javax.xml.bind.annotation.XmlElementDecl;


/**
 * InterfaceValidator : Validate all data received by UI
 * @author Brayan Rosas
 * @version 0.1
 * @since 03/16/2018
 */
public class InterfaceValidator {

    String regexPath;
    String regexFileName;
    String regexFileDate;

    /**
     * InterfaceValidator Constructor
     * Inicialize the regular expressions
     */
    public InterfaceValidator(){
        String pathRegexFile=GlobalVariables.REGEX_FILE;
        regexPath= JsonReader.getJsonValue(pathRegexFile,GlobalVariables.KEY_REG_EX_PATH);
        regexFileName= JsonReader.getJsonValue(pathRegexFile,GlobalVariables.KEY_REG_EX_FILE_NAME);
        regexFileDate= JsonReader.getJsonValue(pathRegexFile,GlobalVariables.KEY_REG_EX_FILE_DATE);
    }

    /**
     * Validate if the text is a valid file path
     * @param filePath String The file path got of the UI
     * @return boolean true if the file path is valid and false if not
     */
    public boolean isValidPath(String filePath){
        return patternValidator(filePath, Pattern.compile(regexPath), "Invalid path", "Valid path");

    }

    /**
     * Validate if the text is a valid file name
     * @param fileName String The file name got of the UI
     * @return boolean true if the file name is valid and false if not
     */
    public boolean isValidFileName(String fileName){
        return patternValidator(fileName, Pattern.compile(regexFileName), "Invalid name", "Valid name");
    }

    /**
     * Validate if the text is a valid file date in the next format :
     * YYYY-DD-MM
     * @param fileDate String The file date got of the UI
     * @return boolean true if the file date is valid and false if not
     */
    public boolean isValidFileDate(String fileDate){
        return patternValidator(fileDate, Pattern.compile(regexFileDate), "Invalid date", "Valid date");
    }

    /**
     *
     * @param textToEvaluate This contents the text to evaluate
     * @param compile This contents the compile object created with the regex
     * @param messageFalse This contents the message to shown when the validation returns false
     * @param messageTrue  This contents the message to shown when the validation returns true
     * @return boolean Return the result of evaluate the text with regex
     */
    private boolean patternValidator(String textToEvaluate, Pattern compile, String messageFalse, String messageTrue) {
        Pattern pattern = compile;
        Matcher match = pattern.matcher(textToEvaluate);

        if (!match.find()) {
            System.out.println(messageFalse);
            return false;
        }
        System.out.println(messageTrue);
        return true;
    }

    /**
     * Filter blank spaces and tabulations
     * @param fileName Receive the fileName valid but without filter
     * @return the fileName filtered
     */
    private String FilterFileName (String fileName){

        fileName= fileName.replaceAll("\\s","");
        return fileName;
    }

    public boolean validateAdvancedTab(List<Object> uiElemnts){
        if(uiElemnts.get(0).toString().isEmpty())
            return false;
        return true;
    }
}



