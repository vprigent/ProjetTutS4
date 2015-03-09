package model;

import java.awt.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class GraphHandler extends Observable {
    private Graph g;

    public GraphHandler() {
    	g = new Graph();
    }

    public void addNode(Node node) {
        g.addNode(node);
        setChanged();
        notifyObservers(this);
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

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(this);
    }
}
