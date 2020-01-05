package CA;

public class VariantHumanDecoratorDemo {
    public static void main(String[] args){

        VariantHuman halfOrc = new HalfOrc();

        VariantHuman northernHalfOrc = new NorthernHumanDecorator(new HalfOrc());

        VariantHuman northernHalfElf = new NorthernHumanDecorator((new HalfElf()));
        halfOrc.attack();
        northernHalfOrc.attack();
        northernHalfElf.attack();
    }
}
