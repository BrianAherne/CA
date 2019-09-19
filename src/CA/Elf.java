package CA;

public class Elf extends Character {
    public Elf(){
        setType("e");
        setHp(50);
        attackBehavior = new BowAttack();
        defendBehavior = new AgileDefend();
    }
}
