package view;

import model.Edge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DialogPropertiesEdge extends JDialog {

    Edge selected;

    private JPanel tools;
    private JButton test;

    public DialogPropertiesEdge(final JFrame parent, String title, boolean modal, final Edge selected) {

        //On appelle le construteur de JDialog correspondant
        super(parent, title, modal);
        this.selected = selected;
        //On spécifie une taille
        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel("propriétés du Noeud"));
        final JSpinner size = new JSpinner();
        final JColorChooser color = new JColorChooser();
        size.setValue((Integer) selected.getweight());
        getContentPane().add(messagePane);

        JPanel buttonPane = new JPanel();
        JButton quit = new JButton("OK");
        final JButton Colorchanger = new JButton("color");
        buttonPane.add(Colorchanger);
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