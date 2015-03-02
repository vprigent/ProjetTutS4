package model.algorithm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import model.Graph;
import model.Node;
import model.Shape;

public class RandomLayout extends Algorithm {

    @Override
    public void algorithm(Graph g) {
        Collection<Node> myNodes = g.getNodes();
        
        for (Node n : myNodes) {
        	int r = 1 + (int)(Math.random()*(255-1)+1);
        	int v = 1 + (int)(Math.random()*(255-1)+1);
        	int b = 1 + (int)(Math.random()*(255-1)+1);
        	n.setColor(new Color(r,v,b));
        	
        	int x = 1 + (int)(Math.random()*(800-1)+1);
        	int y = 1 + (int)(Math.random()*(600-1)+1);
            n.setPosition(x, y);
            
            int sh = 1 + (int)(Math.random()*(600-1)+1);
            switch (sh) {
            case 1 :
            	n.setShape(Shape.SQUARE);
            	break;
            case 2 :
            	n.setShape(Shape.CIRCLE);
            	break;
            case 3 :
            	n.setShape(Shape.ROUND);
            	break;
            case 4 :
            	n.setShape(Shape.TRIANGLE);
            	break;
            }
            
            int size = 1 + (int)(Math.random()*(4-1)+1);
            n.setSize(size);
        }

    }
}
