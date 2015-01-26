package Application;

/**
 * Cette classe est à revoir car incomplète et faite plus ou moins à l'arrache.
 */
public abstract class Algorithm {
    private String fileName;

    public Algorithm() {

    }

    public abstract void browseNodes();

    public abstract void colorGraph();

    public abstract void defineSize();

    public abstract void defineIndexes();

    public abstract void defineShapes();

    public abstract void areAdjacents();
}
