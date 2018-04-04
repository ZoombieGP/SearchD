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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.Dimension;

public class Table extends JPanel {

    private String [] columnNames;
    DefaultTableModel model;


    public Table(){
        super(new GridLayout(1,0));
        columnNames = new String[]{"Path", "FileName", "Is Directory?", "Is Hidden?", "Size","Date Modified"};
        createTable();
    }

    private void createTable() {
        model= new DefaultTableModel();
        final JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);

        for (int i =0 ; i< columnNames.length; i++){
            model.addColumn(columnNames[i]);
        }

        table.setPreferredScrollableViewportSize(new Dimension(725, 400));
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        add(scrollPane);
    }

    public void fillTableResult(Object[] object){
        model.addRow(object);
    }
}
