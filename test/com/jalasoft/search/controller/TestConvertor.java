package com.jalasoft.search.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestConvertor {

    @Test
    public void convertLongToDate(){
        String dateExpected="2018-04-04";
         Converter converter =new Converter();
         long dateActual = System.currentTimeMillis();
         assertEquals(dateExpected, converter.covertLongToDate(dateActual) );
    }

    @Test
    public void convertBytesToMB(){
        String sizeExpected="5.70 KB";
        long size=5840;
        Converter converter =new Converter();
        System.out.println(converter.formatFileSize(size));
        assertEquals(sizeExpected, converter.formatFileSize(size) );
    }
}
