package model;

import java.awt.*;


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
     * Constructor
     *
     * @param source      node source
     * @param destination node destination
     * @param isOriented  if the edge is oriented, ie source and destination are importants
     * @param color       the color of the edge
     * @param label       label of the edge, informations attached
     * @param weight      weight of the edge
     */
    public Edge(Node source, Node destination, boolean isOriented, Color color, String label, int weight) {
        this.source = source;
        this.destination = destination;
        this.isOriented = isOriented;
        this.color = color;
        this.label = label;
        if (weight > maxWeight)
            weight = maxWeight;
        this.weight = weight;
        source.addNeighbour(destination);
        destination.addNeighbour(source);
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
     * @param source      new source node
     * @param destination new destination node
     */
    public void changeNode(Node source, Node destination) {
        if (source != null)
            this.source = source;

        if (destination != null)
            this.destination = destination;
    }

    /**
     * @return weight of the edge
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        if (this.weight <= maxWeight) this.weight = weight;
    }

    /**
     * @return label of the edge
     */
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
     * @return default color of edges
     */
    public static Color getDefaultColor() {
        return Color.BLACK;
    }

    /**
     * @return color of the edge
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return true if the edge is oriented
     */
    public boolean isOriented() {
        return isOriented;
    }

    /**
     * @param isOriented new value of orientation
     */
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
