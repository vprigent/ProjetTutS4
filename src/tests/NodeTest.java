package tests;

import static org.junit.Assert.*;

import java.awt.*;

import org.junit.Test;
import model.Node;

public class NodeTest {
	
	@Test
	public void NodeDefaultConstructorTest()
	{
		Node n = new Node();
		
		assertEquals(n.getSize(), 1);
		assertEquals(n.getPosX(), 0);
		assertEquals(n.getPosY(), 0);
		assertEquals(n.getName(), "");
		assertEquals(n.getShape(), new Rectangle(n.getPosX(), n.getPosY(), n.getSize()*10, n.getSize()*10));
	}
	
    public void NodeConstructorTest() {
		Node n = new Node(3, 68, 47, "Test", new Rectangle(68, 47, 3*10, 3*10), Color.BLUE);
		
		assertEquals(n.getSize(), 1);
		assertEquals(n.getPosX(), 0);
		assertEquals(n.getPosY(), 0);
		assertEquals(n.getName(), "");
		assertEquals(n.getShape(), new Rectangle(n.getPosX(), n.getPosY(), n.getSize()*10, n.getSize()*10));
		assertEquals(n.getColor(), Color.BLUE);
		
    }
}
