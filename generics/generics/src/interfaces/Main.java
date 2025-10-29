package interfaces;

import interfaces.Challenge.Building;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        ArrayList<Integer> new_array = new ArrayList<>();

        Bird bird = new Bird();
        bird.move();
        inFlight(bird);
        System.out.println("-".repeat(10));

        Animal aBird = new Bird();
        aBird.move();
        // below code won't run because input for inFLight is fliable,
        // but we are tyring to send animal type. (this can be avoided by generics)
//        inFlight(aBird);
//        System.out.println("-".repeat(10));

        FlightEnabled fBird = new Bird();
        fBird.fly();
        inFlight(fBird);
        System.out.println("-".repeat(10));

        Trackable tBird = new Bird();
        tBird.track();
        isTrackable(tBird);
//        inFlight(tBird);
//        System.out.println("-".repeat(10));

        inFlight(new Jet());
        System.out.println("-".repeat(10));
        isTrackable(new Jet());

    }

    public static void inFlight(FlightEnabled flier){
        flier.takeoff();
        flier.fly();
        System.out.println(Arrays.toString(flier.getClass().getInterfaces()));
        if (flier instanceof Trackable tracker){
            tracker.track();
        }
        flier.land();
    }

    public static void isTrackable(Trackable tracker){
        tracker.track();
        System.out.println(Arrays.toString(tracker.getClass().getInterfaces()));
        if (tracker instanceof FlightEnabled flier){
            flier.takeoff();
            flier.fly();
            flier.land();
        }

    }
}
