package controller;

import javafx.util.Pair;
import model.Edge;
import model.Graph;
import model.GraphHandler;
import model.Node;
import model.algorithm.*;
import view.MainFrame;

import java.util.ArrayList;
import java.util.Collection;

public class Controller {

    private GraphHandler graphHandler;

    private ArrayList<Node> selectedNodes;
    private ArrayList<Edge> selectedEdges;

    private ArrayList<Node> toPaste;

    private DrawingController drawingController;

    public MainFrame mainFrame;
    private UndoRedoManager undoRedoManager;

    /**
     * Constructor
     *
     * @param graphHandler graphHandler attached to the controller
     */
    public Controller(GraphHandler graphHandler) {
        this.graphHandler = graphHandler;
        this.selectedNodes = new ArrayList<Node>();
        this.selectedEdges = new ArrayList<Edge>();
        this.undoRedoManager = new UndoRedoManager();
        this.toPaste = new ArrayList<Node>();
    }

    /**
     * Add a drawing controller
     *
     * @return the drawingcontroller
     */
    public DrawingController addDrawingController() {
        drawingController = new DrawingController(graphHandler.getCurrentGraph(), undoRedoManager);
        drawingController.setSelectedNodes(selectedNodes);
        drawingController.setSelectedEdges(selectedEdges);
        drawingController.setMainFrame(mainFrame);
        drawingController.setToPaste(toPaste);
        return drawingController;
    }

    /**
     * Remove the selected edges
     */
    public void removeSelectedNodes() {

        ArrayList<?> actionList = new ArrayList<Object>();

        if (selectedNodes != null) {
            for (Node n : selectedNodes) {
                for (Edge e : graphHandler.getCurrentGraph().getEdges()) {
                    if (e.getDestination().getID() == n.getID() || e.getSource().getID() == n.getID()) {
                        selectedEdges.add(e);
                    }
                }
            }

            if (!selectedNodes.isEmpty())
                actionList.addAll((Collection) selectedNodes);
        }

        if (!selectedEdges.isEmpty()) {
            actionList.addAll((Collection) selectedEdges);
        }
        undoRedoManager.addAction(Action.REMOVEMULTIPLE, actionList);

        graphHandler.getEdges().removeAll(selectedEdges);
        graphHandler.getNodes().removeAll(selectedNodes);
    }

    /**
     * remove all the nodes and edges from the current graph
     */
    public void removeAll() {
        if (!graphHandler.getCurrentGraph().getEdges().isEmpty())
            undoRedoManager.addAction(Action.REMOVEMULTIPLE, graphHandler.getCurrentGraph().getEdges());
        if (!graphHandler.getCurrentGraph().getNodes().isEmpty())
            undoRedoManager.addAction(Action.REMOVEMULTIPLE, graphHandler.getCurrentGraph().getNodes());
        graphHandler.getCurrentGraph().removeAll();
    }

    /**
     * Apply a specific algorithm to the current graph
     *
     * @param value
     */
    public void applyAlgorithm(String value) {

        IAlgorithm algorithm = null;

        if (value.equals("Aleatoire")) {
            algorithm = new RandomLayout();
        } else if (value.equals("Aucun Algorithme")) {
            return;
        } else if (value.equals("Circulaire")) {
            algorithm = new CircleLayout();
        } else if (value.equals("Modele de force")) {
            System.err.println("Not implemented yet");
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

    public GraphHandler getGraphHandler() {
        return graphHandler;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void addGraph() {
        graphHandler.createNewGraph();
    }

    public void undo() {
        Graph graph = graphHandler.getCurrentGraph();
        Pair<Action, Object> undone = undoRedoManager.undo();
        if (undone == null)
            return;
        if (undone.getValue() instanceof ArrayList<?>) {
            for (Object obj : (ArrayList<Object>) undone.getValue()) {
                if (obj instanceof Node) {
                    if (undone.getKey() == Action.CREATE)
                        graph.removeNode((Node) obj);
                    if (undone.getKey() == Action.REMOVEMULTIPLE)
                        graph.addNode((Node) obj);
                } else if (obj instanceof Edge) {
                    if (undone.getKey() == Action.CREATE)
                        graph.removeEdge((Edge) obj);
                    if (undone.getKey() == Action.REMOVEMULTIPLE)
                        graph.addEdge((Edge) obj);
                }
            }
        } else {
            Object obj = undone.getValue();
            if (obj instanceof Node) {
                if (undone.getKey() == Action.CREATE)
                    graph.removeNode((Node) obj);
                if (undone.getKey() == Action.REMOVEMULTIPLE)
                    graph.addNode((Node) obj);
            } else if (obj instanceof Edge) {
                if (undone.getKey() == Action.CREATE)
                    graph.removeEdge((Edge) obj);
                if (undone.getKey() == Action.REMOVEMULTIPLE)
                    graph.addEdge((Edge) obj);
            }
        }
    }

    public void redo() {
        Graph graph = graphHandler.getCurrentGraph();
        Pair<Action, Object> undone = undoRedoManager.redo();
        if (undone == null)
            return;
        if (undone.getValue() instanceof ArrayList<?>) {
            for (Object obj : (ArrayList<Object>) undone.getValue()) {
                if (obj instanceof Node) {
                    if (undone.getKey() == Action.CREATE)
                        graph.addNode((Node) obj);
                    if (undone.getKey() == Action.REMOVEMULTIPLE)
                        graph.removeNode((Node) obj);
                } else if (obj instanceof Edge) {
                    if (undone.getKey() == Action.CREATE)
                        graph.addEdge((Edge) obj);
                    if (undone.getKey() == Action.REMOVEMULTIPLE)
                        graph.removeEdge((Edge) obj);
                }
            }
        } else {
            Object obj = undone.getValue();
            if (obj instanceof Node) {
                if (undone.getKey() == Action.CREATE)
                    graph.addNode((Node) obj);
                if (undone.getKey() == Action.REMOVEMULTIPLE)
                    graph.removeNode((Node) obj);
            } else if (obj instanceof Edge) {
                if (undone.getKey() == Action.CREATE)
                    graph.addEdge((Edge) obj);
                if (undone.getKey() == Action.REMOVEMULTIPLE)
                    graph.removeEdge((Edge) obj);
            }
        }
    }

    public void setToPaste(int action) {
        toPaste.addAll(this.selectedNodes);
        if (action == 1) {
        } else {
            for (Node n : toPaste) {
                graphHandler.getCurrentGraph().removeNode(n);
            }
        }
        drawingController.setToPaste(toPaste);
    }
}
