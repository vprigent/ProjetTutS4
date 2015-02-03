package model;

import java.awt.*;
import java.util.Observable;


public class GraphHandler extends Observable {
    private Graph g;

    public GraphHandler() {
    }

    public void addNode() {
        g.addNode(new Node());
    }

    public void addNode(int size, int posX, int posY, String name, Shape shape, Color color) {
        g.addNode(new Node(size, posX, posY, name, shape, color));
    }


    public void createNewGraph() {
        if (g != null) g.save();
        g = new Graph();
    }

    public void loadGraphFromFile(String path) {
        g = new Graph(path);
    }


}
