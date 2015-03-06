package model.fileManager;

import model.Edge;
import model.Graph;
import model.Node;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Graphml extends GraphLoader {
    @Override
    public Graph loadGraph(String filePath) {
        return null;
    }

    @Override
    protected Graph createGraphFromData(String data) {
        return null;
    }

    @Override
    public void saveGraph(Graph g, String filePath) {

        String temp;


        Element xmlnamespace = new Element("graphml", Namespace.getNamespace("http://graphml.graphdrawing.org/xmlns"));
        xmlnamespace.addNamespaceDeclaration(Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance"));
        Namespace xsi = Namespace.getNamespace("xsi","http://www.w3.org/2001/XMLSchema-instance");
        Attribute t = new Attribute("schemaLocation", "http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd").setNamespace(xsi);
        xmlnamespace.setAttribute(t);


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
        key.setAttribute("id", "d1");
        key.setAttribute("for", "node");
        key.setAttribute("attr.name", "value");
        key.setAttribute("attr.type", "int");
        key.addContent(new Element("default").setText("1"));

        xmlnamespace.addContent(key);
        
        Element root = new Element("graph");
        root.setNamespace(Namespace.NO_NAMESPACE);
        root.setAttribute("id", g.getName());
        xmlnamespace.addContent(root);


        for (Node n : g.getNodes()) {
            Element node = new Element("node");
            node.setAttribute("id", n.getName());
            root.addContent(node);
        }

        for (Edge e : g.getEdges()) {
            Element edge = new Element("edge");
            edge.setAttribute("source", e.getSource().getName());
            edge.setAttribute("target", e.getDestination().getName());
            root.addContent(edge);
        }

        Document document = new Document(xmlnamespace);

        try {
            //On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, System.out);
        } catch (java.io.IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
