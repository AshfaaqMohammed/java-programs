import java.sql.Ref;

public class SmartKitechen {
    CoffeeMaker brewMaster;
    DishWasher dishWasher;
    Refrigerator iceBox;

    public SmartKitechen(){
        this.brewMaster = new CoffeeMaker();
        this.dishWasher = new DishWasher();
        this.iceBox = new Refrigerator();
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    public void addWater(){
        brewMaster.setHasWorkToDo(true);
    }
    public void pourMilk(){
        iceBox.setHasWorkToDo(true);
    }
    public void loadDishWasher(){
        dishWasher.setHasWorkToDo(true);
    }

    public void setKitchenState(boolean coffeeWork, boolean refWork, boolean washerWork){
        this.brewMaster.setHasWorkToDo(coffeeWork);
        this.iceBox.setHasWorkToDo(refWork);
        this.dishWasher.setHasWorkToDo(washerWork);
    }

    public void kitchenWork(){
        this.brewMaster.brewCoffee();
        this.iceBox.orderFood();
        this.dishWasher.doDishes();
    }


}

class Refrigerator {
    private boolean hasWorkToDo;

    public void orderFood(){
        if (this.hasWorkToDo){
            System.out.println("Food preparation has been started... ");
            this.hasWorkToDo = false;
        }
        else{
            System.out.println("out of if..");
        }


    }
    public boolean getHasWorkToDo(){
        return this.hasWorkToDo;
    }

    public void setHasWorkToDo(boolean flag){
        this.hasWorkToDo = flag;
    }
}


class DishWasher{
    private boolean hasWorkToDo;

    public void doDishes(){
        if (this.hasWorkToDo){
            System.out.println("Dish washing has been started...");
            this.hasWorkToDo = false;
        }else {
            System.out.println("out of if..");
        }

    }
    public boolean getHasWorkToDo(){
        return this.hasWorkToDo;
    }
    public void setHasWorkToDo(boolean flag){
        this.hasWorkToDo = flag;
    }
}


class CoffeeMaker{
    private boolean hasWorkToDo;

    public void brewCoffee(){
        if (this.hasWorkToDo){
            System.out.println("Coffee preparation has been started...");
            this.hasWorkToDo = false;
        }else{
            System.out.println("out of if...");
        }

    }
    public boolean getHasWorkToDo(){
        return this.hasWorkToDo;
    }
    public void setHasWorkToDo(boolean flag){
        this.hasWorkToDo = flag;
    }
}


