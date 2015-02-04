package modelTests;

import model.Graph;
import model.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    protected Graph g;

    @Before
    public void setUp() throws Exception {
        g = new Graph();
    }

    @After
    public void tearDown() throws Exception {
        g.getNodes().clear();
        g.getEdges().clear();
    }

    @Test
    public void testLoadGraph() throws Exception {

    }

    @Test
    public void testApplyAlgorithm() throws Exception {

    }

    @Test
    public void testMoveNode() throws Exception {
        Node n = new Node();
        g.addNode(n);
        g.moveNode(n, 1,5);
        assertEquals(g.getNodes().get(0).getPosX(), 1);
        assertEquals(g.getNodes().get(0).getPosY(), 5);
    }

    @Test
    public void testAddNode() throws Exception {
        Node n = new Node();
        g.addNode(n);
        assertEquals(g.getNodes().size(), 1);
        n = new Node();
        g.addNode(n);
        assertEquals(g.getNodes().size(), 2);
        assertTrue(g.getNodes().get(0) != n);

        for(int i = 0 ; i < 10000; i++) {
            g.addNode(new Node());
        }

        assertEquals(g.getNodes().size(), 10002);


    }

    @Test
    public void testAddEdge() throws Exception {


    }

    @Test
    public void testRemoveNode() throws Exception {
        Node n = new Node();

        g.addNode(n);
        assertEquals(g.getNodes().size(), 1);
        assertTrue(g.getNodes().get(0) == n);
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