package model;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeTest {

    Node n;

    @Before
    public void setUp() throws Exception {
        n = new Node(2, 15, 6, "nom", Shape.SQUARE, Color.BLUE);
    }

    @Test
    public void NodeDefaultConstructorTest() {
        Node nd = new Node();

        assertEquals(nd.getSize(), 1);
        assertEquals(nd.getPosX(), 0);
        assertEquals(nd.getPosY(), 0);
        assertEquals(nd.getName(), "");
        assertEquals(nd.getShape(), Shape.SQUARE);
    }

    @Test
    public void NodeConstructorTest() {
        Node n = new Node(3, 68, 47, "Test", Shape.SQUARE, Color.BLUE);

        assertEquals(n.getSize(), 3);
        assertEquals(n.getPosX(), 68);
        assertEquals(n.getPosY(), 47);
        assertEquals(n.getName(), "Test");
        assertEquals(n.getShape(), Shape.SQUARE);
        assertEquals(n.getColor(), Color.BLUE);

    }

    @Test
    public void AccesseursTest() {
        n.setSize(15000);
        assertTrue(n.getSize() == 10);

        n.setSize(-100);
        assertTrue(n.getSize() == 1);

        n.setPosition(-20150, -12025);
        assertEquals(n.getPosX(), -Node.maxPosition);
        assertEquals(n.getPosY(), -Node.maxPosition);
    }

    @Test
    public void testSetPosition() throws Exception {
        assertEquals(n.getPosX(), 15);
        assertEquals(n.getPosY(), 6);
        n.setPosition(1,5);
        assertEquals(n.getPosX(), 1);
        assertEquals(n.getPosY(), 5);
    }

    @Test
    public void testAddNeighbour() {
        Node node = new Node();

        assertTrue(n.addNeighbour(node));
        assertFalse(n.addNeighbour(node));
    }
}
