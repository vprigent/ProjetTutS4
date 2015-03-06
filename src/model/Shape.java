package model;

public enum Shape {
    SQUARE,
    CIRCLE,
    ROUND,
    TRIANGLE;

    public static Shape fromString(String text) {
        if(text == "square") {
                return SQUARE;
        } else if (text == "circle") {
            return CIRCLE;
        } else if (text == "round") {
            return ROUND;
        } else if (text == "triangle") {
            return TRIANGLE;
        } else {
            return SQUARE;
        }
    }
}
