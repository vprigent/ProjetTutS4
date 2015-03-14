package model;

import java.awt.*;

public class Node {
    public static final int maxSize = 10;

    public static final int maxPosition = 2000;

    private static int maxID = 0;

    private int id;
    private int value;
    private int size;
    private int posX;
    private int posY;
    private String name;
    private Color color = Color.BLACK;
    private Shape shape = Shape.SQUARE;

    /**
     * Default constructor
     */
    public Node() {
        this.value = 1;
        this.size = 1;
        this.posX = 0;
        this.posY = 0;
        this.name = "";
        this.id = Node.maxID;
        Node.maxID++;
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
        if (size > maxSize)
            size = maxSize;
        this.size = size;

        if (posX + getSize() > maxPosition)
            posX = maxPosition;
        this.posX = posX;

        if (posY + getSize() > maxPosition)
            posY = maxPosition;
        this.posY = posY;

        this.name = name;
        this.shape = shape;
        this.color = color;
        this.id = Node.maxID;
        Node.maxID++;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(Shape shape) {

        this.shape = shape;
    }

    /**
     * @param x new value on x
     * @param y new value on y
     */
    public void setPosition(int x, int y) {
        if (x + getSize() > maxPosition) x = maxPosition;
        if (y + getSize() > maxPosition) y = maxPosition;
        this.posX = x;
        this.posY = y;
    }

    /**
     * @return value of the node
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
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
        if (size > maxSize) size = maxSize;
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
     * @return default color of a node
     */
    public static Color getDefaultColor() {
        return Color.BLACK;
    }

    /**
     * @return default shape of a node
     */
    public static Shape getDefaultShape() {
        return Shape.SQUARE;
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
     * @return id of the node
     */
    public int getID() {
        return id;
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
                "id=" + id +
                ", size=" + size +
                ", posX=" + posX +
                ", posY=" + posY +
                ", name='" + name + '\'' +
                ", shape=" + shape +
                ", color=" + color +
                '}' + "\n";
    }
}
