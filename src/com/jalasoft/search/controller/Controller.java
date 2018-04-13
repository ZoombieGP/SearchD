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
import com.jalasoft.search.common.Converter;
import com.jalasoft.search.model.Asset;
import com.jalasoft.search.model.Directory;
import com.jalasoft.search.model.FileSearch;
import com.jalasoft.search.view.Table;
import com.jalasoft.search.view.Window;
import com.jalasoft.search.model.Search;

import java.io.IOException;
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
    private SearchCriteria basicCriteria;
    private Converter converter =new Converter();

    /**
     * Controller: Construct method
     * Method that construct an Controller object in base to an Object Search and Window
     * ,and manage the action after to press the button Search in UI.
     */
    public Controller (Search search,Window win){
        this.search=search;
        this.win=win;
        win.getSearchButton().addActionListener(e -> {
            try {
                fillSearchCriteria();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        win.getAdvancedSearchButton().addActionListener(e -> {
            try {
                fillSearchCriteriaAdvanced();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    /**
     *Method that get the filename and path ,
     *that send those data to search ,get the file found and fill the UI table result,
     */
    private void fillSearchCriteria() throws IOException {
        validator = new InterfaceValidator();
        win.getTableResult().model.setRowCount(0);
        basicCriteria= new SearchCriteria(win.getSearchInTextField(),win.getSearchForTextField());
        List<Asset> filesFound;
        filesFound=search.getResults(basicCriteria);
        fillTable(filesFound,win.getTableResult());
        System.out.println(basicCriteria.getPath()+ "    " + basicCriteria.getCriteria()[0]);


    }

    /**
     * Get the UI dta ,Fill the search criteria advanced and create the object
     * @throws IOException
     */
    private void fillSearchCriteriaAdvanced()throws IOException{
        validator = new InterfaceValidator();
        win.getAdvancedTableResult().model.setRowCount(0);


        String path=win.getAdvancedSearchInTextField();
        String searchFor=win.getAdvancedSearchForTextField();
        String content=getContentOfSearchFor(searchFor,win.getCheckbox().getFileContent().isSelected());
        if(win.getCheckbox().getFileContent().isSelected())
            searchFor="";

        String extension=getExtension(searchFor);
        String modifDate=getDate(win.getCheckbox().getModificationDateTextField());
        String creationDate=getDate(win.getCheckbox().getCreationDateTextField());
        String accessDate=getDate(win.getCheckbox().getAccessDateTextField());
        String owner=getDate(win.getCheckbox().getOwnerTextField());
        long size = convertToLong(win.getCheckbox().getSizeTextField());
        int mode=0;
        boolean isHidden=win.getCheckbox().getHiddenFiles().isSelected();
        if(searchFor.contains("*."))
            searchFor="";
        basicCriteria=new SearchCriteria(path,searchFor,isHidden,content,extension,size,mode,modifDate,creationDate,accessDate,owner);
        List<Asset> filesFound;
        filesFound=search.getResults(basicCriteria);
        fillTable(filesFound,win.getAdvancedTableResult());


        System.out.println("Path : "+basicCriteria.getPath());
        System.out.println("text to search : "+basicCriteria.getCriteria()[0]);
        System.out.println("Is hidden? : "+basicCriteria.getIsHidden());
        System.out.println("Content : "+basicCriteria.getContent());
        System.out.println("Extension : "+basicCriteria.getExtension());
        System.out.println("Size in bytes : "+basicCriteria.getSize());
        System.out.println("Mode : "+basicCriteria.getMode());
        System.out.println("Date of mod : "+basicCriteria.getModificationDate());
        System.out.println("Date of cre : "+basicCriteria.getCreationDate());
        System.out.println("Date of acc : "+basicCriteria.getAccessDate());
        System.out.println("Date of owner : "+basicCriteria.getOwner());
    }

    /**
     * Convert the size in  MB  to long in bytes
     * @param sizeTextField
     * @return
     */
    private long convertToLong(String sizeTextField) {
        if(!sizeTextField.isEmpty())
        {
            int InBytes=Integer.parseInt(sizeTextField);
            InBytes=InBytes*1024*1024;
            return Long.valueOf(InBytes);
        }
        else
            return -1;

    }

    /**
     * Fill the content with the search for text if the content is selected
     * @param searchFor
     * @param isSelect
     * @return
     */
    private String getContentOfSearchFor(String searchFor,boolean isSelect) {

        if(isSelect)
        {
            return searchFor;
        }

        return null;
    }

    /**
     * get the extension of the searchFor text
     * @param searchFor
     * @return
     */
    private String getExtension(String searchFor) {

        String [] aux=searchFor.split("\\.");
            if(aux.length-1!=0)
                return aux[aux.length-1];
            return null;
    }

    private String getDate(String date) {
        if(date.isEmpty())
            return null;
         return date;

        }


    /**
     * Method that receive the file found and fill the table of result in the UI.
     * @param filesFound
     */
    private void fillTable(List<Asset> filesFound, Table table){



        for (int i= 0; i < filesFound.size(); i++){


            if(filesFound.get(i) instanceof Directory){
                table.fillTableResult(new Object[]{filesFound.get(i).getPath(),filesFound.get(i).getFileName(),filesFound.get(i).getIsDirectory(),filesFound.get(i).isHidden(),converter.formatFileSize(filesFound.get(i).getSize()),filesFound.get(i).getModificationDate()});
            }
            if (filesFound.get(i) instanceof FileSearch){
                table.fillTableResult(new Object[]{filesFound.get(i).getPath(),filesFound.get(i).getFileName(),filesFound.get(i).getIsDirectory(),filesFound.get(i).isHidden(),converter.formatFileSize(filesFound.get(i).getSize()),filesFound.get(i).getModificationDate()});
            }
        }

    }

}


