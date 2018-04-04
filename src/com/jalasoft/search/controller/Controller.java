package com.jalasoft.search.controller;
import com.jalasoft.search.model.FileSearch;
import com.jalasoft.search.view.Window;
import com.jalasoft.search.model.Search;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;


public class Controller {
    private Window win;
    private Search search;
    private InterfaceValidator validator;
    private SearchCriteriaBasic basicCriteria;


    public Controller (Search search,Window win){
        this.search=search;
        this.win=win;
        win.getSearchButton().addActionListener(e -> fillSearchCriteria());
    }

    private void fillSearchCriteria(){
        validator = new InterfaceValidator();
        if(validator.isValidPath(win.getSearchInTextField()))
        {
            basicCriteria= new SearchCriteriaBasic(win.getSearchInTextField(),win.getSearchForTextField());

            List<FileSearch> filesFound;
            filesFound=search.getResults(basicCriteria);
            fillTable(filesFound);

        }
    }

    private void fillTable(List<FileSearch> filesFound){

        for (FileSearch file:filesFound)
        {
            win.getTableResult().fillTableResult(new Object[]{file.getPath(),file.getName(),file.getIsDirectory(),file.getIsHidden(),file.getSize(),file.getDateModification()});
        }

    }


}
