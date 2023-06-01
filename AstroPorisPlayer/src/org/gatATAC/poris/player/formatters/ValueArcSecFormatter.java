/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gatATAC.poris.player.formatters;

import org.gatATAC.poris.formatters.ValueDoubleFormatter;

/**
 *
 * @author txinto
 */
public class ValueArcSecFormatter extends ValueDoubleFormatter{


    /**
     * 
     */
    public static void init(){

    }
    /**
     * 
     * @param name
     * @param label
     * @param id
     */
    public ValueArcSecFormatter(String name, int id, String label) {
        super(name, id, label);
    }

    /**
     * 
     * @param name
     * @param id
     */
    public ValueArcSecFormatter(String name, int id) {
        super(name, id);
    }

}
