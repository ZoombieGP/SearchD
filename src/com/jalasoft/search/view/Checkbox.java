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

    private JCheckBox caseSensitive;                //Case sensitive checkbox
    private JCheckBox fileName;                     //File Name checkbox
    private JCheckBox fileContent;                  //File Content checkbox
    private JCheckBox hiddenFiles;                  //Hidden Files checkbox
    private JCheckBox creationDate;                 //Creation Date checkbox
    private JTextField creationDateTextField;       //Creation Date text field
    private JCheckBox modificationDate;             //Modification Date checkbox
    private JTextField modificationDateTextField;   //Modification Date text field
    private JCheckBox accessDate;                   //Access Date checkbox
    private JTextField accessDateTextField;         //Access Date text field
    private JCheckBox owner;                        //Owner checkbox
    private JTextField ownerTextField;              //Owner text field
    private JCheckBox size;                         //Size checkbox
    private JTextField sizeTextField;               //Size text field
    private JPanel checkPanel1;                     //First panel
    private JPanel checkPanel2;                     //Second panel

    /**
     * Creates the components and add them to respective panels
     * also the alignment is set
     */
    public Checkbox() {
        super(new BorderLayout());
        caseSensitive = new JCheckBox("Case Sensitive");
        fileName = new JCheckBox("File Name");
        fileContent = new JCheckBox("File Content");
        hiddenFiles = new JCheckBox("Hidden Files");

        checkPanel1 = new JPanel(new GridLayout(0, 1));
        checkPanel1.add(caseSensitive);
        checkPanel1.add(fileName);
        checkPanel1.add(fileContent);
        checkPanel1.add(hiddenFiles);
        checkPanel1.setLayout(new javax.swing.BoxLayout(checkPanel1, BoxLayout.X_AXIS));
        this.add(checkPanel1, BorderLayout.PAGE_START);

        creationDate = new JCheckBox("Creation Date");
        creationDateTextField = new JTextField();
        modificationDate = new JCheckBox("Modification Date");
        modificationDateTextField = new JTextField();
        accessDate = new JCheckBox("Access Date");
        accessDateTextField = new JTextField();

        checkPanel2 = new JPanel(new GridLayout(0, 1));
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

    /**
     * Get the Creation Date checkbox
     * @return the current Creation Date checkbox object
     */
    public JCheckBox getCreationDate() {
        return creationDate;
    }

    /**
     * Get the Creation Date text field
     * @return the current Creation Date text field object
     */
    public JTextField getCreationDateTextField() {
        return creationDateTextField;
    }

    /**
     * Get the Access Date checkbox
     * @return the current Access Date checkbox object
     */
    public JCheckBox getAccessDate() {
        return accessDate;
    }

    /**
     * Get the Access Date text field
     * @return the current Access Date text field object
     */
    public JTextField getAccessDateTextField() {
        return accessDateTextField;
    }

    /**
     * Get the Modification Date checkbox
     * @return the current Modification Date checkbox object
     */
    public JCheckBox getModificationDate() {
        return modificationDate;
    }

    /**
     * Get the Modification Date text field
     * @return the current Modification Date text field object
     */
    public JTextField getModificationDateTextField() {
        return modificationDateTextField;
    }

    /**
     * Get the Case Sensitive checkbox
     * @return the current Case Sensitive checkbox object
     */
    public JCheckBox getCaseSensitive() {
        return caseSensitive;
    }

    /**
     * Get the File Content checkbox
     * @return the current File Content checkbox object
     */
    public JCheckBox getFileContent() {
        return fileContent;
    }

    /**
     * Get the File Name checkbox
     * @return the current File Name checkbox object
     */
    public JCheckBox getFileName() {
        return fileName;
    }

    /**
     * Get the Hidden Filed checkbox
     * @return the current Hidden Files checkbox object
     */
    public JCheckBox getHiddenFiles() {
        return hiddenFiles;
    }

    /**
     * Get the Owner checkbox
     * @return the current Owner checkbox object
     */
    public JCheckBox getOwner() {
        return owner;
    }

    /**
     * Get the Owner text field
     * @return the current Owner text field object
     */
    public JTextField getOwnerTextField() {
        return ownerTextField;
    }

    /**
     * Get the Size checkbox
     * @return the current Size checkbox object
     */
    public JCheckBox getCheckBoxSize() {
        return size;
    }

    /**
     * Get the Size text field
     * @return the current Size text field object
     */
    public JTextField getSizeTextField() {
        return sizeTextField;
    }
}
