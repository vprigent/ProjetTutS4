package model.algorithm;

import java.awt.Color;
import java.util.ArrayList;

import model.Graph;
import model.Node;
import model.Shape;

public class ColorAlgorithm extends Algorithm {

    @Override
    public void algorithm(Graph g) {
    	ArrayList<Node> myNodes = g.getNodes ();
    	
    	for (Node n : myNodes) {
    		n.setColor(Color.BLUE);
    	}

    }
}
