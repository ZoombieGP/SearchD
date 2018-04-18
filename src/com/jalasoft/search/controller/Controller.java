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
import com.jalasoft.search.common.SaveCriteria;
import com.jalasoft.search.model.Asset;
import com.jalasoft.search.model.Directory;
import com.jalasoft.search.model.FileSearch;
import com.jalasoft.search.view.Table;
import com.jalasoft.search.view.Window;
import com.jalasoft.search.model.Search;

import java.io.IOException;
import java.sql.SQLException;
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
        win.getSaveButton().addActionListener(e -> {
            try {
                saveCriteria(win.getSearchInTextField(),win.getSearchForTextField());

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        win.getLoadButton().addActionListener(e -> {
            try {
                try {
                    loadCriteria();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                //saveCriteria(win.getSearchInTextField(),win.getSearchForTextField());

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
        String path=win.getSearchInTextField();
        String searchFor=win.getSearchForTextField();
        String extension = getExtension(searchFor);
        if(searchFor.contains("*."))
            searchFor="";
        basicCriteria=new SearchCriteria(path,searchFor,extension);

        List<Asset> filesFound;
        filesFound=search.getResults(basicCriteria);
        fillTable(filesFound,win.getTableResult());
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
        boolean isDirectory =win.getCheckbox().getDirectoriesOnly().isSelected();
        int modeSize= win.getCheckbox().getSizeComboBox().getSelectedIndex();
        int modeMdate=win.getCheckbox().getModificationDateComboBox().getSelectedIndex();
        int modeCdate=win.getCheckbox().getCreationDateComboBox().getSelectedIndex();
        int modeAdate=win.getCheckbox().getAccessDateComboBox().getSelectedIndex();
        /**
        System.out.println("Mode creation :"+modeCdate);
        System.out.println("Mode modification :"+modeMdate);
        System.out.println("Mode acess :"+modeAdate);
         */
        basicCriteria=new SearchCriteria(path,searchFor,isHidden,content,extension,size,modeSize,modifDate,creationDate,accessDate,owner,isDirectory,modeMdate,modeCdate,modeAdate);

        System.out.println(basicCriteria.getPath());
        System.out.println(basicCriteria.getCriteria()[0]);
        System.out.println(basicCriteria.getIsHidden());
        System.out.println(basicCriteria.getContent());
        System.out.println(basicCriteria.getExtension());
        System.out.println(basicCriteria.getSize());
        System.out.println(basicCriteria.getModeSize());
        System.out.println(basicCriteria.getModificationDate());
        System.out.println(basicCriteria.getCreationDate());
        System.out.println(basicCriteria.getAccessDate());
        System.out.println(basicCriteria.getOwner());
        System.out.println(basicCriteria.getIsDirectory());
        System.out.println(basicCriteria.getModeCdate());
        System.out.println(basicCriteria.getModeMdate());
        System.out.println(basicCriteria.getModeAdate());

        //List<Asset> filesFound;
        //filesFound=search.getResults(basicCriteria);
        //fillTable(filesFound,win.getAdvancedTableResult());
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

    private void saveCriteria(String path , String searchFor) throws IOException{
        String extension=getExtension(searchFor);
        SearchCriteria searchCriteria= new SearchCriteria(path,searchFor,extension);
        SaveCriteria saveCriteria=new SaveCriteria();
        saveCriteria.saveCriteria(searchCriteria);
        try {
            saveCriteria.getAllData().forEach( (k,v) -> System.out.println("Key: " + k + ": Value: " + v.getPath()));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void loadCriteria() throws IOException, SQLException {


        SaveCriteria saveCriteria=new SaveCriteria();
        saveCriteria.getAllData().forEach( (k,v) -> fillTableLoad(v,k));

        win.getCriteriaTable().fillTableResult(new Object[]{saveCriteria.getAllData().get(0).getPath(), saveCriteria.getAllData().get(0).getOwner()});
        //saveCriteria.getAllData().forEach( (k,v) -> );
    }

    private void fillTableLoad(SearchCriteria searchCriteria, int key){
        win.getCriteriaTable().fillTableResult(new Object[]{key,searchCriteria.getOwner(),searchCriteria.getSize()});


    }

}


