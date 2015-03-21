package model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;



public class GraphHandler extends Observable {
    private Graph currentGraph;
    private ArrayList<Graph> graphs;

    public GraphHandler() {
    	currentGraph = new Graph();
        graphs = new ArrayList<Graph>();
        graphs.add(currentGraph);
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
        if (currentGraph != null)
            currentGraph.save();
        currentGraph = new Graph();
        graphs.add(currentGraph);
        notifyObservers(this);
    }

    public Graph getCurrentGraph() {
        return currentGraph;
    }


    public void removeAllOnCurrentGraph(){
    	currentGraph.removeAll();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(this);
    }

    public void addGraph(Graph g) {
        if(currentGraph != null)
            currentGraph.save();
        currentGraph = g;
        graphs.add(g);
        notifyObservers(this);
    }
}
