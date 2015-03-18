package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EdgeTest {

    Node source = new Node();
    Node destination = new Node();
    Edge e;

    @Before
    public void setUp() throws Exception {
        e = new Edge(source, destination);
    }

    @Test
    public void testSwitchOrientationNode() throws Exception {
        assertEquals(e.getDestination(), destination);
        assertEquals(e.getSource(), source);

        e.switchOrientationNode();

        assertEquals(e.getSource(), destination);
        assertEquals(e.getDestination(), source);
    }

    @Test
    public void testChangeNodes() throws Exception {

        Node source2 = new Node();
        e.changeNode(source2, destination);

        assertEquals(e.getSource(), source2);
        assertEquals(e.getDestination(), destination);
    }

    @Test
    public void testChangeNodesWithNullValue() throws Exception {

        Node source2 = new Node();
        e.changeNode(source2, null);

        assertEquals(e.getSource(), source2);
        assertEquals(e.getDestination(), destination);

        e.changeNode(null, source2);

        assertEquals(e.getSource(), source2);
        assertEquals(e.getDestination(), source2);
    }

}