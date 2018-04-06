package com.jalasoft.search.model;
/**
 Class Directory inherit form ASSET and creates Objects with Properties of Directories since a Search has been performed
 * @version  1.0
 * @author Gilmar Pozzo
 */
public class Directory extends Asset{

    private boolean isDirectory;

    /**
     * Directory Method Constructor
     */
    public void Directory (){
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setIsDirectory(boolean directory) {
        isDirectory = directory;
    }
}
