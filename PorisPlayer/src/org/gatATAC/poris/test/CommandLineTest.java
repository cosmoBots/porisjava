/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatATAC.poris.test;

import org.gatATAC.poris.PORIS;
import org.gatATAC.poris.PORISLib;
import org.gatATAC.poris.PORISXML;
import org.gatATAC.poris.PORISNode;
import java.util.ArrayList;

/**
 *
 * @author txinto
 */
public class CommandLineTest {

    public static void main(String[] args) {

        PORISLib sLib=new PORISLib("systems");
        PORISNode s=GenCode.load();
        ArrayList<PORIS> aux = new ArrayList();
        if (s.subTree(aux)) {
            sLib.addPORISItems(aux);
        }

        // XML output
        PORISXML paramXML = new PORISXML(sLib);
        System.out.println(paramXML.getXMLString());
    }
}
