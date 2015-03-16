import model.GraphHandler;
import view.MainFrame;
import controller.*;


public class Main {
    public static void main(String[] args) {
        GraphHandler graphHandler = new GraphHandler();

        Controller c = new Controller(graphHandler);

        MainFrame mainFrame = new MainFrame(c);

        graphHandler.addObserver(mainFrame);
    }
}
