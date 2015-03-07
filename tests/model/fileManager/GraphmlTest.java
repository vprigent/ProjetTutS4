package model.fileManager;

import model.Edge;
import model.Graph;
import model.Node;
import model.Shape;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class GraphmlTest {

    Graphml fileManager;
    Graph g;

    @Before
    public void initialiseState() {
        g = new Graph();
        fileManager = new Graphml();
    }

    @Test
    public void testSaveGraph() throws Exception {
        Node n = new Node();
        g.addNode(n);
        Node nd = new Node(2, 2, 3, "Hello", Shape.CIRCLE, Color.BLUE);
        g.addNode(nd);
        g.addEdge(new Edge(n, nd));

        fileManager.saveGraph(g, "test.graphml");

    }
}