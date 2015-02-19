package model.algorithm;

import java.util.ArrayList;

import model.Graph;
import model.Node;
import model.Shape;

public class SizeAlgorithm extends Algorithm{

    @Override
    public void algorithm(Graph g) {
    	ArrayList<Node> myNodes = g.getNodes ();
    	
    	for (Node n : myNodes) {
    		n.setSize(3);
    	}
    }
}
