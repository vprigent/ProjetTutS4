package model;

import java.awt.*;

/**
 * NB : source and destination node are
 */

public class Edge {
    private int size;
    private String label;
    private Color color;

    private Node source;
    private Node destination;

    private boolean isOrientedToSource = false; // il est possible d'optimiser ça en rendant les attributs source et destination utiles pour savoir vers quoi est orienté l'arc.
    private boolean isOrientedToDestination = false;

    /**
     * Default constructor
     *
     * @param source      Define the source node
     * @param destination Define the destination node
     */
    public Edge(Node source, Node destination) {
        this.size = 1;
        this.label = "";
        this.color = Color.black;
        this.source = source;
        this.destination = destination;
    }

    public Edge(Node source, Node destination, boolean isOrientedToSource, boolean isOrientedToDestination, Color color, String label, int size) {
        this.source = source;
        this.destination = destination;
        this.isOrientedToDestination = isOrientedToDestination;
        this.isOrientedToSource = isOrientedToSource;
        this.color = color;
        this.label = label;
        this.size = size;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public int getSize() {
        return size;
    }

    public String getLabel() {
        return label;
    }

    public Color getColor() {
        return color;
    }

    public boolean isOrientedToSource() {
        return isOrientedToSource;
    }

    public void setOrientedToSource(boolean isOrientedToSource) {
        this.isOrientedToSource = isOrientedToSource;
    }

    /**
     * @return Destination node
     */
    public Node getDestination() {
        return destination;
    }

    /**
     * @return Source node
     */
    public Node getSource() {
        return source;
    }

    public void switchOrientationNode() {
        Node temp = source;
        source = destination;
        destination = temp;
    }
}
