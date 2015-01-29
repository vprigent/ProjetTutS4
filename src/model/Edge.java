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

    private boolean isOriented = false; // il est possible d'optimiser ça en rendant les attributs source et destination utiles pour savoir vers quoi est orienté l'arc.

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

    public Edge(Node source, Node destination, boolean isOriented, Color color, String label, int size) {
        this.source = source;
        this.destination = destination;
        this.isOriented = isOriented;
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

    public boolean isOriented() {
        return isOriented;
    }

    public void setOriented(boolean isOriented) {
        this.isOriented = isOriented;
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

    /**
     * Allow to switch the source and destination node when the graph become oriented and the actual source become the destination
     */
    public void switchOrientationNode() {
        Node temp = source;
        source = destination;
        destination = temp;
    }

    /**
     * Debugging function
     */
    @Override
    public String toString() {
        return "Edge{" +
                "size=" + size +
                ", label='" + label + '\'' +
                ", color=" + color +
                ", source=" + source +
                ", destination=" + destination +
                ", isOriented=" + isOriented +
                '}'+"\n";
    }
}
