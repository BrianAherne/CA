package CA;

public class HumanFactory {
    public VariantHuman getType(String humanType){
        if (humanType == null) {
            return null;
        }
        if(humanType.equalsIgnoreCase("HALFORC")){
            return new HalfOrc();
        }
        else if(humanType.equalsIgnoreCase("HALFELF")){
            return new HalfElf();
        }
        else if(humanType.equalsIgnoreCase("DRAGONMARKHUMAN")){
            return new DragonMarkHuman();
        }
        return null;
    }
}
