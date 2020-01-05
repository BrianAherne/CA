package CA;

public abstract class VariantHuamnDecorator implements VariantHuman {
    protected VariantHuman decoratedVariantHuman;

    public VariantHuamnDecorator(VariantHuman decoratedVariantHuman){
        this.decoratedVariantHuman = decoratedVariantHuman;
    }
    public void attack(){
        decoratedVariantHuman.attack();
    }
}
