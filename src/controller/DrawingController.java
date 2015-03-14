package controller;

import model.Edge;
import model.Graph;
import model.Node;
import model.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;

public class DrawingController {

    private Graph graph;

    private ArrayList<Node> selectedNodes;
    private ArrayList<Edge> selectedEdges;
    private Node selectedNode = null;

    public DrawingController(Graph graph) {
        this.graph = graph;
    }

    public void mainPanelMouseClicked(MouseEvent evt) {

        boolean found = false;
        int x = evt.getX();
        int y = evt.getY();

        if (!evt.isControlDown())
            selectedNodes.clear();

        for (Node n : graph.getNodes()) {
            if (n.contains(x, y) && !found) {
                selectedNodes.add(n);
                found = true;
            }
        }

        if (selectedNodes.isEmpty()) {
            graph.addNode(new Node(25, x, y, "name", Shape.SQUARE, Color.BLACK));
        }
    }

    public Graph getGraph() {
        return graph;
    }


    public void mainPanelMousePressed(MouseEvent evt) {

        boolean found = false;
        int x = evt.getX();
        int y = evt.getY();

        for (Node n : graph.getNodes()) {
            if (n.contains(x, y) && !found) {
                selectedNode = n;
                found = true;
            }
        }
    }

    public void mainPanelMouseReleased(MouseEvent evt) {
        if(selectedNode != null) {
            Node isNode = isOnNode(evt.getX(), evt.getY());
            if(isNode == null) {
                Node n = new Node(25, evt.getX(), evt.getY(), "name", Shape.CIRCLE, Color.BLACK);
                graph.addNode(n);
                graph.addEdge(new Edge(selectedNode, n));
            } else {
                graph.addEdge(new Edge(selectedNode, isNode));
            }
            selectedNode = null;
        }
    }

    /**
     * Utility function : return node on position x, y
     * @param x position on x
     * @param y position on y
     * @return node or null
     */
    public Node isOnNode(int x, int y) {
        for (Node n : graph.getNodes()) {
            if (n.contains(x, y)) {
                return n;
            }
        }
        return null;
    }

    public ArrayList<Edge> getSelectedEdges() {
        return selectedEdges;
    }

    public ArrayList<Node> getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedEdges(ArrayList<Edge> selectedEdges) {
        this.selectedEdges = selectedEdges;
    }

    public void setSelectedNodes(ArrayList<Node> selectedNodes) {
        this.selectedNodes = selectedNodes;
    }

}
