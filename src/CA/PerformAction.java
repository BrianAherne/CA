package CA;

public class PerformAction {
    private Logger log = Logger.getLogger(
            PerformAction.class.getAttackName()
    );
    private ActionType weaponAttack;

    public PerformAction(ActionType weaponAttack) {
        this.weaponAttack = weaponAttack;
    }

    public Action prepareAction() {
        Action action = this.weaponAttack.selectWeapon();
        log.info("Action is ready");
        log.info(" ->" + action);
    }
}
