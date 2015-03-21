package controller;


import javafx.util.Pair;

import java.util.ArrayList;

public class UndoRedoManager {
    private ArrayList<Pair<Action, Object>> lastAction;
    private ArrayList<Pair<Action, Object>> lastUndo;

    public UndoRedoManager() {
        lastAction = new ArrayList<Pair<Action, Object>>();
        lastUndo = new ArrayList<Pair<Action, Object>>();
    }

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
        lastUndo.remove(undo);
        return undo;
    }
}
