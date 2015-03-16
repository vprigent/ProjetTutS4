package controller;

import model.Edge;
import model.GraphHandler;
import model.Node;
import model.algorithm.*;

import java.util.ArrayList;

public class Controller {

    private GraphHandler graphHandler;
    private ArrayList<Node> selectedNodes;
    private ArrayList<Edge> selectedEdges;
    private DrawingController drawingController;


    public Controller(GraphHandler graphHandler) {
        this.graphHandler = graphHandler;
        this.selectedNodes = new ArrayList<Node>();
        this.selectedEdges = new ArrayList<Edge>();
    }

    public DrawingController addDrawingController() {
        drawingController = new DrawingController(graphHandler.getCurrentGraph());
        drawingController.setSelectedNodes(selectedNodes);
        drawingController.setSelectedEdges(selectedEdges);
        return drawingController;
    }

    public void removeSelectedNodes() {
        if (selectedNodes != null) {
            for (Node n : selectedNodes) {
                for (Edge e : graphHandler.getCurrentGraph().getEdges()) {
                    if (e.getDestination().getID() == n.getID() || e.getSource().getID() == n.getID()) {
                        selectedEdges.add(e);
                    }
                }

                graphHandler.getNodes().remove(n);
            }
        }
        if (selectedEdges != null) {
            for (Edge e : selectedEdges) {
                graphHandler.getEdges().remove(e);
            }
        }
    }

    public void removeAllNodes() {
        graphHandler.getCurrentGraph().getEdges().clear();
        graphHandler.getCurrentGraph().getNodes().clear();
    }

    public void applyAlgorithm(String value) {

        Algorithm algorithm = null;

        if (value.equals("Aleatoire")) {
            algorithm = new RandomLayout();
        } else if (value.equals("Aucun Algorithme")) {
            return;
        } else if (value.equals("Circulaire")) {
            algorithm = new CircleLayout();
        } else if (value.equals("Modele de force")) {
        } else if (value.equals("Colorisation")) {
            algorithm = new ColorAlgorithm();
        } else if (value.equals("Calcul d'indice")) {
            algorithm = new IndexAlgorithm();
        } else if (value.equals("Taille")) {
            algorithm = new SizeAlgorithm();
        } else if (value.equals("Personnalisé")) {
            algorithm = new PersonnalAlgorithm();
        } else {
            return;
        }

        graphHandler.getCurrentGraph().applyAlgorithm(algorithm);

    }

}
