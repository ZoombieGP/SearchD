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

    private JTabbedPane tabPane;                      //Tab Pane contains Simple and Advanced Search Tabs
    private JPanel simpleTab;                         //Simple Search Tab
    private JPanel advancedTab;                       //Advanced Search Tab
    private JPanel searchInPanel;                     //Panel contains Search In Field Name, Text Field Browse button
    private JTextField searchInTextField;             //Search In Text Field
    private JLabel searchInFieldName;                 //Search In Field Name
    private JButton browseButton;                     //Browse Button
    private JPanel searchForPanel;                    //Panel contains Search For Field Name, Text Field, Search button
    private JTextField searchForTextField;            //Search For Text Field
    private JLabel searchForFieldName;                //Search For Field Name
    private JButton searchButton;                     //Search Button
    private Table tableResult;                        //Results Table

    private JPanel searchInPanel2;                     //Panel contains Search In Field Name, Text Field Browse button
    private JTextField searchInTextField2;             //Search In Text Field
    private JLabel searchInFieldName2;                 //Search In Field Name
    private JButton browseButton2;                     //Browse Button
    private JPanel searchForPanel2;                    //Panel contains Search For Field Name, Text Field, Search button
    private JTextField searchForTextField2;            //Search For Text Field
    private JLabel searchForFieldName2;                //Search For Field Name
    private JButton searchButton2;                     //Search Button
    private Table tableResult2;                        //Results Table

    private Checkbox checkbox;                         //Advanced Search Checkboxes

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

        searchInPanel = new JPanel();
        searchInFieldName = new JLabel();
        searchInTextField = new JTextField(40);
        browseButton = new JButton();
        tableResult = new Table(725,400);

        searchForPanel = new JPanel();
        searchForFieldName = new JLabel();
        searchForTextField = new JTextField(40);
        searchButton = new JButton();

        searchInFieldName.setText("Search In:");
        browseButton.setText("Browse...");
        searchForFieldName.setText("Search For:");
        searchButton.setText("Search");

        tabPane.add("Simple Search",simpleTab);
        tabPane.add("Advanced Search",advancedTab);
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

        searchInPanel2 = new JPanel();
        searchInFieldName2 = new JLabel();
        searchInTextField2 = new JTextField(40);
        browseButton2 = new JButton();
        tableResult2 = new Table(725,350);

        searchForPanel2 = new JPanel();
        searchForFieldName2 = new JLabel();
        searchForTextField2 = new JTextField(40);
        searchButton2 = new JButton();

        checkbox = new Checkbox();

        searchInFieldName2.setText("Search In:");
        browseButton2.setText("Browse...");
        searchForFieldName2.setText("Search For:");
        searchButton2.setText("Search");

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

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(tabPane);
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
     * Get the Checkbox
     * @return the current Checkbox object
     */
    public Checkbox getCheckbox (){
        return this.checkbox;
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
}
