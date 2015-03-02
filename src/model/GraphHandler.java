package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;


public class GraphHandler extends Observable {
    private Graph g;

    public GraphHandler() {
    	g = new Graph();
    }

    public void addNode(int size, int posX, int posY, String name, Shape shape, Color color) {
        g.addNode(new Node(size, posX, posY, name, shape, color));
    }

    public Vector<Node> getNodes() {
        return g.getNodes();
    }

    public void createNewGraph() {
        if (g != null) g.save();
        g = new Graph();
    }

    public void loadGraphFromFile(String path) {
        g = new Graph(path);
    }

    public Graph getCurrentGraph() {
        return g;
    }
}
