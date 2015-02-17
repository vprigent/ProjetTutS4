package model.fileManager;

import model.Graph;
import model.Node;
import model.Edge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Graphvis extends GraphLoader {
    @Override
    public Graph loadGraph(String filePath) {

        try {
            // récupérer tout le fichier pour ensuite exploiter ses infos
            String data = new BufferedReader(new FileReader(filePath)).readLine();

        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(data);

        return null;
    }

    @Override
    protected Graph createGraphFromData(String data) {
        Graph g = new Graph();

        String[] buffer = data.split("[\\{*\\}]");

        for(String s : buffer)
            separateDatas(s);

        return g;
    }

    public void extractDatasFromLine(String line, Graph g) {

    }

    public void separateDatas(String s) {
        String[] lineBuffer = s.split("\n");
    }

    @Override
    public void saveGraph(Graph g) {

    }
}
