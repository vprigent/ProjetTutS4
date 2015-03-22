package model.fileManager;

import model.Edge;
import model.Graph;
import model.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Graphvis extends GraphLoader {
    @Override
    public Graph loadGraph(String filePath, Graph graph) {

        try {
            // récupérer tout le fichier pour ensuite exploiter ses infos
            String data = new BufferedReader(new FileReader(filePath)).readLine();

        } catch (IOException e) {
            System.out.println(e);
        }

        //System.out.println(data);

        return null;
    }

    @Override
    protected Graph createGraphFromData(String data) {
        Graph g = new Graph();

        String[] buffer = data.split("[\\{*\\}]");

        for (String s : buffer)
            separateDatas(s);

        return g;
    }

    public void extractDatasFromLine(String line, Graph g) {

    }

    public void separateDatas(String s) {
        String[] lineBuffer = s.split("\n");
    }

    @Override
    public void saveGraph(Graph g, String filePath) {
        StringBuilder str = new StringBuilder();

        str.append("digraph" + " \"" + g.getName() + "\" " + "{" + "\n");

        for (Node n : g.getNodes()) {
            String node = "     \"" + n.getID() + "\" ";
            node += " [ " + "label=\"" + n.getName() + "\" " + "shape=" + n.getShape() + " color=" + n.getColor().getRGB();
            node += " ];\n";
            str.append(node);
        }

        for (Edge e : g.getEdges()) {
            String edge = "     \"" + e.getSource().getID() + "\"" + " -> " + "\"" + e.getDestination().getID() + "\" " + "[";
            edge += " color=" + e.getColor().getRGB() + " label=\"" + e.getLabel() + "\"";
            edge += " ];\n";
            str.append(edge);
        }

        str.append("}");
    }
}
