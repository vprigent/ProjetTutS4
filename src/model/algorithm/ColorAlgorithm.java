package model.algorithm;

import model.Graph;
import model.Node;

import java.awt.*;
import java.util.Collection;
import java.util.Random;

public class ColorAlgorithm implements Algorithm {

    @Override
    public void Algorithm(Graph g) {
        Collection<Node> myNodes = g.getNodes();

        Color[] usualColors = {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.YELLOW, Color.MAGENTA};
        boolean[] usedColors = new boolean[6];

        int j = 0;
        boolean assigned = false;


        for (int i = 0; i < usedColors.length; i++) {
            usedColors[i] = false;
        }

        for (Node n : myNodes)
            n.setColor(Color.BLACK);

        for (Node n : myNodes) {
            for (Node neightbours : n.getNeighbours()) {
                for (int i = 0; i < usualColors.length; i++) {
                    if (neightbours.getColor() == usualColors[i]) {
                        usedColors[i] = true;
                    }
                }
            }

            while (j < usedColors.length && !assigned) {
                if (!usedColors[j]) {
                    n.setColor(usualColors[j]);
                    assigned = true;
                }
                j++;
            }

            if(n.getColor() == Color.BLACK) {
                Random rand = new Random();
                float r = rand.nextFloat();
                float gr = rand.nextFloat();
                float b = rand.nextFloat();

                usualColors[usualColors.length] = new Color(r,gr,b);
                usedColors[usualColors.length-1] = false;
            }

            assigned = false;
            j = 0;

            for (int i = 0; i < usedColors.length; i++) {
                usedColors[i] = false;
            }
        }

    }
}
