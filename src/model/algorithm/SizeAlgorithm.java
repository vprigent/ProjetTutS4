package model.algorithm;

import java.util.Collection;

import model.Graph;
import model.Node;

public class SizeAlgorithm implements Algorithm{

    @Override
    public void Algorithm(Graph g) {
		Collection<Node> myNodes = g.getNodes();

		int range = 0;

        for(Node n : myNodes) {
            int nbNeighbours = n.getNeighbours().size();
            if(nbNeighbours > range) {
                range = nbNeighbours;
            }
        }

        int middleRange = range/10+1;

        for(Node n : myNodes) {
            n.setSize(n.getNeighbours().size()/middleRange+1);
        }
    }
}
