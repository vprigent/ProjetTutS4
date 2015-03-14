package model.algorithm;

import model.Graph;
import model.Node;

import java.util.ArrayList;
import java.util.Random;

public class CircleLayout implements Algorithm {

    @Override
    public void Algorithm(Graph g) {
        ArrayList<Node> myNodes = g.getNodes();
        int radius = ((myNodes.size()/50)+1)*100;
        int center = 300;
        int i = 0;
        double x, y;
        double slice = 2 * Math.PI / myNodes.size();
        double angle;

        for (Node n : myNodes) {
            angle = slice * i;
            x = radius*Math.cos(angle) + center;
            y = radius*Math.sin(angle) + center;
            i++;

            n.setPosition((int)x, (int)y);
        }

    }
}
