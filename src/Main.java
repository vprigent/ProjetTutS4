import model.GraphHandler;
import view.MainFrame;


public class Main {
    public static void main(String[] args) {
        GraphHandler graphHandler = new GraphHandler();

        MainFrame mainFrame = new MainFrame(graphHandler);

        graphHandler.addObserver(mainFrame);
        
        while (true){
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	mainFrame.repaint();
        }
    }
}
