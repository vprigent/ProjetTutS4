package view;

import controller.DrawingController;
import model.Edge;
import model.Graph;
import model.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class DrawingPanel extends JPanel {

    private Graph graph;
    private DrawingController controller;
    private double scale = 1.;

    public DrawingPanel(final DrawingController controller) {
        setName("MainPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 400));
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
        for (Node n : graph.getNodes()) {
            if (controller.getSelectedNodes().contains(n))
                g.setColor(Color.RED);
            else
                g.setColor(n.getColor());

            g.drawRect(n.getPosX()-n.getSize()/2, n.getPosY()-n.getSize()/2, n.getSize(), n.getSize());
        }

        for (Edge e : graph.getEdges()) {
            if(controller.getSelectedEdges() != null) {
                if (controller.getSelectedEdges().contains(e))
                    g.setColor(Color.RED);
                else
                    g.setColor(e.getColor());
            }

            g.drawLine(e.getSource().getPosX(), e.getSource().getPosY(), e.getDestination().getPosX(), e.getDestination().getPosY());
        }
    }
}
