/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatATAC.poris.test;

import org.gatATAC.poris.PORIS;
import org.gatATAC.poris.SNodeLib;
import org.gatATAC.poris.SNodeXML;
import org.gatATAC.poris.PORISSys;
import java.util.ArrayList;

/**
 *
 * @author txinto
 */
public class CommandLineTest {

    public static void main(String[] args) {

        SNodeLib sLib=new SNodeLib("systems");
        PORISSys s=GenCode.load();
        ArrayList<PORIS> aux = new ArrayList();
        if (s.subTree(aux)) {
            sLib.addSNodes(aux);
        }

        // XML output
        SNodeXML paramXML = new SNodeXML(sLib);
        System.out.println(paramXML.getXMLString());
    }
}
