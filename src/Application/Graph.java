package Application;

import java.awt.*;
import java.util.Collection;

import Application.Edge;
import Application.Node;


/**
 * Created by Vincent on 26/01/2015.
 */
public class Graph {
    private String name;
    private String file; // c'est le fichier de sauvegarde ou duquel a été chargé le graphe ?
    private Color defaultColor;
    private int defaultThickness;
    private Collection<Node> nodes; // NB V. : J'aurais fait un set pour ça, étant donné qu'aucun noeud ne peut être dupliqué
    private Collection<Edge> edges; // NB V. : De même ici

    /**
     * Constructor
     */
    public Graph(){

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

}
