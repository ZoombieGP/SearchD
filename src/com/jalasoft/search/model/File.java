/*
 * File.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.model;

/**
 *
 Class File creates Objects with Properties of Files since a Search has been performed
 *
 * @version  1.0
 * @author Gilmar Pozzo
 */
public class File {
    private String path;
    private String name;
    private Long size;
    private Long dateModification;
    private boolean isDirectory;
    private boolean isHidden;

    /**
     * File Method Constructor
     */
    public void File (){

    }

    /**
     *getPath method encapsulate Path variable
     * @return
     * path value
     */
    public String getPath() {

        return path;
    }

    /**
     * getName method encapsulate name variable
     * @return
     * File name Value
     */
    public String getName() {

        return name;
    }

    /**
     * getSize method encapsulate size variable
     * @return
     * size value
     */
    public Long getSize() {

        return size;
    }

    /**
     *method encapsulate dateModification variable
     * @return
     * dateModification value
     */
    public Long getDateModification() {

        return dateModification;
    }

    /**
     *method encapsulate isDirectory variable
     * @return
     * isDirectory value
     */
    public boolean getIsDirectory() {
        return isDirectory;
    }

    /**
     * method encapsulate isHidden variable
     * @return
     * isHidden value
     */
    public boolean getIsHidden() {
        return isHidden;
    }

    /**
     * method encapsulate path variable
     * @param path
     * set path value
     */
    public void setPath(String path) {

        this.path = path;
    }

    /**
     * method encapsulate name variable
     * @param name
     * set name value
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * method encapsulate dateModification variable
     * @param size
     */
    public void setSize(Long size) {

        this.size = size;
    }

    /**
     * method encapsulate dateModification variable
     * @param dateModification
     * set dateModification value
     */
    public void setDateModification(Long dateModification) {

        this.dateModification = dateModification;
    }

    /**
     * method encapsulate isDirectory variable
     * @param isDirectory
     * set isDirectory value
     */
    public void setIsDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    /**
     * method encapsulate isHidden variable
     * @param isHidden
     * set isHidden value
     */
    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }
}
