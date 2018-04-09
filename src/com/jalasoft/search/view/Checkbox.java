/*
 * Checkbox.java
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
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Checkbox extends JPanel {

    private JCheckBox caseSensitive;
    private JCheckBox fileName;
    private JCheckBox fileContent;
    private JCheckBox hiddenFiles;
    private JCheckBox creationDate;
    //private JTextField creationDateTextField;
    private JFormattedTextField creationDateTextField;
    private JCheckBox modificationDate;
    //private JTextField modificationDateTextField;
    private JFormattedTextField modificationDateTextField;
    private JCheckBox accessDate;
    //private JTextField accessDateTextField;
    private JFormattedTextField accessDateTextField;
    private JCheckBox owner;
    private JTextField ownerTextField;
    private JCheckBox size;
    private JTextField sizeTextField;

    public Checkbox() {
        super(new BorderLayout());
        caseSensitive = new JCheckBox("Case Sensitive");
        fileName = new JCheckBox("File Name");
        fileContent = new JCheckBox("File Content");
        hiddenFiles = new JCheckBox("Hidden Files");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-d");

        JPanel checkPanel1 = new JPanel(new GridLayout(0, 1));
        checkPanel1.add(caseSensitive);
        checkPanel1.add(fileName);
        checkPanel1.add(fileContent);
        checkPanel1.add(hiddenFiles);
        checkPanel1.setLayout(new javax.swing.BoxLayout(checkPanel1, BoxLayout.X_AXIS));
        this.add(checkPanel1, BorderLayout.PAGE_START);

        creationDate = new JCheckBox("Creation Date");
        creationDateTextField = new JFormattedTextField();
        modificationDate = new JCheckBox("Modification Date");
        modificationDateTextField = new JFormattedTextField();
        accessDate = new JCheckBox("Access Date");
        accessDateTextField = new JFormattedTextField();

        JPanel checkPanel2 = new JPanel(new GridLayout(0, 1));
        checkPanel2.add(creationDate);
        checkPanel2.add(creationDateTextField);
        checkPanel2.add(modificationDate);
        checkPanel2.add(modificationDateTextField);
        checkPanel2.add(accessDate);
        checkPanel2.add(accessDateTextField);
        checkPanel2.setLayout(new javax.swing.BoxLayout(checkPanel2, BoxLayout.X_AXIS));
        this.add(checkPanel2, BorderLayout.CENTER);

        owner = new JCheckBox("Owner");
        ownerTextField = new JTextField(5);
        size = new JCheckBox("Size (MB)");
        sizeTextField = new JTextField(5);

        checkPanel1.add(owner);
        checkPanel1.add(ownerTextField);
        checkPanel1.add(size);
        checkPanel1.add(sizeTextField);
    }
}
