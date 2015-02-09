package model.fileManager;

import model.Graph;
import model.Node;
import model.Edge;

public class Graphvis extends GraphLoader {
    @Override
    public Graph loadGraph(String file) {
        return null;
    }

    @Override
    protected Graph createGraphFromData(String data) {
        Graph g = new Graph();

        String[] buffer = data.split("[\\{*\\}]");

        for(String s : buffer)
            System.out.println(s);

        return g;
    }

    public void extractDatasFromLine(String line, Graph g) {

    }

    @Override
    public void saveGraph(Graph g) {

    }
}
