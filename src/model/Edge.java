package model;

import java.awt.*;

/**
 * NB : source and destination node are
 */

public class Edge {
    public final int maxWeight = 10;

    private int weight;
    private String label;
    private Color color = Color.BLACK;

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
        this.weight = 1;
        this.label = "";
        this.color = Color.black;
        this.source = source;
        this.destination = destination;
        source.addNeighbour(destination);
        destination.addNeighbour(source);
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
     * @param weight weight of the edge
     */
    public Edge(Node source, Node destination, boolean isOriented, Color color, String label, int weight) {
        this.source = source;
        this.destination = destination;
        this.isOriented = isOriented;
        this.color = color;
        this.label = label;
        if(weight > maxWeight)
            weight = maxWeight;
        this.weight = weight;
        source.addNeighbour(destination);
        destination.addNeighbour(source);
    }

    public int getweight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setweight(int weight) {
        if(this.weight <= maxWeight) this.weight = weight;
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

    /**
     * @return color of the edge
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return default color of edges
     */
    public static Color getDefaultColor() {
        return Color.BLACK;
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
                "weight=" + weight +
                ", label='" + label + '\'' +
                ", color=" + color +
                ", source=" + source +
                ", destination=" + destination +
                ", isOriented=" + isOriented +
                '}' + "\n";
    }
}
