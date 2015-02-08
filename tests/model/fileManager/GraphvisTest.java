package model.fileManager;

import model.Edge;
import model.Graph;
import model.Node;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class GraphvisTest {

    Graphvis filemanager;
    Graph g;

    @Before
    public void initialiseState() {
        g = new Graph();
        filemanager = new Graphvis();
        g.addNode(new Node(1,1,1,"a", new Rectangle(), Color.BLUE));
        g.addNode(new Node(1,1,1,"b", new Rectangle(), Color.BLUE));
        g.addEdge(new Edge(g.getNode("a"), g.getNode("b")));
        g.addNode(new Node(1,1,1,"c", new Rectangle(), Color.BLUE));
        g.addEdge(new Edge(g.getNode("b"), g.getNode("c")));
        g.addEdge(new Edge(g.getNode("c"), g.getNode("a")));
    }

    @Test
    public void testLoadGraph() throws Exception {
        String graph = "digraph threeWay { a -> b ; b -> c ; c -> a }";
        assertEquals(filemanager.createGraphFromData(graph), g);
    }

    @Test
    public void testSaveGraph() throws Exception {

    }
}