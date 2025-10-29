package check;

import default_dir.BaseClass;

public class ChildClass extends BaseClass {

    @Override
    protected void optionalMethod(){
        System.out.println("[ChildClass.optionalMethod] - some stuff happened here.");
        super.optionalMethod();
    }

//    @Override
//    public void recommendedMethod(){
//        System.out.println("[ChildClass.recommendedMethod] - I will do things in my way");
//        optionalMethod();
//    }
    private void mandatoryMethod(){
        System.out.println("[ChildClass.mandatoryMethod] - NON-NEGOTIABLE.");
    }
}
