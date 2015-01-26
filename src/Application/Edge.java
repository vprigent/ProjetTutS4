package Application;

import java.awt.Color;

public class Edge {
	private Color color;
	private int size;
	private String label;
	
	private Node source;
	private Node destination;
	
	private boolean isOrientedToSource;
	private boolean isOrientedToDestination;
	
	public Edge() {
		
	}
	
	public void drawEdge() {
		
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}
