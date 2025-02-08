package edu.byui.apj.adventure.actions;

public abstract class AbstractAction implements Action {
    private final String actionKey;

    public AbstractAction(String key){
        actionKey = key;
    }

    @Override
    public boolean validKey(String test) {
        return actionKey.equals(test);
    }
}
