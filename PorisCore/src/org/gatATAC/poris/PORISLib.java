/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatATAC.poris;

import org.gatATAC.poris.MVC.Model;
import org.gatATAC.poris.MVC.Observer;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author txinto
 */
public class PORISLib extends Model {

    private final ArrayList<PORIS> nodeList;

    /**
     * 
     * @param name
     */
    public PORISLib(String name) {
        super(name);
        nodeList = new ArrayList();
    }

    /**
     * 
     */
    public void clear() {
        nodeList.clear();
        notifyObs();
    }

    /**
     * 
     * @param obs
     */
    @Override
    public void attach(Observer obs) {
        super.attach(obs);
        for (int i = 0; i < this.nodeList.size(); i++) {
            this.nodeList.get(i).attach(obs);
        }
    }

    /**
     * 
     * @return
     */
    public int size() {
        return nodeList.size();
    }

    /**
     * 
     * @return
     */
    public PORIS last() {
        if (nodeList.size() > 0){
            return this.nodeList.get(nodeList.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * 
     * @param items
     */
    public void addPORISItems(ArrayList<PORIS> items) {
        for (int i = 0; i < items.size(); i++) {
            this.nodeList.add(items.get(i));
        }
        notifyObs();
    }

    /**
     * 
     * @param node
     * @return
     */
    public ArrayList<PORIS> fromXML(Node node) {
        nodeList.clear();
        NodeList instanceNodes = node.getChildNodes();

        for (int i = 0; i < instanceNodes.getLength(); i++) {
            Node instanceNode = instanceNodes.item(i);
            String instanceNodeName = instanceNode.getNodeName();
            //System.out.println("Compruebo el child " + instanceNodeName);

            System.out.println("Hola!"+instanceNode);
            Node instanceTypeNode = PORIS.getChildNodeWithName(instanceNode, "type");
            if (instanceTypeNode != null) {
                //System.out.println("Tiene el atributo type!!!" + instanceTypeNode);
                String instanceClassName = instanceTypeNode.getTextContent();
                System.out.println("Tiene atributos!!! La clase es " + instanceClassName);
                if (instanceClassName.equals("PORISParam"))
                {
                    instanceClassName = "PORISNode";
                }
                else
                {
                        if (instanceClassName.equals("PORISSys"))
                        {
                            instanceClassName = "PORISNode";
                        }             
                }    
                System.out.println("Loading "+instanceClassName);
                try {
                    /* Parche, intentar que no haya que poner el path a mano */
                    Class nodeClass = Class.forName("org.gatATAC.poris." + instanceClassName);
                    if (nodeClass != null) {
                        PORIS instance = PORIS.fromXML(nodeClass, instanceNode);
                        if (instance != null) {
                            nodeList.add(instance);
                            System.out.println("Cargué perfectamente " + instanceNodeName);
                            System.out.println("Generando la instancia " + instance);
                        } else {
                            System.out.println("Falló la carga de " + instanceNodeName);
                        }
                    } else {
                        System.out.println(instanceClassName + " class could not be found");
                    }
                    
                } catch (ClassNotFoundException e) {
                    System.err.println("Me salto el nodo de clase " + instanceClassName);
                }
            } else {
                //System.out.println("Me salto el nodo " + instanceNodeName);
            }
        }
        
        notifyObs();
        return nodeList;
    }

    /**
     * 
     * @param doc
     * @return
     */
    public Element toXML(Document doc) {
        Element ret = doc.createElement("poris");
        ret.setAttribute("id", "systems");
        ret.setNodeValue("systems");
        for (int i = 0; i < nodeList.size(); i++) {
            try {
                Element childNode = nodeList.get(i).toXML(doc, false);
                if (childNode != null) {
                    ret.appendChild(childNode);
                }
            } catch (Exception e) {
                System.err.println("Ocurrió una excepción "+e.getLocalizedMessage()+" en el nodo "+nodeList.get(i));
            }
        }
        return ret;
    }
}
