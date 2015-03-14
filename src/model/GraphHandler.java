package model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;



public class GraphHandler extends Observable {
    private Graph currentGraph;

    public GraphHandler() {
    	currentGraph = new Graph();
    }

    public void addNode(Node node) {
        currentGraph.addNode(node);
        setChanged();
        notifyObservers(this);
    }

    public ArrayList<Node> getNodes() {
        return currentGraph.getNodes();
    }

    public ArrayList<Edge> getEdges() { return currentGraph.getEdges();}

    public void createNewGraph() {
        if (currentGraph != null) currentGraph.save();
        currentGraph = new Graph();
    }

    public void loadGraphFromFile(String path) {
        currentGraph = new Graph(path);
    }

    public Graph getCurrentGraph() {
        return currentGraph;
    }
    
    public void removeAll(){
    	currentGraph.removeAll();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(this);
    }
}
