/*
 * CfgGUIPanel.java
 *
 * Created on 13 de noviembre de 2008, 12:25
 */
package org.gatATAC.poris.player;

import org.gatATAC.poris.*;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author  txinto
 */
public class CfgGUIPanel extends javax.swing.JPanel {

    private final CfgGUI gui;
    private int numPanelsAdded = 0;
    private ArrayList<CfgGUIPanel> panels;
    private final boolean showLabel;
    private final boolean showInvisible;
    
    /** Creates new form CfgGUIPanel */
    public CfgGUIPanel(CfgGUI gui, boolean showFrame, boolean showValue, boolean showLabel, boolean isGroup, boolean showInvisible) {
        this.gui = gui;
        this.showInvisible=showInvisible;
        initComponents(showFrame, showValue, isGroup);
        this.showLabel = showLabel;
        panels = new ArrayList();
        this.updateVisibilities();
    }

    private void updateVisibilities() {
        this.mode.setVisible((this.mode.getModel().getSize() > 1) || (this.gui.getCfg().getModel().isModeVisibleFlag()));
        this.mode.setEnabled(this.mode.getModel().getSize() > 1);
        this.labelMode.setVisible(this.mode.getModel().getSize() > 1);
        this.label.setVisible(this.showLabel);
    }

    public void addPanel(CfgGUIPanel panel, boolean isGroup, boolean isSelectedInGroup) {
        java.awt.GridBagConstraints gridBagConstraints;
        gridBagConstraints = new java.awt.GridBagConstraints();
        if (isGroup) {
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
        } else {
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = numPanelsAdded + 1;
        }
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0,3,0,3);

        thisPanel.add(panel, gridBagConstraints);
        thisPanel.updateUI();
        this.updateUI();
        panel.setVisible(!isGroup || isSelectedInGroup);
        panels.add(panel);
        numPanelsAdded++;
    }

    public Value getValue() {
        return this.value.getValue();
    }

    public void setValue(Value value) {
        this.value.setValue(value);
    }

    public void setLabel(String label) {
        this.label.setText(label + ":");
    }

    public void setModeChoices(ArrayList<PORIS> values) {
        this.mode.setModel(new DefaultComboBoxModel(values.toArray()));
    }

    public void setMode(PORISMode mode) {
        //System.out.println("Entro en setMode de CfgGUIPanel de "+this.gui.getCfg()+" con modo "+mode);
        if (mode != null) {
            this.mode.setSelectedItem(mode);
            if (this.gui.getCfg().isHasValue()) {
                this.value.setChoices(mode.getValues());
            }
            this.setVisible(true);
        } else {
            this.setVisible(false);
        }
        this.updateVisibilities();
    }

    public PORISMode getSelectedMode() {
        return (PORISMode) this.mode.getSelectedItem();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(boolean showFrame, boolean showValue, boolean isGroup) {
        java.awt.GridBagConstraints gridBagConstraints;

        label = new javax.swing.JLabel();
        thisPanel = new javax.swing.JPanel();
        labelMode = new javax.swing.JLabel();
        mode = new javax.swing.JComboBox();
        value = new ValueGUICell(this.gui,this.showInvisible);

        if (showFrame) {
            setBorder(javax.swing.BorderFactory.createTitledBorder(this.gui.getCfg().getModel().toString())); // NOI18N
        }
        setName("Form"); // NOI18N
        setLayout(new java.awt.GridBagLayout());
        thisPanel.setName("Form"); // NOI18N
        thisPanel.setLayout(new java.awt.GridBagLayout());

        if (!showFrame &&
                ((this.gui.getCfg().getDestinations().size() < 1)) || isGroup) {
            label.setText("label"); // NOI18N
            label.setName("label"); // NOI18N
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            //gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            thisPanel.add(label, gridBagConstraints);
        }
        if (showValue) {
            value.setName("value"); // NOI18N
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 5;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
            gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            thisPanel.add(value, gridBagConstraints);
        }

        labelMode.setText("Mode:"); // NOI18N
        labelMode.setName("labelMode"); // NOI18N
        if (showFrame && showLabel && ((this.gui.getCfg().getDestinations().size() > 1))) {
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
            gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
            thisPanel.add(labelMode, gridBagConstraints);
        }
        mode.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        mode.setName("mode"); // NOI18N
        mode.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        if (!showFrame) {
            gridBagConstraints.gridx = 1;
        } else {
            gridBagConstraints.gridx = 1;
        }
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        //gridBagConstraints.gridwidth=java.awt.GridBagConstraints.REMAINDER;

        thisPanel.add(mode, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        //gridBagConstraints.gridwidth=java.awt.GridBagConstraints.REMAINDER;
        add(thisPanel, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeActionPerformed
        this.gui.handleEventMode();
    }//GEN-LAST:event_modeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel thisPanel;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelMode;
    private javax.swing.JComboBox mode;
    private ValueGUICell value;
    // End of variables declaration//GEN-END:variables
}
