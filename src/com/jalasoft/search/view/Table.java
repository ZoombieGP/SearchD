/*
 * Table.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.jalasoft.search.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.Dimension;

public class Table extends JPanel {

    private String [] columnNames;
    public DefaultTableModel model;
    private JTable table;
    //public int row;

    /**
     * Table: Construct method
     * Method that construct a Controller object Table in base to JTable with a model
     */
    public Table(int width , int height, String [] columnNames){
        super(new GridLayout(1,0));
        //columnNames = new String[]{"Path", "File Name", "Is Directory?", "Is Hidden?", "Size","Date Modified"};
        createTable(width,height,columnNames);
    }

    /**
     * Instance the objects : JTable JScrollPane ,
     * and initialize its properties and columns of the table
     */
    private void createTable(int width , int height,String [] columnNames) {
        model= new DefaultTableModel();
         table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);

        for (int i =0 ; i< columnNames.length; i++){
            model.addColumn(columnNames[i]);
        }

        table.setPreferredScrollableViewportSize(new Dimension(width,height));
        table.setFillsViewportHeight(true);
        table.setEnabled(true);
       // row=table.getSelectedRow();
        add(scrollPane);
    }

    /**
     * Fill the model that will added to the Table , the model contain the data of the table
     * @param object
     */
    public void fillTableResult(Object[] object){

        model.addRow(object);
    }

    public String getSelectedCriteriaRowColumn(int column){
        //The column 0 is the criteria ID
        int row = table.getSelectedRow();
        String value = table.getModel().getValueAt(row, column).toString();
        return value;
    }


}
