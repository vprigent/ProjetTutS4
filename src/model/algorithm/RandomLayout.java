package model.algorithm;

import model.Graph;
import model.Node;
import model.Shape;

import java.awt.*;
import java.util.Collection;

public class RandomLayout implements Algorithm {

    @Override
    public void Algorithm(Graph g) {
        Collection<Node> myNodes = g.getNodes();

        for (Node n : myNodes) {
            int r = 1 + (int) (Math.random() * (255 - 1) + 1);
            int v = 1 + (int) (Math.random() * (255 - 1) + 1);
            int b = 1 + (int) (Math.random() * (255 - 1) + 1);
            n.setColor(new Color(r, v, b));

            int x = 1 + (int) (Math.random() * (800 - 1) + 1);
            int y = 1 + (int) (Math.random() * (600 - 1) + 1);
            n.setPosition(x, y);

            int sh = 1 + (int) (Math.random() * (3) + 1);
            switch (sh) {
                case 1:
                    n.setShape(Shape.SQUARE);
                    break;
                case 2:
                    n.setShape(Shape.CIRCLE);
                    break;
                case 3:
                    n.setShape(Shape.TRIANGLE);
                    break;
                default:
                    n.setShape(Shape.SQUARE);
                    break;
            }

            int size = 1 + (int) (Math.random() * (5) + 1);
            n.setSize(size);
        }

    }
}
