package interfaces;

public class Bird extends Animal implements FlightEnabled,Trackable{

    @Override
    public void move(){
        System.out.println("Flapping wings!!");
    }

    @Override
    public void takeoff(){
        System.out.println(this.getClass().getName() + " is taking off");
    }

    @Override
    public void land(){
        System.out.println(this.getClass().getName() + " is landing");
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getName() + " is flying");
    }

    @Override
    public void track() {
        System.out.println(this.getClass().getName() + " is trackable");
    }
}
