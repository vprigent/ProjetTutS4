package model;

import java.awt.*;
import java.util.ArrayList;

public class Graph {
    private String name = "Default";
    private String file; // c'est le fichier de sauvegarde ou duquel a été chargé le graphe ?
    private Color defaultColor = Color.black;
    private int defaultThickness = 1;
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    /**
     * Constructor
     */
    public Graph() {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }


    /**
     * Load the graph from a specific file
     */
    public void loadGraph() {

    }

    /**
     * Create a new node and add it to the current graph
     */
    public void createNode() {

    }

    /**
     * Create a new edge and add it to the current graph
     */
    public void createEdge() {

    }

    /**
     * Apply a specific algorithm to the graph
     */
    public void applyAlgorithm() {

    }

    /**
     * Remove a node and every edges associated
     */
    public void removeNode() {

    }


    /**
     * Remove a edge between two nodes
     */
    public void removeEdge() {

    }

    /**
     * Move a node to a new position
     */
    public void moveNode() {

    }

    /**
     * Select what ?
     */
    public void select() {

    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    /**
     * Debugging function
     */
    @Override
    public String toString() {
        return "Graph{" +
                "name='" + name + '\'' +
                ", file='" + file + '\'' +
                ", defaultColor=" + defaultColor +
                ", defaultThickness=" + defaultThickness +
                ", nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
