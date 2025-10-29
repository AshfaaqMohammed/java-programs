public class PolyChall{

    public static void main(String[] args){
	
	Car car = new Car(8, "Base car");
System.out.println(car.startEngine());
System.out.println(car.accelerate());
System.out.println(car.brake());
 
Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
System.out.println(mitsubishi.startEngine());
System.out.println(mitsubishi.accelerate());
System.out.println(mitsubishi.brake());
 
Ford ford = new Ford(6, "Ford Falcon");
System.out.println(ford.startEngine());
System.out.println(ford.accelerate());
System.out.println(ford.brake());
 
Holden holden = new Holden(6, "Holden Commodore");
System.out.println(holden.startEngine());
System.out.println(holden.accelerate());
System.out.println(holden.brake());

}


}


class Car {
    // write code here
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;
    
    public Car(int cylinders, String name){
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
    }
    
    public String startEngine(){
        return this.getName() + "engine is starting.";
    }
    
    public String accelerate(){
        return this.getName() + "is accelerating!!";
    }
    
    public String brake(){
        return this.getName() + "is braking";
    }
    
    public int getCylinders(){
        return this.cylinders;
    }
    
    public String getName(){
        return this.name;
    }   
}

class Mitsubishi extends Car {
    // write code here
    public Mitsubishi(int cylinders, String name){
        super(cylinders, name);
    }
    
    @Override
    public String startEngine(){
        return this.getName() + "engine is starting.";
    }
    
    @Override
    public String accelerate(){
        return this.getClass().getName() + "is accelerating!!";
    }
    
    @Override
    public String brake(){
        return this.getClass().getName() + "is braking";
    }
}


class Holden extends Car {
    // write code here
    public Holden(int cylinders, String name){
        super(cylinders, name);
    }
    
    @Override
    public String startEngine(){
        return this.getClass().getName() + "engine is starting.";
    }
    
    @Override
    public String accelerate(){
        return this.getClass().getName() + "is accelerating!!";
    }
    
    @Override
    public String brake(){
        return this.getClass().getName() + "is braking";
    }
}

class Ford extends Car {
    // write code here
    public Ford(int cylinders, String name){
        super(cylinders, name);
    }
    
    @Override
    public String startEngine(){
        return this.getClass().getName() + "engine is starting.";
    }
    
    @Override
    public String accelerate(){
        return this.getClass().getName() + "is accelerating!!";
    }
    
    @Override
    public String brake(){
        return this.getClass().getName() + "is braking";
    }
}