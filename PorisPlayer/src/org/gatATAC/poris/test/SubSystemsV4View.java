/*
 * SubSystemsV4View.java
 */
package org.gatATAC.poris.test;

import org.gatATAC.poris.Cfg;
import org.gatATAC.poris.player.CfgGUI;
import org.gatATAC.poris.player.CfgFrame;
import org.gatATAC.poris.player.CfgXMLFrame;
import org.gatATAC.poris.PORIS;
import org.gatATAC.poris.PORISLib;
import org.gatATAC.poris.PORISXML;
import org.gatATAC.poris.PORISNode;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

/**
 * The application's main frame.
 */
public class SubSystemsV4View extends FrameView {

    CfgXMLFrame cfgXMLFrame = new CfgXMLFrame();
    CfgXMLFrame cfgXMLCfgFrame = new CfgXMLFrame();
    CfgFrame cfgFrame = new CfgFrame();
    private PORISLib sLib = new PORISLib("systems");
    private PORISLib cLib = new PORISLib("configs");
    private PORIS s;
    private PORIS c;

    public SubSystemsV4View(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = SubSystemsV4App.getApplication().getMainFrame();
            // aboutBox = new SubSystemsV4AboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        SubSystemsV4App.getApplication().show(aboutBox);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        openCfgFrame = new javax.swing.JButton();
        injMdl = new javax.swing.JButton();
        xtMdl = new javax.swing.JButton();
        injCfg = new javax.swing.JButton();
        xtCfg = new javax.swing.JButton();
        genCode = new javax.swing.JButton();
        xmlPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        xmlText = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.GridBagLayout());

