package model;

import java.awt.*;
import java.util.Observable;


public class GraphHandler extends Observable {
    private Graph g;

    public GraphHandler() {
    }

    public Graph getGraph() {
        return g;
    }

    public void createNewGraph() {
        if (g != null) g.save();
        g = new Graph();
    }

    public void loadGraphFromFile(String path) {
        g = new Graph(path);
    }


}
