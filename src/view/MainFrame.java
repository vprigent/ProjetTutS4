package view;

import model.GraphHandler;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


public class MainFrame extends JFrame implements Observer {
    private GraphHandler model;

    private JMenuBar menuBar = new JMenuBar();
    private JMenuBar toolBar = new JMenuBar();
    private JPanel panel = new JPanel();

    // Menu buttons
    private JButton newGraph = new JButton("Nouveau");
    private JButton loadGraph = new JButton("Charger");
    private JButton saveGraph = new JButton("Sauvegarder");
    private JButton removeGraph = new JButton("Supprimer");

    // Tool-bar buttons
    private JButton undo = new JButton("Annuler");
    private JButton redo = new JButton("Rétablir");
    private JButton display = new JButton("Affichage");
    private JButton algorithms = new JButton("Algorithmes");
    private JButton zoomIn = new JButton("ZoomIN");
    private JButton zoomOut = new JButton("ZoomOUT");
    private JButton copy = new JButton("Copier");
    private JButton cut = new JButton("Couper");
    private JButton paste = new JButton("Coller");
    private JButton modify = new JButton("Modifier");
    private JButton select = new JButton("Selectionner");
    private JButton defaultProperty = new JButton("Propriétés par défaut");
    private JButton add = new JButton("Ajouter");
    private JButton remove = new JButton("Supprimer");

    public MainFrame(GraphHandler model) {
        this.model = model;
        this.setTitle("Graph Drawer");
        this.setVisible(true);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        newGraph.setBackground(Color.gray);
        loadGraph.setBackground(Color.gray);
        saveGraph.setBackground(Color.gray);
        removeGraph.setBackground(Color.gray);
        menuBar.add(newGraph);
        menuBar.add(loadGraph);
        menuBar.add(saveGraph);
        menuBar.add(removeGraph);

        toolBar.setLayout(new GridLayout(10, 2));
        toolBar.add(undo, BorderLayout.NORTH);
        toolBar.add(redo, BorderLayout.NORTH);


        menuBar.setBackground(Color.DARK_GRAY);
        toolBar.setBackground(Color.DARK_GRAY);
        panel.setBackground(Color.white);
        //this.setLayout(new GridLayout(10, 1));

        this.getContentPane().add(menuBar, BorderLayout.NORTH);
        this.getContentPane().add(toolBar, BorderLayout.WEST);
        this.getContentPane().add(panel);


    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
