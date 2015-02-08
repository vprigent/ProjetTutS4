package model.fileManager;

import model.Graph;

public class Graphvis extends GraphLoader {
    @Override
    public Graph loadGraph(String file) {
        return null;
    }

    @Override
    protected Graph createGraphFromData(String data) {
        Graph g = new Graph();

        // Removed blanks
        data = data.replaceAll(" ", "");

        String[] buffer = data.split("{*}");


        for(String s : buffer)
            System.out.println(s);

        return g;
    }

    @Override
    public void saveGraph(Graph g) {

    }
}
