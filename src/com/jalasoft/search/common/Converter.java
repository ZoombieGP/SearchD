/*
 * Converter .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.jalasoft.search.common;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public class Converter {

    public Converter(){

    }

    /**
     *Convert a long date to date in format yyyy-dd-mm
     * @param longDate
<<<<<<< HEAD
     * @return a date in String type
=======
     * @return a date in String type with format yyyy-dd-MMM
>>>>>>> 3a0c73134741c81c6738cb524dab8d1b1c360d59
     */
    public String covertLongToDate(long longDate){

        Date date=new Date(longDate);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
        String dateText = formatter.format(date);
        return dateText;
    }

    /**
     * Convert to bytes in KB,MB,GB and TB
     * @param size : The size in bytes
     * @return a string of the size convert in  KB ,MB,GB and TB
     */
    public String formatFileSize(long size) {
        String hrSize = null;

        double sizeB = size;
        double sizeKB= size/1024.0;
        double sizeMB= ((size/1024.0)/1024.0);
        double sizeGB = (((size/1024.0)/1024.0)/1024.0);
        double sizeTB = ((((size/1024.0)/1024.0)/1024.0)/1024.0);

        DecimalFormat dec = new DecimalFormat("0.00");

        if ( sizeTB>1 ) {
            hrSize = dec.format(sizeTB).concat(" TB");
        } else if ( sizeGB>1 ) {
            hrSize = dec.format(sizeGB).concat(" GB");
        } else if ( sizeMB>1 ) {
            hrSize = dec.format(sizeMB).concat(" MB");
        } else if ( sizeKB>1 ) {
            hrSize = dec.format(sizeKB).concat(" KB");
        } else {
            hrSize = dec.format(sizeB).concat(" Bytes");
        }

        return hrSize;
    }

    public String convertLongToString(long size) {
        System.out.println("Size: "+size);
        if(size==-1)
            return "";
        String hrSize = null;
        double sizeMB= ((size/1024.0)/1024.0);
        DecimalFormat dec = new DecimalFormat("0");
        hrSize= dec.format(sizeMB);
        System.out.println("Size converter: "+hrSize);
        return hrSize;

    }
}
