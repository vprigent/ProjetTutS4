package model;

import java.awt.Color;
import java.util.Collection;
import java.util.Observable;


public class GraphHandler extends Observable {
    private Graph g;

    public GraphHandler() {
    	g = new Graph();
    }

    public void addNode(int size, int posX, int posY, String name, Shape shape, Color color) {
        g.addNode(new Node(size, posX, posY, name, shape, color));
    }

    public synchronized Collection<Node> getNodes() {
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
    
    public void removeAll(){
    	g.removeAll();
    }
}
