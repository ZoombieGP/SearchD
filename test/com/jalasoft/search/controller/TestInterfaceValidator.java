/*
 * TestInterfaceValidator .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 */

package com.jalasoft.search.controller;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestInterfaceValidator {

    /**
     * Verify the path is valid
     * @result Sent a file valid path to the method should be return no errors and the evaluation should be true
     */
    @Test
    public void isAValidPath(){
        String path = "/user/temp";
        InterfaceValidator pathTest = new InterfaceValidator();
        assertTrue(pathTest.isValidPath(path));
    }

    /**
     * Verify the path is valid (Negative case)
     * @result Sent a file invalid path to the method should be return no errors and the evaluation should be false
     */
    @Test
    public void isNotAValidPath(){
        String path = "/../user";
        InterfaceValidator pathTest = new InterfaceValidator();
        assertFalse(pathTest.isValidPath(path));

    }

    /**
     * Verify that the file name is valid (happy path)
     * @result Sent a file name valid  to the method should be return no errors and the evaluation should be true
     */
    @Test
    public void fileNameIsValid(){
        String fileName = "*.txt;hola.doc;hola.doc.txt";
        InterfaceValidator pathTest = new InterfaceValidator();
        assertTrue(pathTest.isValidFileName(fileName));

    }

    /**
     * Verify that the file name is valid (Negative case)
     * @result Sent a file name invalid  to the method should be return no errors and the evaluation should be false
     */
    @Test
    public void fileNameIsNotValid(){
        String fileName = ">SomeShare";
        InterfaceValidator pathTest = new InterfaceValidator();
        assertFalse(pathTest.isValidFileName(fileName));

    }

    /**
     * Verify that the file date is valid
     * @result Sent a file date valid  to the method should be return no errors and the evaluation should be true
     */
    @Test
    public void fileNameDateIsValid(){
        String fileDate = "2000-12-31";
        InterfaceValidator pathTest = new InterfaceValidator();
        assertTrue(pathTest.isValidFileDate(fileDate));

    }

    /**
     * Verify that the file date is not valid (Negative case)
     * @result Sent a file date invalid  to the method should be return no errors and the evaluation should be false
     */
    @Test
    public void fileDateIsNotValid(){
        String fileDate = "2000-13-31";
        InterfaceValidator pathTest = new InterfaceValidator();
        assertFalse(pathTest.isValidFileDate(fileDate));

    }
}





