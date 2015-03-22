package controller;

import model.Edge;
import model.Graph;
import model.Node;
import model.Shape;
import view.DrawingPanel;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingController {

    private Graph graph;

    public MainFrame mainFrame;

    private ArrayList<Node> selectedNodes;
    private ArrayList<Edge> selectedEdges;

    private UndoRedoManager undoRedoManager;

    private Node selectedNode = null;
    private int old_x;
    private int old_y;

    public DrawingController(Graph graph, UndoRedoManager undoRedoManager) {
        this.graph = graph;
        this.undoRedoManager = undoRedoManager;
    }

    /**
     * treat mouse click event on DrawingPanel
     *
     * @param evt mouse event
     */
    public void mainPanelMouseClicked(MouseEvent evt) {
        boolean newnode = false;
        boolean found = false;
        selectedNode = null;
        int x = evt.getX();
        int y = evt.getY();
        double scale = mainFrame.getDrawingPanel().getScale();

        if (SwingUtilities.isRightMouseButton(evt)) {
            for (Node n : graph.getNodes()) {
                if (contains(n, x, y)) {
                    mainFrame.createDialogNode(n);
                }
            }
            for (Edge e : graph.getEdges()) {
                if (EdgeContain(e, x, y)) {
                    mainFrame.createDialogEdge(e);//size don't work
                }
            }
            selectedNodes.clear();
            selectedEdges.clear();
        } else {

            if (!evt.isControlDown()) {
                selectedNodes.clear();
                selectedEdges.clear();
            }

            int i = 0;

            while (!found && i < graph.getNodes().size()) {
                Node n = graph.getNodes().get(i);
                if (contains(n, x, y)) {
                    if (selectedNodes.contains(n)) {
                        selectedNodes.remove(n);
                    } else {
                        selectedNodes.add(n);
                        found = true;
                    }
                }
                i++;
            }

            for (Edge e : graph.getEdges()) {
                if (EdgeContain(e, x, y)) {
                    selectedEdges.add(e);
                    newnode = true;
                }
            }
            if (selectedNodes.isEmpty() && !newnode) {
                System.out.println("ha");
                graph.addNode(new Node(1, (int)(x*(1/scale)), (int)(y*(1/scale)), "name", Shape.SQUARE, Color.BLACK));
                undoRedoManager.addAction(Action.CREATE, graph.getNodes().get(graph.getNodes().size() - 1));
            }
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public void mainPanelMousePressed(MouseEvent evt) {

        boolean found = false;
        old_x = evt.getX();
        old_y = evt.getY();

        for (Node n : graph.getNodes()) {
            if (contains(n, old_x, old_y) && !found) {
                selectedNode = n;
                found = true;
            }
        }
    }


    /**
     * Hitbox function for node
     *
     * @param mouseX position on x
     * @param mouseY position on y
     * @return true if the node is in this position
     */
    public boolean contains(Node n, int mouseX, int mouseY) {
        double scale = mainFrame.getDrawingPanel().getScale();
        Rectangle hitbox = new Rectangle((int)(n.getPosX()*scale), (int)(n.getPosY()*scale), n.getSize() * DrawingPanel.defaultSize, n.getSize() * DrawingPanel.defaultSize);

        return hitbox.contains(mouseX + n.getSize() * DrawingPanel.defaultSize / 2, mouseY + n.getSize() * DrawingPanel.defaultSize / 2);
    }

    /**
     * Hitbox function for zone
     *
     * @param mouseX position on x
     * @param mouseY position on y
     * @return true if the zone contains n
     */
    public boolean containsNode(Node n,int mouseX,int mouseY) {

        int x = Math.min(old_x, mouseX);
        int y = Math.min(old_y, mouseY);
        int width = Math.max(old_x -mouseX, mouseX - old_x);
        int height = Math.max(old_y - mouseY,mouseY   - old_y);
        Rectangle selectionBounds = new Rectangle(x, y, width, height);

        return selectionBounds.contains(n.getPosX(),n.getPosY());
    }

    /**
     * Hitbox function for edges
     * @param e edge to test
     * @param mouseX position on x
     * @param mouseY position on y
     * @return true if the mouse is close or on the edge
     */
    public boolean EdgeContain(Edge e, int mouseX, int mouseY) {
        Polygon p = new Polygon();

        p.addPoint(e.getSource().getPosX() + e.getSource().getSize(), e.getSource().getPosY() + e.getSource().getSize());
        p.addPoint(e.getSource().getPosX() - e.getSource().getSize(), e.getSource().getPosY() - e.getSource().getSize());
        p.addPoint(e.getDestination().getPosX() + e.getDestination().getSize(), e.getDestination().getPosY() + e.getDestination().getSize());
        p.addPoint(e.getDestination().getPosX() - e.getDestination().getSize(), e.getDestination().getPosY() - e.getDestination().getSize());

        return (p.intersects(mouseX, mouseY, 4, 4));
    }

    public void mainPanelMouseReleased(MouseEvent evt) {

        double scale = mainFrame.getDrawingPanel().getScale();

        if (selectedNode != null && selectedNodes.size() == 0) {
            Node isNode = isOnNode(evt.getX(), evt.getY());
            if (isNode == null) {
                Node n = new Node(1,(int)(evt.getX()*(1/scale)), (int)(evt.getY()*(1/scale)), "name", Shape.SQUARE, Color.BLACK);
                graph.addNode(n);
                undoRedoManager.addAction(Action.CREATE, n);
                graph.addEdge(new Edge(selectedNode, n));
                undoRedoManager.addAction(Action.CREATE, graph.getEdges().get(graph.getEdges().size() - 1));
            } else {
                if (selectedNode.getID() != isNode.getID()) {
                    graph.addEdge(new Edge(selectedNode, isNode));
                    undoRedoManager.addAction(Action.CREATE, graph.getEdges().get(graph.getEdges().size() - 1));
                }
            }
            selectedNode = null;
        } else if (!selectedNodes.isEmpty()) {
            int moveOnX = evt.getX() - old_x;
            int moveOnY = evt.getY() - old_y;
            for (Node n : selectedNodes) {
                n.setPosition((int) (n.getPosX() + moveOnX*(1/scale)), (int) (n.getPosY() + moveOnY*(1/scale)));
            }
        }
        else
        {
            for (Node n : graph.getNodes())
            {
                if(containsNode(n,evt.getX(),evt.getY()))
                {
                    selectedNodes.add(n);
                }
            }
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

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

}
