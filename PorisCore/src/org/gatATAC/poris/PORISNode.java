/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatATAC.poris;

import java.util.ArrayList;
import org.gatATAC.XML.Utils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author osiris
 */
public class PORISNode extends PORIS {

    private PORISMode defaultMode;

    /**
     * 
     * @param name
     */
    public PORISNode(String name) {
        super(name);
    }

    /**
     * 
     * @param defaultMode
     */
    public void setDefaultMode(PORISMode defaultMode) {
        if (defaultMode!=this.defaultMode) {
            this.defaultMode = defaultMode;
            //System.out.println("2 En "+this+" pongo como defaultMode "+defaultMode);
            notifyObs();
        }
    }

    /**
     * 
     * @return
     */
    public PORISMode getDefaultMode() {
        return defaultMode;
    }

    /**
     * 
     * @param sm
     */
    public void addMode(PORISMode sm) {
        this.addDestination(sm);
    }

    /**
     * 
     * @param child
     */
    @Override
    public void addDestination(PORIS child) {
        if (child.isDescendantOf(PORISMode.class) &&
                this.getDefaultMode()==null)
        {
            this.defaultMode=(PORISMode)child;
            //System.out.println("En "+this+" pongo como defaultMode "+child);
        }
        super.addDestination(child);
    }

    /**
     * 
     * @param s
     */
    public void addSubSystem (PORISNode s) {
        this.addDestination(s);
    }

    /**
     * 
     * @param v
     */
    public void addValue(PORISValue v) {
        this.addDestination(v);
    }
    
    /**
     * 
     * @return
     */
    public ArrayList<PORIS> getModes() {
        return this.getFromListByClass(this.destinations, PORISMode.class);
    }

    /**
     * 
     * @return
     */
    public ArrayList<PORIS> getSubSystems() {
        return this.getFromListByClass(this.destinations, PORISNode.class);
    }

    /**
     * 
     * @return
     */
    public ArrayList<PORIS> getSuperSystems() {
        return this.getFromListByClass(this.sources, PORISNode.class);
    }

    /**
     * 
     * @return
     */
    public ArrayList<PORIS> getValues() {
        return this.getFromListByClass(this.destinations, PORISValue.class);
    }

    /**
     * 
     * @param name
     * @return
     */
    public PORISMode getModeFromName(String name) {
        for (int i=0;i<this.getModes().size();i++) {
            if (this.getModes().get(i).getName().equals(name)) {
                return (PORISMode)this.getModes().get(i);
            }
        }
        return null;
    }

    /**
     * 
     * @param name
     * @return
     */
    public PORISValue getValueFromName(String name) {
        for (int i=0;i<this.getValues().size();i++) {
            if (this.getValues().get(i).getName().equals(name)) {
                return (PORISValue)this.getValues().get(i);
            }
        }
        return null;
    }


    /**
     * 
     * @param name
     * @return
     */
    public PORISNode getSubSystemFromName(String name) {
        for (int i=0;i<this.getSubSystems().size();i++) {
            if (((PORISNode)this.getSubSystems().get(i)).getName().equals(name)) {
                return (PORISNode)this.getSubSystems().get(i);
            }
        }
        return null;
    }

    /**
     * 
     * @param name
     * @return
     */
    public PORISNode getDescendantFromName(String name) {
        for (int i=0;i<this.getSubSystems().size();i++) {
            if (((PORISNode)this.getSubSystems().get(i)).getName().equals(name)) {
                return (PORISNode)this.getSubSystems().get(i);
            } else {
                PORISNode ret=((PORISNode)this.getSubSystems().get(i)).getDescendantFromName(name);
                if (ret!=null){
                    return ret;
                }
            }
        }
        return null;
    }
    

    /**
     * 
     * @param doc
     * @param tagClass
     * @param onlyIdent
     * @return
     */
    @Override
    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.BB277CA2-6794-D485-5D21-166CDDA9B7F6]
    // </editor-fold>
    public Element toXML (Document doc, Class tagClass, boolean onlyIdent) {
        Element ret=super.toXML(doc, tagClass, onlyIdent);
        if (!onlyIdent) {
            if (this.getDefaultMode() != null) {
                Element defaultModeNode = doc.createElement("default-mode-id");
                Utils.setTextContent(doc, defaultModeNode, Integer.toString(this.getDefaultMode().getId()));
                ret.appendChild(defaultModeNode);
            }
        }
        return ret;
    }

    /**
     * 
     * @param node
     * @return
     */
    @Override
    public boolean loadFromXML(Node node) {
        boolean ret = super.loadFromXML(node);
        String defMod = getChildNodeWithName(node, "default-mode-id").getTextContent();
        if (defMod != null) {
            PORISMode newMod = (PORISMode) xmlLoaderHashMap.get(defMod);
            if (newMod != null) {
                this.setDefaultMode(newMod);
            }
        }
        return ret;
    }

}
