package interfaces;

public class Jet implements FlightEnabled,Trackable{
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
