package CA;

public class ActionAdapter implements ActionType {
    private Logger log = Logger.getLogger(
            ActionAdapter.class.getSimpleName());
    private AdvancedAction action;

    public ActionAdapter(AdvancedAction action){
        this.action = action;
    }

    public Action selectWeapon() {
        try {
            return action.selectWeapon(ActionSelection.PERFORM_ACTION);
        } catch (ActionException e) {
            log.severe(e.toString());
            return null;
        }
    }
}
