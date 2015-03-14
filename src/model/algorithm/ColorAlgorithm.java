package model.algorithm;

import java.awt.Color;
import java.util.Collection;

import model.Graph;
import model.Node;

public class ColorAlgorithm extends Algorithm {

	@Override
	public void Algorithm(Graph g) {
		Collection<Node> myNodes = g.getNodes();
		
		
		int nbNodes=myNodes.size();
		int minValue=-1;
		int nextMin=1000001;
		
		for (int i = 0; i < nbNodes; i++) {
			for (Node n : myNodes) {
				if (n.getValue()>minValue)
				{
					n.setColor(new Color(255/(nbNodes-i),0,0));
					
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
