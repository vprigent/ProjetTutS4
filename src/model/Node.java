package model;

import java.awt.*;

public class Node {
    private int size;
    private int posX;
    private int posY;
    private String name;
    private Shape shape;
    private Color color = Color.BLACK;

    /**
     * Default constructor
     */
    public Node() {
        this.size = 1;
        this.posX = 0;
        this.posY = 0;
        this.name = "";
        this.shape = new Rectangle(posX, posY, size * 10, size * 10);
    }

    /**
     * Constructor
     *
     * @param size  size of the node
     * @param posX  position on x
     * @param posY  position on y
     * @param name  name of the node
     * @param shape shape of the node
     * @param color color of the node
     */
    public Node(int size, int posX, int posY, String name, Shape shape, Color color) {
        this.size = size;
        this.posX = posX;
        this.posY = posY;
        this.name = name;
        this.shape = shape;
        this.color = color;
    }

    /**
     * @param shape the shape to set
     */
    public void setForme(Shape shape) {
        this.shape = shape;
    }

    /**
     * @param x new value on x
     * @param y new value on y
     */
    public void setPosition(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    /**
     * @return size of the node
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return position on x
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return position on y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @return color of the node
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
     * @return shape of the node
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * @return name of the node
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Debugging function
     */
    @Override
    public String toString() {
        return "Node{" +
                "size=" + size +
                ", posX=" + posX +
                ", posY=" + posY +
                ", name='" + name + '\'' +
                ", shape=" + shape +
                ", color=" + color +
                '}' + "\n";
    }
}
