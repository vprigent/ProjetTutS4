package model.fileManager;

import model.Edge;
import model.Graph;
import model.Node;
import model.Shape;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class GraphvisTest {

    Graphvis filemanager;
    Graph g;

    @Before
    public void initialiseState() {
        g = new Graph();
        filemanager = new Graphvis();

        filemanager.loadGraph("tests/graphvis.dot");
    }


    @Test
    public void testRegexData() throws Exception {
        String g = "digraph threeWay { a -> b ; b -> c ; c -> a } \n" +
                "digraph test2 { a -> c; b -> c; c -> b; c -> a}";

        String[] temp = g.split("[\\{*\\}]");


        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i].trim();
        }

        assertEquals("a -> b ; b -> c ; c -> a", temp[1]);

        assertEquals("a -> c; b -> c; c -> b; c -> a", temp[3]);
    }

    @Test
    public void testSaveGraph() throws Exception {
        Node n = new Node();
        g.addNode(n);
        Node nd = new Node(2, 2, 3, "Hello", Shape.CIRCLE, Color.BLUE);
        g.addNode(nd);
        g.addEdge(new Edge(n, nd));

        filemanager.saveGraph(g, "test.dot");
    }
}