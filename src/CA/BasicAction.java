package CA;

public class BasicAction implements ActionType {
    private Configuration config;

    private Map<ActionSelection, MeleeAttack> meleeAttack; private WeaponStance weaponstance;

    public BasicAction(Map<ActionSelection, MeleeAttack> action) {
        this.meleeAttack = meleeAttack;
        this.weaponstance = new WeaponStance();
        this.config = new Configuration(30,480);
    }

    public Action selectWeapon(){
        MeleeAttack meleeAttack = this.meleeAttack.get(
                ActionSelection.PERFORM_ACTION
        );

       return this.weaponstance.stance(
               ActionSelection.PERFORM_ACTION, meleeAttack,
               this.config.getQuantitySlashing()
       );
    }

    public void addMeleeAttack(
            ActionSelection sel, MeleeAttack newAttack)
        throws AttackException{
        MeleeAttack existingAttack = this.meleeAttack.get(sel);

        if(existingCoffee != null) {
            if(existingCoffee.getName().equals(newAttack.getName())) {
                existingAttack.setSlashing(existingAttack.getSlashing() + newAttack.getSlashing()));
            } else {
                throw new AttackException("Only one kind of attack supported for each ActionSelection");
            }
        } else {
            this.meleeAttack.put(sel, newAttack);
            }
        }
    }
