/*
 * Window.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.jalasoft.search.view;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.File;

public class Window extends JFrame{

    private JTabbedPane tabPane;                       //Tab Pane contains Simple and Advanced Search Tabs
    private JPanel simpleTab;                          //Simple Search Tab
    private JPanel advancedTab;                        //Advanced Search Tab
    private JPanel savedSearchCriteriaTab;             //Saved Search Criteria Tab
    private JPanel searchInPanel;                      //Panel contains Search In Field Name, Text Field Browse button
    private JTextField searchInTextField;              //Search In Text Field
    private JLabel searchInFieldName;                  //Search In Field Name
    private JButton browseButton;                      //Browse Button
    private JPanel searchForPanel;                     //Panel contains Search For Field Name, Text Field, Search button
    private JTextField searchForTextField;             //Search For Text Field
    private JLabel searchForFieldName;                 //Search For Field Name
    private JButton searchButton;                      //Search Button
    private Table tableResult;                         //Results Table
    private JLabel saveLabel;                          //Save Label
    private JTextField saveTextField;                  //Save Text Field
    private JButton saveButton;                        //Save Button
    private JPanel searchInPanel2;                     //Panel contains Advanced Search In Field Name, Text Field Browse button
    private JTextField searchInTextField2;             //Advanced Search In Text Field
    private JLabel searchInFieldName2;                 //Advanced Search In Field Name
    private JButton browseButton2;                     //Advanced Browse Button
    private JPanel searchForPanel2;                    //Panel contains Advanced Search For Field Name, Text Field, Search button
    private JTextField searchForTextField2;            //Advanced Search For Text Field
    private JLabel searchForFieldName2;                //Advanced Search For Field Name
    private JButton searchButton2;                     //Advanced Search Button
    private Table tableResult2;                        //Advanced Results Table
    private JLabel saveLabel2;                         //Advanced Save Label
    private JTextField saveTextField2;                 //Advanced Save Text Field
    private JButton saveButton2;                       //Advanced Save Button
    private Checkbox checkbox;                         //Advanced Search Checkboxes
    private Table criteriaTable;                       //Criteria Table
    private JPanel loadButtonPanel;                    //Panel contains Load Button
    private JButton loadButton;                        //Load Button

    /**
     * Builder method:
     * Start the window configurations and components
     */
    public Window(){
        super ();
        windowConfigure();
        startComponents();
    }

    /**
     * Method to start the window configurations
     */
    private void windowConfigure(){
        this.setTitle("File Finder Group D");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Method to start the window components
     */
    private void startComponents(){

        tabPane = new JTabbedPane();
        simpleTab = new JPanel();
        advancedTab = new JPanel();
        savedSearchCriteriaTab = new JPanel();
        searchInPanel = new JPanel();
        searchInFieldName = new JLabel();
        searchInTextField = new JTextField(40);
        browseButton = new JButton();
        String[] columnNames = new String[]{"Path", "File Name", "Is Directory?", "Is Hidden?", "Size","Date Modified"};
        tableResult = new Table(725,380,columnNames);
        searchForPanel = new JPanel();
        searchForFieldName = new JLabel();
        searchForTextField = new JTextField(40);
        searchButton = new JButton();
        saveLabel = new JLabel();
        saveTextField = new JTextField(40);
        saveButton = new JButton();

        searchInFieldName.setText("Search In:");
        browseButton.setText("Browse...");
        searchForFieldName.setText("Search For:");
        searchButton.setText("Search");
        saveLabel.setText("Save Search Criteria: ");
        saveButton.setText("Save");

        tabPane.add("Simple Search",simpleTab);
        tabPane.add("Advanced Search",advancedTab);
        tabPane.add("Saved Search Criteria",savedSearchCriteriaTab);
        searchInPanel.add(searchInFieldName);
        searchInPanel.add(searchInTextField);
        searchInPanel.add(browseButton);
        browseButton.addActionListener(e -> createFileChooser(searchInTextField));
        searchForPanel.add(searchForFieldName);
        searchForPanel.add(searchForTextField);
        searchForPanel.add(searchButton);
        simpleTab.add(searchInPanel);
        simpleTab.add(searchForPanel);
        simpleTab.add(tableResult);
        simpleTab.add(saveLabel);
        simpleTab.add(saveTextField);
        simpleTab.add(saveButton);

        searchInPanel2 = new JPanel();
        searchInFieldName2 = new JLabel();
        searchInTextField2 = new JTextField(40);
        browseButton2 = new JButton();
        tableResult2 = new Table(725,325,columnNames);
        searchForPanel2 = new JPanel();
        searchForFieldName2 = new JLabel();
        searchForTextField2 = new JTextField(40);
        searchButton2 = new JButton();
        checkbox = new Checkbox();
        saveLabel2 = new JLabel();
        saveTextField2 = new JTextField(40);
        saveButton2 = new JButton();

        searchInFieldName2.setText("Search In:");
        browseButton2.setText("Browse...");
        searchForFieldName2.setText("Search For:");
        searchButton2.setText("Search");
        saveLabel2.setText("Save Search Criteria: ");
        saveButton2.setText("Save");

        searchInPanel2.add(searchInFieldName2);
        searchInPanel2.add(searchInTextField2);
        searchInPanel2.add(browseButton2);
        browseButton2.addActionListener(e -> createFileChooser(searchInTextField2));
        searchForPanel2.add(searchForFieldName2);
        searchForPanel2.add(searchForTextField2);
        searchForPanel2.add(searchButton2);
        advancedTab.add(searchInPanel2);
        advancedTab.add(searchForPanel2);
        advancedTab.add(checkbox);
        advancedTab.add(tableResult2);
        advancedTab.add(saveLabel2);
        advancedTab.add(saveTextField2);
        advancedTab.add(saveButton2);

        String[] columnNames2 = new String[]{"ID","Name","Type"};
        criteriaTable = new Table(725,460,columnNames2);
        loadButtonPanel = new JPanel();
        loadButton = new JButton("Load");
        savedSearchCriteriaTab.add(criteriaTable, BorderLayout.NORTH);
        savedSearchCriteriaTab.add(loadButtonPanel,BorderLayout.SOUTH);
        loadButtonPanel.add(loadButton);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(tabPane);
    }

    /**
     * Method to create the File Chooser, set as directories only
     * and to fill the Search In Text Field with the selected path
     * @param field
     */
    private void createFileChooser(JTextField field){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedPath = fileChooser.getSelectedFile();
            field.setText(selectedPath.getPath());
        }
    }

    /**
     * Get the Search button
     * @return the current Search button object
     */
    public JButton getSearchButton () {
        return this.searchButton;
    }

    /**
     * Get the Search In Text Field
     * @return the Search In Text in String format
     */
    public String getSearchInTextField(){
        return this.searchInTextField.getText();
    }

    /**
     * Get the Search For Text Field
     * @return the Search For Text in String format
     */
    public String getSearchForTextField (){
        return this.searchForTextField.getText();
    }

    /**
     * Get the Results Table
     * @return the current Results Table object
     */
    public Table getTableResult (){
        return this.tableResult;
    }

    /**
     * Get the Advanced Search button
     * @return the current Advanced Search button object
     */
    public JButton getAdvancedSearchButton () {
        return this.searchButton2;
    }

    /**
     * Get the Advanced Search In Text Field
     * @return the Advanced Search In Text in String format
     */
    public String getAdvancedSearchInTextField(){
        return this.searchInTextField2.getText();
    }

    /**
     * Get the Advanced Search For Text Field
     * @return the Advanced Search For Text in String format
     */
    public String getAdvancedSearchForTextField (){
        return this.searchForTextField2.getText();
    }

    /**
     * Get the Advanced Results Table
     * @return the current Advanced Results Table object
     */
    public Table getAdvancedTableResult (){
        return this.tableResult2;
    }

    /**
     * Get the Checkbox
     * @return the current Checkbox object
     */
    public Checkbox getCheckbox (){
        return this.checkbox;
    }

    /**
     * Get the Criteria Table
     * @return the current Criteria Table object
     */
    public Table getCriteriaTable (){ return this.criteriaTable; }

    /**
     * Get the Load Button
     * @return the current Load Button object
     */
    public JButton getLoadButton (){
        return this.loadButton;
    }

    /**
     * Set the Search In Text Field
     */
    public void setSearchInTextField( String text) {
       // this.searchInTextField = searchInTextField;
        this.searchInTextField.setText(text);
    }

    /**
     * Set the Search For Text Field
     * @param
     */
    public void setSearchForTextField(String text) {
              this.searchForTextField.setText(text);
    }

    /**
     * Set the Advanced Search In Text Field
     */
    public void setSearchInTextField2( String text) {
        this.searchInTextField2.setText(text);
    }

    /**
     * Set the Advanced Search For Text Field
     */
    public void setSearchForTextField2( String text) {
        this.searchForTextField2.setText(text);
    }

    /**
     * Get the Save Button
     * @return the current Save Button object
     */
    public JButton getSaveButton() {
        return saveButton;
    }

    /**
     * Get the Save Text Field
     * @return the current Save Text Field in String format
     */
    public String getSaveTextField() {
        return this.saveTextField.getText();
    }

    /**
     * Get the Advanced Save Button
     * @return the current Advanced Save Button object
     */
    public JButton getSaveButton2() {
        return saveButton2;
    }

    /**
     * Get the Advanced Save Text Field
     * @return the current Advanced Save Text Field in String format
     */
    public String getSaveTextField2() {
        return this.saveTextField2.getText();
    }
}
