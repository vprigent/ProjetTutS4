package modelTests;

import model.Graph;
import model.Node;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    Graph g = new Graph();

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testLoadGraph() throws Exception {

    }

    @Test
    public void testApplyAlgorithm() throws Exception {

    }

    @Test
    public void testMoveNode() throws Exception {

    }

    @Test
    public void testAddNode() throws Exception {

    }

    @Test
    public void testAddEdge() throws Exception {

    }

    @Test
    public void testRemoveNode() throws Exception {
        Node n = new Node();
        g.addNode(n);
        assertEquals(g.getNodes().size(), 1);
        g.removeNode(n);
        assertEquals(g.getNodes().size(), 0);
    }

    @Test
    public void testRemoveEdge() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

    }
}