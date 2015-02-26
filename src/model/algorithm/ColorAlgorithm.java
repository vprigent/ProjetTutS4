package model.algorithm;

import java.awt.Color;
import java.util.ArrayList;

import model.Graph;
import model.Node;
import model.Shape;

public class ColorAlgorithm extends Algorithm {

	@Override
	public void algorithm(Graph g) {
		ArrayList<Node> myNodes = g.getNodes();

		int minValue=-1;
		int nextMin=1000001;
		
		for (int i = 1; i <= myNodes.size(); i++) {
			for (Node n : myNodes) {
				if (n.getValue()>minValue)
				{
					n.setColor(new Color(255/i,0,0));
					
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
