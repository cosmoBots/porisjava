/*
 * CfgFrame.java
 *
 * Created on 20-mar-2009, 17:42:29
 */

package org.gatATAC.poris.player;

import java.awt.Component;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.gatATAC.poris.Cfg;
import org.gatATAC.poris.PORISLib;
import org.gatATAC.poris.PORISXML;
import org.gatATAC.poris.PORISNode;
import org.gatATAC.poris.player.app.AboutBox;
import org.gatATAC.poris.player.app.PorisGUIAppDelegate;

/**
 *
 * @author osiris
 */
public class CfgFrame extends javax.swing.JFrame {

    private CfgXMLFrame xmlSystemFrame = new CfgXMLFrame();
    private CfgXMLFrame xmlConfigFrame = new CfgXMLFrame();
    private final PorisGUIAppDelegate delegate;
    private final boolean showXMLButtons;
    private final boolean showInvisible;
    private final boolean showAbout;

    /** Creates new form CfgFrame */
    public CfgFrame() {
        this.showXMLButtons=false;
        this.showInvisible=false;
        this.showAbout=true;
        initComponents();
        delegate=null;
    }

    public CfgFrame(PorisGUIAppDelegate delegate, boolean showXMLButtons, boolean showInvisible, boolean showAbout) {
        this.showXMLButtons=showXMLButtons;
        this.delegate = delegate;
        this.showInvisible=showInvisible;
        this.showAbout=showAbout;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        filePanel = new javax.swing.JPanel();
        viewModelXMLButton = new javax.swing.JButton();
        viewCfgXMLButton = new javax.swing.JButton();
        changePanel = new javax.swing.JPanel();
        commitButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        mainScroll = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        resultPanel = new javax.swing.JPanel();

        setTitle("Instrument Configuration");
        setName("Form"); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        filePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("File Management"));
        filePanel.setName("filePanel"); // NOI18N

