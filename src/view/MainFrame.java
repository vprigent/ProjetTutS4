package view;

import model.GraphHandler;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by vprigent on 27/01/15.
 */
public class MainFrame extends JFrame implements Observer {
    private GraphHandler model;

    public MainFrame(GraphHandler model) {
        this.model = model;
        this.setTitle("Algorithm application");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
