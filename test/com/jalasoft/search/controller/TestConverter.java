/*
 * TestConverter .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 */
package com.jalasoft.search.controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestConverter {
    /**
     * Verify that the date is convert to string in the format yyyy-dd-mm
     */
    @Test
    public void convertLongToDate(){
        String dateExpected="2018-05-04";
         Converter converter =new Converter();
         long dateActual = System.currentTimeMillis();
         assertEquals(dateExpected, converter.covertLongToDate(dateActual) );
    }

    /**
     * Verify that a size in bytes can be converted in KB,MB,GB and TB
     * , in base to the size
     */
    @Test
    public void convertBytesToMB(){
        String sizeExpected="5.70 KB";
        long size=5840;
        Converter converter =new Converter();
        System.out.println(converter.formatFileSize(size));
        assertEquals(sizeExpected, converter.formatFileSize(size) );
    }
}

