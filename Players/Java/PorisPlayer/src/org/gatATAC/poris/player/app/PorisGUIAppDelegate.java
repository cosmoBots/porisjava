/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatATAC.poris.player.app;

import java.awt.Dimension;
import org.gatATAC.poris.Cfg;
import javax.swing.JFrame;
import org.gatATAC.poris.app.PorisAppDelegate;
import org.gatATAC.poris.player.CfgFrame;

/**
 *
 * @author txinto
 */
public class PorisGUIAppDelegate extends PorisAppDelegate {

    private final CfgFrame panelFrame;
    private boolean xmlSystemFrameVisible = true;
    private boolean xmlConfigFrameVisible = true;
    private int defaultCloseOperation = JFrame.HIDE_ON_CLOSE;

    public PorisGUIAppDelegate(String instrumentFileName, boolean showXMLButtons, boolean showInvisible, boolean showAbout) {
        super(instrumentFileName);
        this.applicationDetails+="\nPorisPlayer v0.32";
        this.panelFrame = new CfgFrame(this, showXMLButtons,showInvisible,showAbout);
        this.initialization();
    }

    public void frameWillHide(){
        // Override this method to respond to the window hidding
    }

    public int getDefaultCloseOperation() {
        return defaultCloseOperation;
    }

    public void setDefaultCloseOperation(int defaultCloseOperation) {
        this.defaultCloseOperation = defaultCloseOperation;
        if (this.panelFrame != null) {
            this.panelFrame.setDefaultCloseOperation(defaultCloseOperation);
        }
    }

    public CfgFrame getPanelFrame() {
        return panelFrame;
    }

    public boolean isXmlConfigFrameVisible() {
        return xmlConfigFrameVisible;
    }

    public void setXmlConfigFrameVisible(boolean xmlConfigFrameVisible) {
        this.xmlConfigFrameVisible = xmlConfigFrameVisible;
    }

    public boolean isXmlSystemFrameVisible() {
        return xmlSystemFrameVisible;
    }

    public void setXmlSystemFrameVisible(boolean xmlSystemFrameVisible) {
        this.xmlSystemFrameVisible = xmlSystemFrameVisible;
    }

    public void setTitle(String title){
        if (panelFrame!=null){
            panelFrame.setTitle(title);
        }
    }

    public void setSize(Dimension dim){
        this.panelFrame.setSize(dim);
    }
    
    public Dimension getSize(){
        return this.panelFrame.getSize();
    }
    
    protected boolean initialization() {
        panelFrame.loadCfgIntoGUI((Cfg) this.getConfig(), ((Cfg) this.getConfig()).getModel().toString(), panelFrame.mainPanel, panelFrame.resultPanel);
        panelFrame.setTitle(""+this.getConfig()+ " configuration");
        panelFrame.loadSystemIntoResult(this.getSystemLib(), this.getSystem());
        panelFrame.loadConfigIntoResult(this.getConfigLib(), this.getConfig());
        return true;
    }

    public boolean showPanel() {
        this.panelFrame.setVisible(true);
        return this.isModelLoaded();
    }

    public void hidePanel() {
        this.panelFrame.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        PorisGUIAppDelegate myPanel = new PorisGUIAppDelegate("instrument.xml", true,true,true);
        myPanel.showPanel();
        myPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PorisGUIAppDelegate myPanel2 = new PorisGUIAppDelegate("config.xml", true,true,false);
        myPanel2.showPanel();
        myPanel2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //System.exit(0);
    }
}
