package CA;

public class Dwarf extends Character {
    public Dwarf(){
        setType("d");
        setHp(50);
        attackBehavior = new HammerAttack();
        defendBehavior = new ArmorDefend();

    }
}
