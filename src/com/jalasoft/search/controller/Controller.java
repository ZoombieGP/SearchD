package com.jalasoft.search.controller;
import com.jalasoft.search.view.Window;
import com.jalasoft.search.model.Search;

import java.time.temporal.ValueRange;

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
        if(validator.isValidFileName(win.getFileName()))
        {
            System.out.println(win.getFileName());
            basicCriteria= new SearchCriteriaBasic(win.getFilePath(),win.getFileName());
            System.out.println(basicCriteria.getCriteria()[0]);
            //System.out.println(basicCriteria.getPath());

        }
    }
}
