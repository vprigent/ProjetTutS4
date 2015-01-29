package model;

import java.util.Observable;


public class GraphHandler extends Observable {
   private Graph g = new Graph();


    public GraphHandler() {
        Node n = new Node();
        Node p = new Node();
        Edge e = new Edge(n,p);
        g.addNode(n);
        g.addNode(p);
        g.addEdge(e);
        System.out.println(g);
    }

}
