package interfaces;

//import java.util.Collections;


import java.util.Collections;

interface FlightEnabled{
    void takeoff();
    void fly();
    void land();
}

interface Trackable {
    void track();
}

public abstract class Animal {

    public abstract void move();
}
