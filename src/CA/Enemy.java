package CA;

public class Enemy extends Character {
    public Enemy(String type) {
        setType(type);
//Setting the base stats of the enemy based on the enemy type
        if (type.equals("h")) {
            setHp(80);
            setAtt(30);
            setDef(30);
        }
        if (type.equals("e")) {
            setHp(120);
            setAtt(40);
            setDef(30);
        }
        if (type.equals("d")) {
            setHp(80);
            setAtt(30);
            setDef(40);
        }
        if (type.equals("o")) {
            setHp(80);
            setAtt(40);
            setDef(20);

        }
    }
}