        viewModelXMLButton.setText("View Model XML");
        viewModelXMLButton.setName("viewModelXMLButton"); // NOI18N
        viewModelXMLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewModelXMLButtonActionPerformed(evt);
            }
        });

        viewCfgXMLButton.setText("View Cfg XML");
        viewCfgXMLButton.setName("viewCfgXMLButton"); // NOI18N
        viewCfgXMLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCfgXMLButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout filePanelLayout = new org.jdesktop.layout.GroupLayout(filePanel);
        filePanel.setLayout(filePanelLayout);
        filePanelLayout.setHorizontalGroup(
            filePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(filePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(viewModelXMLButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(viewCfgXMLButton)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        filePanelLayout.setVerticalGroup(
            filePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(filePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(filePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(viewModelXMLButton)
                    .add(viewCfgXMLButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(filePanel, gridBagConstraints);
        filePanel.setVisible(this.showXMLButtons);

        changePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Change Management"));
        changePanel.setName("changePanel"); // NOI18N

        commitButton.setText("Commit Changes");
        commitButton.setName("commitButton"); // NOI18N
        commitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitButtonActionPerformed(evt);
            }
        });
        commitButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                commitButtonFocusGained(evt);
            }
        });

        discardButton.setText("Discard Changes");
        discardButton.setName("discardButton"); // NOI18N
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.setName("aboutButton"); // NOI18N
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });
        aboutButton.setVisible(this.showAbout);

        org.jdesktop.layout.GroupLayout changePanelLayout = new org.jdesktop.layout.GroupLayout(changePanel);
        changePanel.setLayout(changePanelLayout);
        changePanelLayout.setHorizontalGroup(
            changePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(changePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(commitButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(discardButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 207, Short.MAX_VALUE)
                .add(aboutButton)
                .addContainerGap())
        );
        changePanelLayout.setVerticalGroup(
            changePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(changePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(changePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(commitButton)
                    .add(discardButton)
                    .add(aboutButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(changePanel, gridBagConstraints);

        mainScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setName("mainScroll"); // NOI18N

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Instrument Configuration"));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.GridBagLayout());

        resultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Titulo"));
        resultPanel.setAutoscrolls(true);
        resultPanel.setName("resultPanel"); // NOI18N

        org.jdesktop.layout.GroupLayout resultPanelLayout = new org.jdesktop.layout.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 506, Short.MAX_VALUE)
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 682, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(resultPanel, gridBagConstraints);

        mainScroll.setViewportView(mainPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 10.0;
        getContentPane().add(mainScroll, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewModelXMLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewModelXMLButtonActionPerformed
        if (xmlSystemFrame!=null) xmlSystemFrame.setVisible(true);
    }//GEN-LAST:event_viewModelXMLButtonActionPerformed

    private void viewCfgXMLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCfgXMLButtonActionPerformed
        if (xmlConfigFrame!=null) xmlConfigFrame.setVisible(true);
    }//GEN-LAST:event_viewCfgXMLButtonActionPerformed

    private void commitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitButtonActionPerformed
        this.delegate.commitChanges();
    }//GEN-LAST:event_commitButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        this.delegate.discardChanges();
    }//GEN-LAST:event_discardButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
            AboutBox aboutBox = new AboutBox(this);
            aboutBox.setLocationRelativeTo(this);
            aboutBox.setVisible(true);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void commitButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_commitButtonFocusGained
        Component opComp=evt.getOppositeComponent();
        if (opComp!=null){
            if (opComp.getClass().equals(JTextField.class)){
                // We are stealing the control of a JTextField
                JTextField textField = (JTextField)opComp;
                int cota=textField.getFocusListeners().length;
                for (int i = 0; i<cota;i++){
                    FocusListener listener=textField.getFocusListeners()[i];
                    listener.focusLost(evt);
                }
            }
        }
    }//GEN-LAST:event_commitButtonFocusGained

    public String getApplicationDetails(){
        return this.delegate.getApplicationDetails();
    }
    
    private JTabbedPane loadModelIntoResult(PORISLib modelToLoad, String title, JPanel mainPanel, JTabbedPane resultPanel, int position) {
        // Represent the modelToLoad in the result panel
        PORISXML modelXML = new PORISXML(modelToLoad);
        if (resultPanel != null) {
            mainPanel.remove(resultPanel);
        }
        resultPanel = modelXML.getMainPanel();

        java.awt.GridBagConstraints gridBagConstraints;
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.gridx = position;
        gridBagConstraints.gridy = 0;
        resultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(title)); // NOI18N
        mainPanel.add(resultPanel, gridBagConstraints);
        mainPanel.updateUI();
        return resultPanel;
    }

    public void loadSystemIntoResult(PORISLib systemLib, PORISNode system){
                loadModelIntoResult(systemLib, system.toString(), xmlSystemFrame.mainPanel, xmlSystemFrame.resultPanel, 1);
                xmlSystemFrame.mainPanel.setMinimumSize(new java.awt.Dimension(200, 200));
                xmlSystemFrame.setMinimumSize(new java.awt.Dimension(400, 400));
                xmlSystemFrame.setTitle("XML Model de " + system);
    }
    public void loadConfigIntoResult(PORISLib configLib, Cfg config){
                loadModelIntoResult(configLib, "Configuracion de " + config, xmlConfigFrame.mainPanel, xmlConfigFrame.resultPanel, 1);
                xmlConfigFrame.mainPanel.setMinimumSize(new java.awt.Dimension(200, 200));
                xmlConfigFrame.setMinimumSize(new java.awt.Dimension(400, 400));
                xmlConfigFrame.setTitle("XML de " + config + " Cfg");
    }

    @Override
    public void hide() {
        if (this.delegate!=null){
            this.delegate.frameWillHide();
        }
        super.hide();
    }

    public CfgFrame(PorisGUIAppDelegate delegate, boolean showXMLButtons, JPanel changePanel, JButton commitButton, JButton discardButton, JPanel filePanel, JPanel mainPanel, JPanel resultPanel, JButton viewCfgXMLButton, JButton viewModelXMLButton, boolean showInvisible, boolean showAbout) {
        this.delegate = delegate;
        this.showInvisible = showInvisible;
        this.showAbout=showAbout;
        this.showXMLButtons = showXMLButtons;
        this.changePanel = changePanel;
        this.commitButton = commitButton;
        this.discardButton = discardButton;
        this.filePanel = filePanel;
        this.mainPanel = mainPanel;
        this.resultPanel = resultPanel;
        this.viewCfgXMLButton = viewCfgXMLButton;
        this.viewModelXMLButton = viewModelXMLButton;
    }


    public void loadCfgIntoGUI(Cfg cfgToLoad, String title, JPanel mainPanel, JPanel resultPanel) {
        CfgGUI paramCfgGUI = new CfgGUI(cfgToLoad, true, true, this.showInvisible);
        if (resultPanel != null) {
            mainPanel.remove(resultPanel);
        }
        resultPanel = paramCfgGUI.getPanel();

        java.awt.GridBagConstraints gridBagConstraints;
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        // Represent the modelToLoad in the result panel
        if (!title.equals("-")) {
            resultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(title)); // NOI18N
            mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(title + " Panel")); // NOI18N
        } else {
            mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(cfgToLoad.getModel().getName() + " Panel")); // NOI18N
        }
        mainPanel.add(resultPanel, gridBagConstraints);
        mainPanel.updateUI();
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CfgFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aboutButton;
    public javax.swing.JPanel changePanel;
    private javax.swing.JButton commitButton;
    public javax.swing.JButton discardButton;
    private javax.swing.JPanel filePanel;
    public javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScroll;
    public javax.swing.JPanel resultPanel;
    private javax.swing.JButton viewCfgXMLButton;
    private javax.swing.JButton viewModelXMLButton;
    // End of variables declaration//GEN-END:variables

}
