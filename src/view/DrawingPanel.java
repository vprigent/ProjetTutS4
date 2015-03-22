package view;

import controller.DrawingController;
import model.Edge;
import model.Graph;
import model.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DrawingPanel extends JPanel {

    private Graph graph;
    private DrawingController controller;

    private double scale = 1.;

    public static final int defaultSize = 15;

    private int itemVisible = 0;

    public DrawingPanel(final DrawingController controller) {
        setName("MainPanel");
        graph = controller.getGraph();
        this.controller = controller;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                controller.mainPanelMouseClicked(evt);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent evt) {
                controller.mainPanelMousePressed(evt);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                controller.mainPanelMouseReleased(evt);
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (itemVisible != 2) {
            // For each nodes, we draw it on the graph
            for (Node n : graph.getNodes()) {
                if (controller.getSelectedNodes().contains(n))
                    g.setColor(Color.RED);
                else
                    g.setColor(n.getColor());

                int x = (int) (n.getPosX() * scale);
                int y = (int) (n.getPosY() * scale);
                int size = n.getSize() * defaultSize;
                switch (n.getShape()) {
                    case SQUARE:
                        g.drawRect(x - size / 2, y - size / 2, size, size);
                        break;
                    case TRIANGLE:
                        int[] pointsX = {x + size / 2, x, x - size / 2};
                        int[] pointsY = {y + size / 2, y - size / 2, y + size / 2};
                        g.drawPolygon(pointsX, pointsY, 3);
                        break;
                    case CIRCLE:
                        g.drawOval(x - size / 2, y - size / 2, size, size);
                        break;
                    default:
                        g.drawRect(x - size / 2, y - size / 2, size, size);
                        break;
                }

                g.drawString(n.getName(), x - (n.getSize() + 10), y - (n.getSize() * 10));
            }
        }
        if (itemVisible != 1) {
            // For each edges, we draw it on the graph
            for (Edge e : graph.getEdges()) {
                if (controller.getSelectedEdges() != null) {
                    if (controller.getSelectedEdges().contains(e))
                        g.setColor(Color.RED);
                    else
                        g.setColor(e.getColor());
                }
                ((Graphics2D) g).setStroke(new BasicStroke(e.getWeight()));

                g.drawString(e.getLabel(), (int) (e.getSource().getPosX() * scale + e.getDestination().getPosX() * scale) / 2, (int) (e.getSource().getPosY() * scale + e.getDestination().getPosY() * scale) / 2);

                g.drawLine((int) (e.getSource().getPosX() * scale), (int) (e.getSource().getPosY() * scale), (int) (e.getDestination().getPosX() * scale), (int) (e.getDestination().getPosY() * scale));
            }
        }
    }

    public void setItemVisible(int itemVisible) {
        this.itemVisible = itemVisible;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}
