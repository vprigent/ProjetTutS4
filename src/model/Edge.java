package model;

import java.awt.*;

/**
 * NB : source and destination node are
 */

public class Edge {
    public final int maxSize = 10;

    private int size;
    private String label;
    private Color color;

    private Node source;
    private Node destination;

    private boolean isOriented = false;

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

    /**
     *
     * Constructor
     *
     * @param source node source
     * @param destination node destination
     * @param isOriented if the edge is oriented, ie source and destination are importants
     * @param color the color of the edge
     * @param label label of the edge, informations attached
     * @param size size of the edge
     */
    public Edge(Node source, Node destination, boolean isOriented, Color color, String label, int size) {
        this.source = source;
        this.destination = destination;
        this.isOriented = isOriented;
        this.color = color;
        this.label = label;
        if(size > maxSize)
            size = maxSize;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        if(this.size <= maxSize) this.size = size;
    }

    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
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

    public void changeNode(Node source, Node destination) {
        if(source != null)
            this.source = source;

        if (destination != null)
            this.destination = destination;
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
                '}' + "\n";
    }
}
