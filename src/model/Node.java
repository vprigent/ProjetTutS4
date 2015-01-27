package model;

import java.awt.*;

public class Node {
    private int size;
    private int posX;
    private int posY;
    private String name;
    private Shape shape;
    private Color color;

    /**
     * Default constructor
     */
    public Node() {

    }

    public void drawNode() {
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @param shape the shape to set
     */
    public void setForme(Shape shape) {
        this.shape = shape;
    }

}
