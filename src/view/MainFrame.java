package view;

import model.GraphHandler;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.util.Observable;
import java.util.Observer;


public class MainFrame extends JFrame implements Observer {
    private GraphHandler model;
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenuBar toolBar = new JMenuBar();
    
    // Menu buttons
    private JButton newGraph = new JButton("Nouveau");
    private JButton loadGraph = new JButton("Charger");
    private JButton saveGraph = new JButton("Sauvegarder");
    private JButton removeGraph = new JButton("Supprimer");
    
    // Tool-bar buttons

    public MainFrame(GraphHandler model) {
        this.model = model;
        this.setTitle("Graph Drawer");
        this.setVisible(true);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        

        menuBar.add(newGraph);
        menuBar.add(loadGraph);
        menuBar.add(saveGraph);
        menuBar.add(removeGraph);
        

        //this.setLayout(new GridLayout(10, 1));
        
        this.getContentPane().add(menuBar, BorderLayout.NORTH);
        this.getContentPane().add(toolBar, BorderLayout.WEST);
        

    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
