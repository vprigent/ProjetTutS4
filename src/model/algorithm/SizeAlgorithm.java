package model.algorithm;

import model.Graph;
import model.Node;

import java.util.Collection;

public class SizeAlgorithm implements IAlgorithm {
    /**
     * Affect a size for each Node in function of the number of the edges they have
     *
     * @param g
     */
    @Override
    public void Algorithm(Graph g) {
        Collection<Node> myNodes = g.getNodes();

        int range = 0;

        for (Node n : myNodes) {
            int nbNeighbours = n.getNeighbours().size();
            if (nbNeighbours > range) {
                range = nbNeighbours;
            }
        }

        int middleRange = range / 10 + 1;

        for (Node n : myNodes) {
            n.setSize(n.getNeighbours().size() / middleRange + 1);
        }
    }
}
