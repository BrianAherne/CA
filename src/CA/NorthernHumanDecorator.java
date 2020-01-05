package CA;

public class NorthernHumanDecorator extends VariantHuamnDecorator {

    public NorthernHumanDecorator(VariantHuman decoratedVariantHuman){
        super(decoratedVariantHuman);
    }

    @java.lang.Override
    public void attack() {
        decoratedVariantHuman.attack();
        setNorthernHuman(decoratedVariantHuman);
    }

    private void setNorthernHuman(VariantHuman decoratedVariantHuman){
        System.out.println("Northern Variant Human");
    }
}
