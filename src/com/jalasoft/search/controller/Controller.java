/*
 * Controller .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.jalasoft.search.controller;
import com.jalasoft.search.model.FileSearch;
import com.jalasoft.search.view.Window;
import com.jalasoft.search.model.Search;
import java.util.List;

/**
 * Controller: Class that integrate the view and the model
 * It get the data typed in the UI ,construct a search criteria and sent it to Search.
 * And finally ,It get the result of search and  show it in UI.
 * @author Brayan Rosas
 * @version 0.1.1
 * @since 04/02/2018
 */
public class Controller {
    private Window win;
    private Search search;
    private InterfaceValidator validator;
    private SearchCriteriaBasic basicCriteria;

    /**
     * Controller: Construct method
     * Method that construct an Controller object in base to an Object Search and Window
     * ,and manage the action after to press the button Search in UI.
     */
    public Controller (Search search,Window win){
        this.search=search;
        this.win=win;
        win.getSearchButton().addActionListener(e -> fillSearchCriteria());
    }

    /**
     *Method that get the filename and path ,
     *that send those data to search ,get the file found and fill the UI table result,
     */
    private void fillSearchCriteria(){
        //Cleaning the rows in the model of table
        win.getTableResult().model.setNumRows(0);
        List<FileSearch> filesFound=null;
        validator = new InterfaceValidator();
        if(validator.isValidPath(win.getSearchInTextField()))
        {
            basicCriteria= new SearchCriteriaBasic(win.getSearchInTextField(),win.getSearchForTextField());
            filesFound=search.getResults(basicCriteria);
            if(filesFound.size()!=0)
                fillTable(filesFound);
        }
    }

    /**
     * Method that receive the file found and fill the table of result in the UI.
     * @param filesFound
     */
    private void fillTable(List<FileSearch> filesFound){

        for (FileSearch file:filesFound)
        {
            win.getTableResult().fillTableResult(new Object[]{file.getPath(),file.getName(),file.getIsDirectory(),file.getIsHidden(),file.getSize(),file.getDateModification()});
        }

    }
}

