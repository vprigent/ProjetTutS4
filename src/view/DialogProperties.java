package view;
import model.Node;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class DialogProperties extends JDialog {

    Node selected ;

    public DialogProperties(JFrame parent, String title, boolean modal, Node selected){

        //On appelle le construteur de JDialog correspondant
        super(parent, title, modal);

        //On spécifie une taille
        this.setSize(200, 80);

        //La position
        this.setLocationRelativeTo(null);

        //La boîte ne devra pas être redimensionnable
        this.setResizable(false);

        //Enfin on l'affiche
        this.setVisible(true);


        this.selected=selected;
    }

}