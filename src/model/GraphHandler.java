package model;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class GraphHandler extends Observable {
    private Graph currentGraph;
    private ArrayList<Graph> graphs;

    /**
     * Default constructor
     */
    public GraphHandler() {
        currentGraph = new Graph();
        graphs = new ArrayList<Graph>();
        graphs.add(currentGraph);
    }

    /**
     * @return The list of Nodes
     */
    public ArrayList<Node> getNodes() {
        return currentGraph.getNodes();
    }

    /**
     * @return the list of edges
     */
    public ArrayList<Edge> getEdges() {
        return currentGraph.getEdges();
    }

    /**
     * create a new graph
     */
    public void createNewGraph() {
        if (currentGraph != null) {
            String path = "/saves/defaultsave.dot";
            if (currentGraph.getFile() != null) {
                path = currentGraph.getFile();
            }
            try {
                currentGraph.save(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        currentGraph = new Graph();
        graphs.add(currentGraph);
        notifyObservers(this);
    }

    /**
     * @return the current graph which is used
     */
    public Graph getCurrentGraph() {
        return currentGraph;
    }

    /**
     * add an observer to the current graph
     *
     * @param o observer
     */
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(this);
    }

    /**
     * add a new graph
     *
     * @param g new graph
     */
    public void addGraph(Graph g) {
        if (currentGraph != null) {
            String path = "/saves/defaultsave.dot";
            if (currentGraph.getFile() != null) {
                path = currentGraph.getFile();
            }
            try {
                currentGraph.save(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        currentGraph = g;
        graphs.add(g);
        notifyObservers(this);
    }
}
