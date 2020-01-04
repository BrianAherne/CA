package CA;

public class AdvancedAction {

    private Map<ActionSelection, Configuration> configMap;
    private Map<ActionSelection, ActionType> type;
    private Reach reach;
    private WeaponStance weaponStance;

    public AdvancedAction(Map<ActionSelection, ActionType> type) {
        this.type = type;
        this.reach = new Reach();
        this.weaponStance = new WeaponStance();
        this.configMap = new HashMap<>();
        this.configMap.put(ActionSelection.PERFORM_ACTION, new Configuration(30,480));
        this.configMap.put(ActionSelection.SUPER, new Configuration(8,28));
    }

    public Action selectWeapon(ActionSelection selection)
        throws WeaponException {
        switch (selection) {
            case PERFORM_ACTION:
                return selectStandardWeapon();
            case SUPER:
                return selectSuperWeapon();
            default:
                throw new WeaponException("ActionSelection " + selection + " not supported");
        }
    }

    private Action selectSuperWeapon() {
        Configuration config = configMap.get(ActionSelection.SUPER);

        MeleeAttack meleeAttack = this.reacher.reach(this.type.get(ActionSelection.SUPER),
                config.getSlashingWeapon());
        return this.weaponStance.stance(ActionSelection.SUPER, meleeAttack, config.getSlashingDamage());
    }

    private Action selectStandardWeapon() {
        Configuration config = configMap.get(ActionSelection.PERFORM_ACTION);

        MeleeAttack meleeAttack = this.reacher.reach(this.type.get(ActionSelection.PERFORM_ACTION),
                config.getSlashingWeapon());
        return this.weaponStance.stance(ActionSelection.PERFORM_ACTION, meleeAttack, config.getSlashingDamage());
    }

    public void addActionType (ActionSelection sel, ActionType newType) throws ActionException {
        ActionException existingAction = this.type.get(sel);

        if(existingAction != null) {
            if (existingAction.getName().equals(newType.getName())) {
                existingAction.setSlashing(existingAction.getSlashing() + newType.getSlashing());
            } else {
                throw new ActionException("Only one kind of action supported for each ActionSelection");
            }
        } else {
            this.type.put(sel, newType);
        }
    }
}
