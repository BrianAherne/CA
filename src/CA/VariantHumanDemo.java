package CA;

public class VariantHumanDemo {

    public static void main(String[] args){
        HumanFactory humanFactory = new HumanFactory();

        VariantHuman human1 = humanFactory.getType("HALFORC");
        human1.attack();

        VariantHuman human2 = humanFactory.getType("HALFELF");
        human2.attack();

        VariantHuman human3 = humanFactory.getType("DRAGONMARKHUMAN");
        human3.attack();
    }
}
