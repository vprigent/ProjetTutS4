import model.GraphHandler;
import view.MainFrame;

import model.GraphHandler;
import view.MainFrame;

/**
 * Created by vprigent on 27/01/15.
 */
public class Main {
    public static void main(String[] args) {
        GraphHandler graphHandler = new GraphHandler();

        MainFrame mainFrame = new MainFrame(graphHandler);

        graphHandler.addObserver(mainFrame);
    }
}
