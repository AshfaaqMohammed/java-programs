package default_dir;

public class BaseClass {

    public final void recommendedMethod(){
        System.out.println("[BaseClass.recommendedMethod] - best way to do it.");
        optionalMethod();
        mandatoryMethod();
    }

    protected void optionalMethod(){
        System.out.println("[BaseClass.optionalMethod] - customize option method.");
    }

    private void mandatoryMethod(){
        System.out.println("[BaseClass.mandatoryMethod] - Non negotiable method.");
    }
}
