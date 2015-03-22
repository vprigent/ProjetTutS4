package view;

import model.Edge;
import model.Node;
import model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DialogProperties extends JDialog {

    public DialogProperties(final JFrame parent, String title, boolean modal, final Object selected) {

        super(parent, title, modal);
        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel(title));


        //La position
        this.setLocationRelativeTo(null);

        //La boîte ne devra pas être redimensionnable
        this.setResizable(true);

        //Enfin on l'affiche
        this.setVisible(true);


        final JSpinner size = new JSpinner();
        final JColorChooser color = new JColorChooser();
        final JButton Colorchanger = new JButton("color");


        getContentPane().add(messagePane);

        JPanel buttonPane = new JPanel();
        JButton quit = new JButton("OK");
        buttonPane.add(Colorchanger);
        buttonPane.add(size);
        buttonPane.add(quit);
        getContentPane().add(buttonPane, BorderLayout.NORTH);

        pack();

        if (selected instanceof Node) {
            final Node node = (Node) selected;
            final JComboBox shape = new JComboBox<String>();
            buttonPane.add(shape);

            size.setValue(node.getSize());

            shape.setModel(new DefaultComboBoxModel<String>(Shape.Strings()));
            quit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    node.setSize((Integer) size.getValue());

                    if (shape.getSelectedItem().toString() == "Triangle") {
                        node.setShape(Shape.TRIANGLE);
                    }
                    if (shape.getSelectedItem().toString() == "Cercle") {
                        node.setShape(Shape.CIRCLE);
                    }
                    if (shape.getSelectedItem().toString() == "Carré") {
                        node.setShape(Shape.SQUARE);
                    }
                    parent.repaint();
                    dispose();
                }
            });

            Colorchanger.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    node.setColor(color.showDialog(null, "Choose a Color", null));
                }
            });
        } else if (selected instanceof Edge) {

            final Edge edge = (Edge) selected;
            quit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    edge.setWeight((Integer) size.getValue());
                    parent.repaint();
                    dispose();
                }
            });

            Colorchanger.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    edge.setColor(color.showDialog(null, "Choose a Color", null));
                    System.out.println("hello");
                }
            });
        }
    }
}