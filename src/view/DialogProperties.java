package view;

import model.Node;

import javax.swing.*;
import java.awt.*;

/**
 * Created by basbournas on 16/03/15.
 */


public class DialogProperties extends JDialog {

    Node selected ;
    private JPanel tools;
    private JButton test;

    public DialogProperties(JFrame parent, String title, boolean modal, Node selected){

        //On appelle le construteur de JDialog correspondant
       super(parent, title, modal);

        //On spécifie une taille
        this.setSize(5000, 370);
        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel(title));
        getContentPane().add(messagePane);
        JPanel buttonPane = new JPanel();
        JButton button = new JButton("OK");
        buttonPane.add(button);
       // button.addActionListener(this);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        pack();
        setVisible(true);


        //La position
        this.setLocationRelativeTo(null);

        //La boîte ne devra pas être redimensionnable
        this.setResizable(true);

        //Enfin on l'affiche
        this.setVisible(true);

        this.selected=selected;
    }

}