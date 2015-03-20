package view;

import model.Node;
import model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DialogProperties extends JDialog {

    Node selected;

    public DialogProperties(final JFrame parent, String title, boolean modal, final Node selected) {

        //On appelle le construteur de JDialog correspondant
        super(parent, title, modal);
        this.selected = selected;
        //On spécifie une taille
        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel("propriétés du Noeud"));
        final JSpinner size = new JSpinner();
        final JColorChooser color = new JColorChooser();
        size.setValue(selected.getSize());
        getContentPane().add(messagePane);

        JPanel buttonPane = new JPanel();
        final JComboBox shape = new JComboBox<String>();
        shape.setModel(new DefaultComboBoxModel<String>(new String[]{
                "carré", "rond", "triangle"}));
        JButton quit = new JButton("OK");
        final JButton Colorchanger = new JButton("color");
        buttonPane.add(Colorchanger);
        buttonPane.add(shape);
        buttonPane.add(size);
        buttonPane.add(quit);
        getContentPane().add(buttonPane, BorderLayout.NORTH);

        pack();


        setVisible(true);


        //La position
        this.setLocationRelativeTo(null);

        //La boîte ne devra pas être redimensionnable
        this.setResizable(true);

        //Enfin on l'affiche
        this.setVisible(true);
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selected.setSize((Integer) size.getValue());

                if (shape.getSelectedItem().toString() == "triangle") {
                    selected.setShape(Shape.TRIANGLE);
                }
                if (shape.getSelectedItem().toString() == "rond") {
                    selected.setShape(Shape.CIRCLE);
                }
                if (shape.getSelectedItem().toString() == "carré") {
                    selected.setShape(Shape.SQUARE);
                }
                parent.repaint();
                dispose();
            }
        });

        Colorchanger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selected.setColor(color.showDialog(null, "Choose a Color", null));
            }
        });

    }

}