package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

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
        ArrayList<Node> nodes = g.getNodes();
        assertEquals(nodes.get(0).getPosX(), 1);
        assertEquals(nodes.get(0).getPosY(), 5);
    }

    @Test
    public void testAddNode() throws Exception {
        Node n = new Node();
        g.addNode(n);
        assertEquals(g.getNodes().size(), 1);
        n = new Node();
        g.addNode(n);
        assertEquals(g.getNodes().size(), 2);

        ArrayList<Node> nodes = g.getNodes();
        assertTrue(nodes.get(0) != n);

        for(int i = 0 ; i < 10000; i++) {
            g.addNode(new Node());
        }

        assertEquals(g.getNodes().size(), 10002);
    }

    @Test
    public void testAddEdge() throws Exception {
        g.addNode(new Node());
        g.addNode(new Node(3, 1, 2, "Hello", Shape.SQUARE, Color.BLUE));

        ArrayList<Node> nodes = (ArrayList)g.getNodes();
        Edge e= new Edge(nodes.get(0), nodes.get(1));
        g.addEdge(e); // add an edge between the two nodes

        ArrayList<Edge> edges = (ArrayList)g.getEdges();
        assertEquals(g.getEdges().size(), 1);
        assertTrue(edges.get(0) == e);
    }

    @Test
    public void testRemoveNode() throws Exception {
        Node n = new Node();

        g.addNode(n);
        assertEquals(g.getNodes().size(), 1);

        ArrayList<Node> nodes = (ArrayList)g.getNodes();
        assertTrue(nodes.get(0) == n);
        assertTrue(g.getNodes().contains(n));
        g.removeNode(n);
        assertEquals(g.getNodes().size(), 0);

        Node nd = new Node();
        g.addNode(nd);

        for(int i =0; i< 100; i++) {
            g.addNode(new Node());
        }

        assertEquals(g.getNodes().size(), 101);
        assertTrue(g.getNodes().contains(nd));
        g.removeNode(nd);
        assertFalse(g.getNodes().contains(nd));
        assertEquals(g.getNodes().size(), 100);

        g.addNode(n);
        g.addNode(nd);
        g.addEdge(new Edge(n, nd));
        g.removeNode(n);
        assertFalse(g.getNodes().contains(n));
    }

    @Test
    public void testRemoveEdge() throws Exception {
        g.addNode(new Node());
        g.addNode(new Node(3, 1, 2, "Hello", Shape.SQUARE, Color.BLUE));

        ArrayList<Node> nodes = (ArrayList)g.getNodes();
        Edge e= new Edge(nodes.get(0), nodes.get(1));
        g.addEdge(e); // add an edge between the two nodes
        assertEquals(g.getEdges().size(), 1);

        ArrayList<Edge> edges = (ArrayList)g.getEdges();
        assertTrue(edges.get(0) == e);

        g.removeEdge(e);
        assertTrue(g.getEdges().isEmpty());
    }

    @Test
    public void testGetNodeFromCoordinates() throws Exception {
        Node n = new Node();
        g.addNode(n);
        assertEquals(g.getNodeFromCoordinates(0, 0), n);
        assertEquals(g.getNodeFromCoordinates(1, 1), null);

        Graph gr = new Graph();
        assertEquals(gr.getNodeFromCoordinates(0,0), null);
    }

    @Test
    public void testSave() throws Exception {

    }
}