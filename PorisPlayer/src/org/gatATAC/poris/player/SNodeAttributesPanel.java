/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SNodeAttributesPanel.java
 *
 * Created on 19-feb-2010, 16:37:23
 */
package org.gatATAC.poris.player;

import org.gatATAC.poris.PORIS;
import org.gatATAC.poris.PORISAttribute;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author txinto
 */
public class SNodeAttributesPanel extends javax.swing.JFrame implements Observer {

    private final PORIS node;
    private final boolean showInvisible;

    /** Creates new form SNodeAttributesPanel */
    public SNodeAttributesPanel(PORIS node, boolean showInvisible) {
        this.node = node;
        this.showInvisible = showInvisible;
        initComponents();
        initRows(node);
    }

    
    
    public SNodeAttributesPanel() {
        this.showInvisible = false;
        node = new PORIS("testNode");
        node.addAttribute(new PORISAttribute("1", "uno", true));
        node.addAttribute(new PORISAttribute("2", "dos", false));
        node.addAttribute(new PORISAttribute("3", "tres", true));
        node.addAttribute(new PORISAttribute("4", "cuatro", false));
        node.addAttribute(new PORISAttribute("5", "cinco", true));
        initComponents();
        initRows(node);
    }

    public void initRows(PORIS node) {
        int maxLengthColumn1=0, maxLengthColumn2=0;
        int rowCount = node.getAttributes().size();
        int visibleRows = 0;
        if (!this.showInvisible) {
            for (int i = 0; i < rowCount; i++) {
                PORISAttribute thisAttr = node.getAttributes().get(i);
                if (thisAttr.isVisible()) {
                    visibleRows++;
                }
            }
        } else {
            visibleRows=rowCount;
        }
        
        Object[][] cells = new Object[visibleRows][2];
        int currentCell=0;
        for (int i = 0; i < visibleRows; i++) {
            PORISAttribute thisAttr = node.getAttributes().get(i);
            if (thisAttr.isVisible()) {
                cells[currentCell][0] = thisAttr.getName();
                cells[currentCell][1] = thisAttr.getContent();
                if (thisAttr.getName().length()>maxLengthColumn1){
                    maxLengthColumn1=thisAttr.getName().length();
                }
                if (thisAttr.getContent().length()>maxLengthColumn2){
                    maxLengthColumn2=thisAttr.getContent().length();
                }
                currentCell++;
            } else {
                if (this.showInvisible) {
                    cells[currentCell][0] = "[h]" + thisAttr.getName();
                    cells[currentCell][1] = thisAttr.getContent();
                    currentCell++;
                }
            }
            }
        table.setModel(new javax.swing.table.DefaultTableModel(
                cells,
                new String[]{
                    "Name", "Content"
                }) {

            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        // TODO: Change values 25 and 3 by more elegant way of do it.
        this.setSize(
                (maxLengthColumn1+maxLengthColumn2)*25,
                (this.table.getRowCount()+3)*(this.table.getRowHeight()+this.table.getRowMargin())
                );
        

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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setTitle(this.node.getName()+" attributes");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(100, 100));
        setName("Form"); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMaximumSize(new java.awt.Dimension(200, 400));
        jScrollPane1.setName("jScrollPane1"); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 100));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "java.lang.Object@10673fe", "java.lang.Object@10673fe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setEnabled(false);
        table.setMaximumSize(new java.awt.Dimension(200, 200));
        table.setName("table"); // NOI18N
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getColumn(0).setHeaderValue(new String("Name"));
        table.getColumnModel().getColumn(1).setHeaderValue(new String("Content"));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SNodeAttributesPanel().setVisible(true);
            }
        });
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
