/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gatATAC.poris;

import org.w3c.dom.Node;

/**
 *
 * @author osiris
 */
public class PORISGroup extends PORISNode {
    /**
     * 
     * @param name
     */
    public PORISGroup(String name) {
        super(name);
    }

    /**
     * 
     * @param node
     * @return
     */
    @Override
    public boolean loadFromXML(Node node) {
        boolean ret = super.loadFromXML(node);
        return ret;
    }

}