        buttonPanel.setName("buttonPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application
                .getInstance(org.gatATAC.poris.test.SubSystemsV4App.class).getContext()
                .getResourceMap(SubSystemsV4View.class);
        openCfgFrame.setText(resourceMap.getString("openCfgFrame.text")); // NOI18N
        openCfgFrame.setName("openCfgFrame"); // NOI18N
        openCfgFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCfgFrameActionPerformed(evt);
            }
        });

        injMdl.setText(resourceMap.getString("injMdl.text")); // NOI18N
        injMdl.setName("injMdl"); // NOI18N
        injMdl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                injMdlActionPerformed(evt);
            }
        });

        xtMdl.setText(resourceMap.getString("xtMdl.text")); // NOI18N
        xtMdl.setName("xtMdl"); // NOI18N
        xtMdl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xtMdlActionPerformed(evt);
            }
        });

        injCfg.setText(resourceMap.getString("injCfg.text")); // NOI18N
        injCfg.setName("injCfg"); // NOI18N
        injCfg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                injCfgActionPerformed(evt);
            }
        });

        xtCfg.setText(resourceMap.getString("xtCfg.text")); // NOI18N
        xtCfg.setName("xtCfg"); // NOI18N
        xtCfg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xtCfgActionPerformed(evt);
            }
        });

        genCode.setText(resourceMap.getString("genCode.text")); // NOI18N
        genCode.setName("genCode"); // NOI18N
        genCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genCodeActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout buttonPanelLayout = new org.jdesktop.layout.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(0, 279, Short.MAX_VALUE)
                        .add(buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(buttonPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .add(buttonPanelLayout
                                                .createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, openCfgFrame,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, xtCfg,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, injCfg,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, xtMdl,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, injMdl,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, genCode))
                                        .addContainerGap(76, Short.MAX_VALUE))));
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(0, 212, Short.MAX_VALUE)
                        .add(buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(buttonPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .add(genCode)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(openCfgFrame)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(injMdl)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(xtMdl)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(injCfg)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(xtCfg)
                                        .addContainerGap(13, Short.MAX_VALUE))));

        mainPanel.add(buttonPanel, new java.awt.GridBagConstraints());

        xmlPanel.setName("xmlPanel"); // NOI18N
        xmlPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        xmlText.setColumns(20);
        xmlText.setRows(5);
        xmlText.setName("xmlText"); // NOI18N
        jScrollPane1.setViewportView(xmlText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        xmlPanel.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(xmlPanel, gridBagConstraints);

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application
                .getInstance(org.gatATAC.poris.test.SubSystemsV4App.class).getContext()
                .getActionMap(SubSystemsV4View.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        org.jdesktop.layout.GroupLayout statusPanelLayout = new org.jdesktop.layout.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
                statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(statusPanelSeparator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
                        .add(statusPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(statusMessageLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 749, Short.MAX_VALUE)
                                .add(progressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(statusAnimationLabel)
                                .addContainerGap()));
        statusPanelLayout.setVerticalGroup(
                statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(statusPanelLayout.createSequentialGroup()
                                .add(statusPanelSeparator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 2,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(statusMessageLabel)
                                        .add(statusAnimationLabel)
                                        .add(progressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(32, 32, 32)));

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private JTabbedPane loadModelIntoResult(PORISLib modelToLoad, String title, JPanel mainPanel,
            JTabbedPane resultPanel, int position) {
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

    private void loadCfgIntoGUI(Cfg cfgToLoad, String title, JPanel mainPanel, JPanel resultPanel) {
        CfgGUI paramCfgGUI = new CfgGUI(cfgToLoad, true, true, true);
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
        resultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(title)); // NOI18N
        mainPanel.add(resultPanel, gridBagConstraints);
        mainPanel.updateUI();
    }

    private void openCfgFrameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_openCfgFrameActionPerformed
        cfgFrame.setVisible(true);
    }// GEN-LAST:event_openCfgFrameActionPerformed

    private void genCodeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genCodeActionPerformed
        sLib.clear();
        cLib.clear();
        s = GenCode.load();
        ArrayList aux = new ArrayList();
        if (s.subTree(aux)) {
            sLib.addPORISItems(aux);
            // XML output
            this.loadModelIntoResult(sLib, "Modelo de " + s, cfgXMLFrame.mainPanel, cfgXMLFrame.resultPanel, 1);
            c = new Cfg((PORISNode) s);
            aux.clear();
            if (c.subTree(aux)) {
                cLib.addPORISItems(aux);
                this.loadModelIntoResult(cLib, "Configuracion de " + c, cfgXMLCfgFrame.mainPanel,
                        cfgXMLCfgFrame.resultPanel, 1);
                loadCfgIntoGUI((Cfg) c, "Configuración de " + c, cfgFrame.mainPanel, cfgFrame.resultPanel);
            }
        }

    }// GEN-LAST:event_genCodeActionPerformed

    private void injMdlActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_injMdlActionPerformed
        // Add XML document element to modelToLoad
        try {
            sLib.clear();
            cLib.clear();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(xmlText.getText())));
            Element root = doc.getDocumentElement();
            sLib.fromXML(root);
            // System.out.println("Total de " + sLib.size() + " instancias cargadas");
            s = sLib.last();
            // System.out.println("El objeto modelo es " + s);
            // System.out.print(" y");
            if (s != null) {
                if (!s.isConsistent()) {
                    // System.out.print(" No");
                }
                // System.out.println(" es consistente");
                this.loadModelIntoResult(sLib, "Modelo de " + s, cfgXMLFrame.mainPanel, cfgXMLFrame.resultPanel, 1);
                // System.out.println("Sus valores son " + ((PORISNode) s).getValues());
                // System.out.println("Sus hijos son " + ((PORISNode) s).getSubSystems());
                // System.out.println("Sus modos son " + ((PORISNode) s).getModes());
                c = new Cfg(((PORISNode) s));
                ArrayList<PORIS> aux = new ArrayList();
                if (c.subTree(aux)) {
                    cLib.addPORISItems(aux);
                    this.loadModelIntoResult(cLib, "Configuracion de " + c, cfgXMLCfgFrame.mainPanel,
                            cfgXMLCfgFrame.resultPanel, 1);
                }
                loadCfgIntoGUI((Cfg) c, "Configuración de " + c, cfgFrame.mainPanel, cfgFrame.resultPanel);
            } else {
                System.err.println("Error! no se ha podido cargar la librería desde el XML")
            }

        } catch (Exception exc) {
            System.err.println("SubSystemsV4View.injMdlActionPerformed [" + exc.getLocalizedMessage() + "]");
        }
    }// GEN-LAST:event_injMdlActionPerformed

    private void xtMdlActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_xtMdlActionPerformed
        PORISXML modelXML = new PORISXML(sLib);
        xmlText.setText(modelXML.getXMLString());
    }// GEN-LAST:event_xtMdlActionPerformed

    private void injCfgActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_injCfgActionPerformed
        // Add XML document element to modelToLoad
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(xmlText.getText())));
            Element root = doc.getDocumentElement();
            cLib.clear();
            cLib.fromXML(root);
            // System.out.println("Total de " + cLib.size() + " instancias cargadas");
            c = cLib.last();
            // System.out.println("El objeto cfg es " + s);
            // System.out.print(" y");
            if (!s.isConsistent()) {
                // System.out.print(" No");
            }
            // System.out.println(" es consistente");
            this.loadModelIntoResult(cLib, "Configuracion de " + c, cfgXMLCfgFrame.mainPanel,
                    cfgXMLCfgFrame.resultPanel, 1);
            loadCfgIntoGUI((Cfg) c, "Configuración de " + c, cfgFrame.mainPanel, cfgFrame.resultPanel);
        } catch (Exception exc) {
            System.err.println("SubSystemsV4View.injCfgActionPerformed [" + exc.getLocalizedMessage() + "]");
        }
    }// GEN-LAST:event_injCfgActionPerformed

    private void xtCfgActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_xtCfgActionPerformed
        PORISXML modelXML = new PORISXML(cLib);
        xmlText.setText(modelXML.getXMLString());
    }// GEN-LAST:event_xtCfgActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton genCode;
    private javax.swing.JButton injCfg;
    private javax.swing.JButton injMdl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton openCfgFrame;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JPanel xmlPanel;
    private javax.swing.JTextArea xmlText;
    private javax.swing.JButton xtCfg;
    private javax.swing.JButton xtMdl;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
}
