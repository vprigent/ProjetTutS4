package model.algorithm;

import java.util.ArrayList;
import java.util.Collection;

import model.Graph;
import model.Node;
import model.Shape;

public class CircleLayout extends Algorithm {

    @Override
    public void algorithm(Graph g) {
    	Collection<Node> myNodes = g.getNodes ();
    	
    	for (Node n : myNodes) {
    		n.setShape(Shape.CIRCLE);
    	}

    }
}
