package controller;

import model.Edge;
import model.Graph;
import model.Node;
import model.Shape;
import view.DrawingPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
            if (contains(n, x, y) && !found) {
                selectedNodes.add(n);
                found = true;
            }
        }

        if (selectedNodes.isEmpty()) {
            graph.addNode(new Node(1, x, y, "name", Shape.SQUARE, Color.BLACK));
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
            if (contains(n, x, y) && !found) {
                selectedNode = n;
                found = true;
            }
        }
    }

    /**
     * Hitbox function
     *
     * @param mouseX position on x
     * @param mouseY position on y
     * @return if the node is in this position
     */
    public boolean contains(Node n, int mouseX, int mouseY) {
        Rectangle hitbox = new Rectangle(n.getPosX(), n.getPosY(), n.getSize() * DrawingPanel.defaultSize, n.getSize() * DrawingPanel.defaultSize);

        return hitbox.contains(mouseX + n.getSize() * DrawingPanel.defaultSize / 2, mouseY + n.getSize() * DrawingPanel.defaultSize / 2);
    }


    public void mainPanelMouseReleased(MouseEvent evt) {
        if (selectedNode != null && selectedNodes.size() == 0) {
            Node isNode = isOnNode(evt.getX(), evt.getY());
            if (isNode == null) {
                Node n = new Node(1, evt.getX(), evt.getY(), "name", Shape.SQUARE, Color.BLACK);
                graph.addNode(n);
                graph.addEdge(new Edge(selectedNode, n));
            } else {
                if (selectedNode.getID() != isNode.getID())
                    graph.addEdge(new Edge(selectedNode, isNode));
            }
            selectedNode = null;
        }
    }

    /**
     * Utility function : return node on position x, y
     *
     * @param x position on x
     * @param y position on y
     * @return node or null
     */
    public Node isOnNode(int x, int y) {
        for (Node n : graph.getNodes()) {
            if (contains(n, x, y)) {
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
