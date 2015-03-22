package controller;


import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Class used for the undo/redo
 */
public class UndoRedoManager {
    private ArrayList<Pair<Action, Object>> lastAction;
    private ArrayList<Pair<Action, Object>> lastUndo;

    /**
     * Default constructor
     */
    public UndoRedoManager() {
        lastAction = new ArrayList<Pair<Action, Object>>();
        lastUndo = new ArrayList<Pair<Action, Object>>();
    }

    /**
     * @param action
     * @param object
     */
    public void addAction(Action action, Object object) {
        lastAction.add(new Pair<Action, Object>(action, object));
    }

    public Pair<Action, Object> undo() {
        if (lastAction.isEmpty()) {
            return null;
        }

        Pair<Action, Object> lastAct = lastAction.get(lastAction.size() - 1);
        lastUndo.add(new Pair<Action, Object>(lastAction.get(lastAction.size() - 1).getKey(), lastAction.get(lastAction.size() - 1).getValue()));
        lastAction.remove(lastAct);
        return lastAct;
    }


    public Pair<Action, Object> redo() {
        if (lastUndo.isEmpty()) {
            return null;
        }

        Pair<Action, Object> undo = lastUndo.get(lastUndo.size() - 1);
        lastAction.add(undo);
        lastUndo.remove(undo);
        return undo;
    }
}
