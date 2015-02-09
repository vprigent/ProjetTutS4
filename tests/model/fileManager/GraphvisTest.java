package model.fileManager;

import model.Edge;
import model.Graph;
import model.Node;
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
        g.addNode(new Node(1, 1, 1, "a", new Rectangle(), Color.BLUE));
        g.addNode(new Node(1, 1, 1, "b", new Rectangle(), Color.BLUE));
        g.addEdge(new Edge(g.getNode("a"), g.getNode("b")));
        g.addNode(new Node(1, 1, 1, "c", new Rectangle(), Color.BLUE));
        g.addEdge(new Edge(g.getNode("b"), g.getNode("c")));
        g.addEdge(new Edge(g.getNode("c"), g.getNode("a")));
    }

    @Test
    public void testLoadGraph() throws Exception {
        String graph = "digraph threeWay { a -> b ; b -> c ; c -> a }";
        //assertEquals(filemanager.createGraphFromData(graph), g);
    }

    @Test
    public void testExtractDatasFromLine() throws Exception {
        String node = "a -> b";

        // Test graph, expected
        Graph expected = new Graph();
        Node a = new Node();
        a.setName("a");
        Node b = new Node();
        b.setName("b");
        expected.addNode(a);
        expected.addNode(b);
        expected.addEdge(new Edge(a, b, true));

        Graph actual = new Graph();
        filemanager.extractDatasFromLine(node, actual);

        assertEquals(a, actual.getNode("a"));
        assertEquals(b, actual.getNode("b"));
        assertEquals(expected.getEdges().get(0), actual.getEdges().get(0));

    }

    @Test
    public void testRegexData() throws Exception {
        String g = "digraph threeWay { a -> b ; b -> c ; c -> a } " +
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

    }
}