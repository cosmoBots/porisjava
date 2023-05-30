/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gatATAC.poris;

/**
 *
 * @param <T> 
 * @author txinto
 */
public interface PORISValueData<T> {
    /**
     * 
     * @return
     */
    public T getDefaultValue();
    /**
     * 
     * @param defaultValue
     */
    public void setDefaultValue(T defaultValue);
}
