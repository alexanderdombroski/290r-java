package edu.byui.apj.adventure.actions;

public abstract class AbstractAction implements Action {
    private String actionKey;

    @Override
    public void setActionKey(String key) {
        actionKey = key;
    }

    @Override
    public boolean validKey(String test) {
        return actionKey.equals(test);
    }
}
