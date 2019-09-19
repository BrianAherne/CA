package CA;

public class Orc extends Character {
    public Orc(){
        setType("o");
        setHp(50);
        attackBehavior = new GreatAxeAttack();
        defendBehavior = new EnduranceDefend();
    }
}
