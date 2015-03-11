package controller;

import model.GraphHandler;
import model.Node;

import java.util.ArrayList;

public class Controller {

    private GraphHandler graphHandler;
    private ArrayList<Node> selectedNodes;
    private DrawingController drawingController;

    public Controller(GraphHandler graphHandler) {
        this.graphHandler = graphHandler;
        this.selectedNodes = new ArrayList<Node>();
    }

    public ArrayList<Node> getSelectedNodes() {
        return selectedNodes;
    }

    public DrawingController addDrawingController() {
        drawingController = new DrawingController(graphHandler.getCurrentGraph());
        drawingController.setSelectedNodes(selectedNodes);
        return drawingController;
    }

    public void removeSelectedNodes() {
        if (selectedNodes != null) {
            for (Node n : selectedNodes)
                graphHandler.getNodes().remove(n);
        }
    }

    public void removeAllNodes() {
        graphHandler.getCurrentGraph().getEdges().clear();
        graphHandler.getCurrentGraph().getNodes().clear();
    }
}
