package view;

import controller.DrawingController;
import model.Graph;
import model.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class DrawingPanel extends JPanel {

    private Graph graph;
    private DrawingController controller;

    public DrawingPanel(final DrawingController controller) {
        setName("MainPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 400));
        graph = controller.getGraph();
        this.controller = controller;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                controller.mainPanelMouseClicked(evt);
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

            g.drawRect(n.getPosX(), n.getPosY(), n.getSize(), n.getSize());
        }
    }
}
