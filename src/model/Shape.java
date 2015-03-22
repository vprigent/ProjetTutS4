package model;
/**
 * Enum used to set the shape to a Node
 */
public enum Shape {
    SQUARE,
    CIRCLE,
    TRIANGLE;

    /**
     *
     * @param text
     * @return the shape to set
     */
    public static Shape fromString(String text) {
        if(text == "square") {
                return SQUARE;
        } else if (text == "circle") {
            return CIRCLE;
        } else if (text == "triangle") {
            return TRIANGLE;
        } else {
            return SQUARE;
        }
    }
}
