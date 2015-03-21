package model;

import model.algorithm.IAlgorithm;
import model.fileManager.GraphLoader;
import model.fileManager.Graphml;
import model.fileManager.Graphvis;

import java.util.ArrayList;


public class Graph {

    public static final int defaultThickness = 1;

    private String name = "Default";

    private String file;

    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private GraphLoader graphl;
    /**
     * Default Constructor
     */
    public Graph() {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }

    /**
     * Constructor
     *
     * @param file file where you load the graph
     */
    public Graph(String file) {
        this.file = file;

        try {
            this.loadGraph();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Load the graph from a specific file
     */
    private void loadGraph() throws Exception {
        if (file.endsWith("xml") || file.endsWith("graphml")) {
            new Graphml().loadGraph(file, this);
        } else if (file.endsWith("dot")) {
            new Graphvis().loadGraph(file, this);
        } else {
            throw new Exception("Error on load file");
        }
    }

    /**
     * Save the current graph on a file
     */
    public void save(String path) throws Exception {
        this.file = path;
        if (file.endsWith("xml") || file.endsWith("graphml")) {
            new Graphml().saveGraph(this, file);
        } else if (file.endsWith("dot")) {
            new Graphvis().saveGraph(this, file);
        } else {
            throw new Exception("Error on save file");
        }

    }

    /**
     * Apply a specific algorithm to the graph
     */
    public void applyAlgorithm(IAlgorithm algorithm) {
        algorithm.Algorithm(this);
    }

    /**
     * Move a node to a new position
     */
    public void moveNode(Node n, int x, int y) {
        if (n != null) n.setPosition(x, y);
    }

    /**
     * Add a new node to the graph
     *
     * @param n node to add
     */
    public void addNode(Node n) {
        nodes.add(n);
    }

    /**
     * Add a new edge to the graph
     *
     * @param e edge to add
     */
    public void addEdge(Edge e) {
        edges.add(e);
    }

    /**
     * Remove a node and every edges associated
     */
    public void removeNode(Node n) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getDestination() == n || edges.get(i).getSource() == n) {
                edges.remove(i);
                i = edges.size();
            }
        }
        nodes.remove(n);
    }

    /**
     * Remove a edge between two nodes
     */
    public void removeEdge(Edge e) {
        edges.remove(e);
    }

    /**
     * Search and return the node with the given coordinates
     *
     * @param x the coordinate in x of the node
     * @param y the coordinate in y of the node
     * @return the node if exist or null
     */
    public Node getNodeFromCoordinates(int x, int y) {
        if (nodes.isEmpty()) {
            return null;
        }

        for (Node n : nodes) {
            if (n.getPosX() == x && n.getPosY() == y) {
                return n;
            }
        }

        return null;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    /**
     * @return name of the graph
     */
    public String getName() {
        return name;
    }

    /**
     * @return path of the file
     */
    public String getFile() {
        return file;
    }

    /**
     * Clear the graph, by removing edges and nodes
     */
    public void removeAll() {
        edges.clear();
        nodes.clear();
    }

    /**
     * Debugging function
     */
    @Override
    public String toString() {
        return "Graph{" +
                "name='" + name + '\'' +
                ", file='" + file + '\'' +
                ", defaultThickness=" + defaultThickness +
                ", nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
