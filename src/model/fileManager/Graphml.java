package model.fileManager;

import model.Edge;
import model.Graph;
import model.Node;
import model.Shape;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

public class Graphml extends GraphLoader {
    @Override
    public Graph loadGraph(String filePath, Graph graph) {
        SAXBuilder sxb = new SAXBuilder();
        Document document = null;
        Element racine;

        try {
            document = sxb.build(new File(filePath));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        racine = document.getRootElement();
        List graphs = racine.getChildren();

        for (Object graph1 : graphs) {

            Element grp = (Element) graph1;
            List Node = grp.getChildren();

            for (Object e : Node) {
                if (((Element) e).getName().equals("node")) {
                    graph.addNode(new Node(25, 1 + (int) (Math.random() * (800 - 1) + 1), 1 + (int) (Math.random() * (800 - 1) + 1), ((Element) e).getAttributeValue("id"), Shape.SQUARE, Color.getColor(((Element) e).getValue().replaceAll("\\s", "").toUpperCase())));
                }
                if (((Element) e).getName().equals("edge")) {
                    if (((Element) e).getValue() != null) {
                        //graph.addEdge(new Edge((((Element) e).getAttributeValue("source")),(((Element) e).getAttributeValue("target")),false, java.awt.Color.black,((Element) e).getAttributeValue("id"),Float.parseFloat(String.valueOf(((Element) e).getValue()))));
                    }
                }
                System.out.println(((Element) e).getAttributeValue("source"));
                System.out.println(((Element) e).getValue());
            }
        }

        return graph;
    }

    @Override
    protected Graph createGraphFromData(String data) {
        return null;
    }

    @Override
    public void saveGraph(Graph g, String filePath) {

        Element xmlnamespace = new Element("graphml", Namespace.getNamespace("http://graphml.graphdrawing.org/xmlns"));
        xmlnamespace.addNamespaceDeclaration(Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance"));
        Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        Attribute t = new Attribute("schemaLocation", "http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd").setNamespace(xsi);
        xmlnamespace.setAttribute(t);


        // region Ajout des identifiants
        /* Define all the keys needed*/
        Element key = new Element("key");
        key.setAttribute("id", "d0");
        key.setAttribute("for", "node");
        key.setAttribute("attr.name", "color");
        key.setAttribute("attr.type", "string");
        key.addContent(new Element("default").setText("black"));

        xmlnamespace.addContent(key);

        key = new Element("key");
        key.setAttribute("id", "d1");
        key.setAttribute("for", "node");
        key.setAttribute("attr.name", "shape");
        key.setAttribute("attr.type", "string");
        key.addContent(new Element("default").setText("square"));

        xmlnamespace.addContent(key);

        key = new Element("key");
        key.setAttribute("id", "d2");
        key.setAttribute("for", "node");
        key.setAttribute("attr.name", "value");
        key.setAttribute("attr.type", "int");
        key.addContent(new Element("default").setText("1"));

        xmlnamespace.addContent(key);

        key = new Element("key");
        key.setAttribute("id", "d3");
        key.setAttribute("for", "edge");
        key.setAttribute("attr.name", "weight");
        key.setAttribute("attr.type", "int");
        key.addContent(new Element("default").setText("1"));

        xmlnamespace.addContent(key);

        key = new Element("key");
        key.setAttribute("id", "d0");
        key.setAttribute("for", "edge");
        key.setAttribute("attr.name", "color");
        key.setAttribute("attr.type", "string");
        key.addContent(new Element("default").setText("black"));

        xmlnamespace.addContent(key);

        //endregion

        Element root = new Element("graph");
        root.setNamespace(Namespace.NO_NAMESPACE);
        root.setAttribute("id", g.getName());
        xmlnamespace.addContent(root);


        for (Node n : g.getNodes()) {
            Element node = new Element("node");
            node.setAttribute("id", String.valueOf(n.getID()));

            if (n.getColor() != Node.getDefaultColor()) {
                node.addContent(new Element("data").setAttribute("key", "d0").setText(n.getColor().toString()));
            }

            if (n.getShape() != Node.getDefaultShape()) {
                node.addContent(new Element("data").setAttribute("key", "d1").setText(n.getShape().toString().toLowerCase()));
            }

            node.setAttribute("x", String.valueOf(n.getPosX()));
            node.setAttribute("y", String.valueOf(n.getPosY()));

            root.addContent(node);
        }

        for (Edge e : g.getEdges()) {
            Element edge = new Element("edge");
            edge.setAttribute("source", String.valueOf(e.getSource().getID()));
            edge.setAttribute("target", String.valueOf(e.getDestination().getID()));

            if (e.isOriented()) {
                edge.setAttribute("directed", "true");
            }

            if (e.getColor() != Edge.getDefaultColor()) {
                edge.addContent(new Element("data").setText(e.getColor().toString()));
            }

            root.addContent(edge);
        }

        Document document = new Document(xmlnamespace);

        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, new FileWriter(filePath));
        } catch (java.io.IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
