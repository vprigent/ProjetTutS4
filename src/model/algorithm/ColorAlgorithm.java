package model.algorithm;

import model.Graph;
import model.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ColorAlgorithm implements IAlgorithm {
    /**
     * Apply the Color algorithm to a specific graph
     *
     * @param g
     */
    @Override
    public void Algorithm(Graph g) {
        Collection<Node> myNodes = g.getNodes();

        ArrayList<Color> usualColors = new ArrayList<Color>();
        usualColors.add(Color.BLUE);
        usualColors.add(Color.RED);
        usualColors.add(Color.GREEN);
        usualColors.add(Color.CYAN);
        usualColors.add(Color.YELLOW);
        usualColors.add(Color.MAGENTA);

        ArrayList<Boolean> usedColors = new ArrayList<Boolean>(usualColors.size());

        int j = 0;
        boolean assigned = false;


        for (int i = 0; i < usedColors.size(); i++) {
            usedColors.set(i, false);
        }

        for (Node n : myNodes)
            n.setColor(Color.BLACK);

        for (Node n : myNodes) {
            for (Node neightbours : n.getNeighbours()) {
                for (int i = 0; i < usualColors.size(); i++) {
                    if (neightbours.getColor() == usualColors.get(i)) {
                        usedColors.set(i, true);
                    }
                }
            }

            while (j < usedColors.size() && !assigned) {
                if (!usedColors.get(j)) {
                    n.setColor(usualColors.get(j));
                    assigned = true;
                }
                j++;
            }

            if (n.getColor() == Color.BLACK) {
                Random rand = new Random();
                float r = rand.nextFloat();
                float gr = rand.nextFloat();
                float b = rand.nextFloat();

                usualColors.add(new Color(r, gr, b));
                usedColors.add(false);
            }

            assigned = false;
            j = 0;

            for (int i = 0; i < usedColors.size(); i++) {
                usedColors.set(i, false);
            }
        }

    }
}
