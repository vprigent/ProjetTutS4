package model;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class NodeTest {

    Node n;

    @Before
    public void setUp() throws Exception {
        n = new Node(2, 15, 6, "nom", new Rectangle(2,15,2*10,2*10), Color.BLUE);
    }

    @Test
    public void NodeDefaultConstructorTest() {
        Node nd = new Node();

        assertEquals(nd.getSize(), 1);
        assertEquals(nd.getPosX(), 0);
        assertEquals(nd.getPosY(), 0);
        assertEquals(nd.getName(), "");
        assertEquals(nd.getShape(), new Rectangle(nd.getPosX(), nd.getPosY(), nd.getSize() * 10, nd.getSize() * 10));
    }

    @Test
    public void NodeConstructorTest() {
        Node n = new Node(3, 68, 47, "Test", new Rectangle(68, 47, 3 * 10, 3 * 10), Color.BLUE);

        assertEquals(n.getSize(), 3);
        assertEquals(n.getPosX(), 68);
        assertEquals(n.getPosY(), 47);
        assertEquals(n.getName(), "Test");
        assertEquals(n.getShape(), new Rectangle(n.getPosX(), n.getPosY(), n.getSize() * 10, n.getSize() * 10));
        assertEquals(n.getColor(), Color.BLUE);

    }

    @Test
    public void testSetPosition() throws Exception {
        assertEquals(n.getPosX(), 15);
        assertEquals(n.getPosY(), 6);
        n.setPosition(1,5);
        assertEquals(n.getPosX(), 1);
        assertEquals(n.getPosY(), 5);
    }
}
