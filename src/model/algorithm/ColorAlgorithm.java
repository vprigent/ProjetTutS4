package model.algorithm;

import model.Graph;
import model.Node;

import java.awt.*;
import java.util.Collection;

public class ColorAlgorithm implements Algorithm {

    @Override
    public void Algorithm(Graph g) {
        Collection<Node> myNodes = g.getNodes();

        int nbNodes = myNodes.size();
        for(Node n : myNodes)
            n.setColor(Color.BLACK);



    }
}
