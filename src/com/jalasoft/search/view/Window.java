/*
 * Windows.java
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class Window extends JFrame{

    private JTabbedPane tabPane;                                    //Tab Pane contains Simple and Advanced Search Tabs
    private JPanel simpleTab;                                       //Simple Search Tab
    private JPanel advancedTab;                                     //Advanced Search Tab
    private JPanel searchInPanel;                                   //Panel contains Search In Field Name, Text Field Browse button
    private JTextField searchInTextField;                           //Search In Text Field
    private JLabel searchInFieldName;                               //Search In Field Name
    private JButton browseButton;                                   //Browse Button
    private JPanel searchForPanel;                                  //Panel contains Search For Field Name, Text Field, Search button
    private JTextField searchForTextField;                          //Search For Text Field
    private JLabel searchForFieldName;                              //Search For Field Name
    private JButton searchButton;                                   //Search Button
    //adding a table object
    private Table tableResult;

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
        //add table component
        tableResult = new Table();



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

        searchForPanel.add(searchForFieldName);
        searchForPanel.add(searchForTextField);
        searchForPanel.add(searchButton);
        simpleTab.add(searchInPanel);
        simpleTab.add(searchForPanel);
        // adding a table result to simple tab
        simpleTab.add(tableResult);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(tabPane);
    }
}
