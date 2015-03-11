package controller;

import model.Graph;
import model.Node;
import model.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingController {

    private Graph graph;

    private ArrayList<Node> selectedNodes;

    public DrawingController(Graph graph) {
        this.graph = graph;
    }

    public void mainPanelMouseClicked(MouseEvent evt) {

        int x = evt.getX();
        int y = evt.getY();

        if (!evt.isControlDown())
            selectedNodes.clear();

        for (Node n : graph.getNodes()) {
            if (n.contains(x, y)) {
                selectedNodes.add(n);
            }
        }

        if (selectedNodes.isEmpty()) {
            graph.addNode(new Node(25, x, y, "name", Shape.SQUARE, Color.BLACK));
        }
    }

    public void setSelectedNodes(ArrayList<Node> selectedNodes) {
        this.selectedNodes = selectedNodes;
    }

    public Graph getGraph() {
        return graph;
    }

    public ArrayList<Node> getSelectedNodes() {
        return selectedNodes;
    }
}
