package model.fileManager;


import model.Graph;

public abstract class GraphLoader {
    public abstract Graph loadGraph(String filePath, Graph graph);

    protected abstract Graph createGraphFromData(String data);

    public abstract void saveGraph(Graph g, String filePath);
}
