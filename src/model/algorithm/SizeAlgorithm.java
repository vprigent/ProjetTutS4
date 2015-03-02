package model.algorithm;

import java.util.ArrayList;
import java.util.Vector;

import model.Graph;
import model.Node;

public class SizeAlgorithm extends Algorithm{

    @Override
    public void algorithm(Graph g) {
		Vector<Node> myNodes = g.getNodes();

		int nbNodes=0;
		for (Node n : myNodes)
			nbNodes++;
		
		int minValue=-1;
		int nextMin=1000001;
		
		for (int i = 1; i <= myNodes.size(); i++) {
			for (Node n : myNodes) {
				if (n.getValue()>minValue)
				{
					n.setSize(10/(nbNodes-i));
					
					if (n.getValue()<=nextMin) {
						nextMin=n.getValue();
					}
				}
			}
			minValue=nextMin;
			nextMin=1000001;
		}
    }
}
