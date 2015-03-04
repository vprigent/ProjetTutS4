package model.fileManager;

import model.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphvisTest {

    Graphvis filemanager;
    Graph g;

    @Before
    public void initialiseState() {
        g = new Graph();
        filemanager = new Graphvis();

        filemanager.loadGraph("tests/graphvis.dot");
    }


    @Test
    public void testRegexData() throws Exception {
        String g = "digraph threeWay { a -> b ; b -> c ; c -> a } \n" +
                "digraph test2 { a -> c; b -> c; c -> b; c -> a}";

        System.out.println(g);

        String[] temp = g.split("[\\{*\\}]");


        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i].trim();
        }

        assertEquals("a -> b ; b -> c ; c -> a", temp[1]);

        assertEquals("a -> c; b -> c; c -> b; c -> a", temp[3]);
    }

    @Test
    public void testSaveGraph() throws Exception {

    }
}