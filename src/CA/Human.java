package CA;

public class Human extends Character {
    public Human() {
        setType("h");
        setHp(50);
        attackBehavior = new SwordAttack();
        defendBehavior = new ShieldDefend();

    }
}
