/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatATAC.poris;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author osiris
 */
public class PORISMode extends PORIS {

    private PORISValue defaultValue;
    private PORISMode defaultSubMode;

    /**
     * 
     * @param name
     */
    public PORISMode(String name) {
        super(name);
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
    public Element toXML(Document doc, Class tagClass, boolean onlyIdent) {
        Element ret = super.toXML(doc, tagClass, onlyIdent);
        if (!onlyIdent) {
        }
        return ret;
    }

    /**
     * 
     * @param sm
     */
    public void addSubMode(PORISMode sm) {
        this.addDestination(sm);
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
    public PORISMode getDefaultSubMode() {
        return defaultSubMode;
    }

    /**
     * 
     * @param defaultSubMode
     */
    public void setDefaultSubMode(PORISMode defaultSubMode) {
        if (this.defaultSubMode != defaultSubMode) {
            this.defaultSubMode = defaultSubMode;
            notifyObs();
        }
    }

    /**
     * 
     * @return
     */
    public PORISValue getDefaultValue() {
        return defaultValue;
    }

    /**
     * 
     * @param defaultValue
     */
    public void setDefaultValue(PORISValue defaultValue) {
        if (this.defaultValue != defaultValue) {
            this.defaultValue = defaultValue;
            notifyObs();
        }
    }

    /**
     * 
     * @return
     */
    public ArrayList<PORIS> getSubModes() {
        return getFromListByClass(this.destinations, PORISMode.class);
    }

    /**
     * 
     * @return
     */
    public ArrayList<PORIS> getSuperModes() {
        return getFromListByClass(this.sources, PORISMode.class);
    }

    /**
     * 
     * @return
     */
    public ArrayList<PORIS> getSystems() {
        return getFromListByClass(this.sources, PORISNode.class);
    }

    /**
     * 
     * @return
     */
    public ArrayList<PORIS> getValues() {
        return getFromListByClass(this.destinations, PORISValue.class);
    }

    /**
     * 
     * @param name
     * @return
     */
    public PORISMode getSubModeFromName(String name) {
        for (int i = 0; i < this.getSubModes().size(); i++) {
            if (((PORISMode) this.getSubModes().get(i)).getName().equals(name)) {
                return ((PORISMode) this.getSubModes().get(i));
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
        for (int i = 0; i < this.getValues().size(); i++) {
            if (this.getValues().get(i).getName().equals(name)) {
                return (PORISValue) this.getValues().get(i);
            }
        }
        return null;
    }

    /**
     * 
     * @param child
     */
    @Override
    public void addDestination(PORIS child) {
        if (child.isDescendantOf(PORISMode.class) &&
                this.getDefaultSubMode() == null) {
            this.defaultSubMode = (PORISMode) child;
        } else {
            if (child.isDescendantOf(PORISValue.class) &&
                    this.getDefaultValue() == null) {
                this.defaultValue = (PORISValue) child;
            }
        }
        super.addDestination(child);
    }

    /**
     * 
     * @param node
     * @return
     */
    @Override
    public boolean loadFromXML(Node node) {
        boolean ret = super.loadFromXML(node);
        // Name
        //System.out.println("Ejecuto el codigo ValueDoubleRange.loadFromXML()");
        String defVal = getChildNodeWithName(node, "default-value-id").getTextContent();
        if (defVal != null) {
            PORISValue newVal = (PORISValue) xmlLoaderHashMap.get(defVal);
            if (newVal != null) {
                this.setDefaultValue(newVal);
            }
        }
        String defMod = getChildNodeWithName(node, "default-mode-id").getTextContent();
        if (defMod != null) {
            PORISMode newMod = (PORISMode) xmlLoaderHashMap.get(defMod);
            if (newMod != null) {
                //System.out.println("En el modo "+this+" he añadido el modo por defecto " + newMod);
                this.setDefaultSubMode(newMod);
            }
        }
        return ret;
    }
}
