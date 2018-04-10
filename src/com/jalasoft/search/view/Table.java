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
    DefaultTableModel model;

    /**
     * Table: Construct method
     * Method that construct a Controller object Table in base to JTable with a model
     */
    public Table(int width , int height){
        super(new GridLayout(1,0));
        columnNames = new String[]{"Path", "FileName", "Is Directory?", "Is Hidden?", "Size","Date Modified"};
        createTable(width,height);
    }

    /**
     * Instance the objects : JTable JScrollPane ,
     * and initialize its properties and columns of the table
     */
    private void createTable(int width , int height) {
        model= new DefaultTableModel();
        final JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);

        for (int i =0 ; i< columnNames.length; i++){
            model.addColumn(columnNames[i]);
        }

        table.setPreferredScrollableViewportSize(new Dimension(width,height));
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        add(scrollPane);
    }

    /**
     * Fill the model that will added to the Table , the model contain the data of the table
     * @param object
     */
    public void fillTableResult(Object[] object){
        model.addRow(object);
    }
}
