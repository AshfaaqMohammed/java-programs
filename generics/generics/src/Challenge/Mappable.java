package Challenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public interface Mappable {
    void render();

    static double[] stringToLanLon(String location){
        var latLon = location.split(",");
        double lat = Double.parseDouble(latLon[0]);
        double lon = Double.parseDouble(latLon[1]);

        return new double[]{lat,lon};
    }
}

abstract class Point implements Mappable{

    private double[] location = new double[2];

    public Point(String location){
        this.location = Mappable.stringToLanLon(location);
    }

    @Override
    public void render(){
        System.out.println(this);
        System.out.println("Render "+ this + " as Point" + "(" + location() + ")");
    }

    private String location(){
        return Arrays.toString(location);
    }
}

abstract class Line implements Mappable{
    private double[][] locations;

    public Line(String... locations){
        this.locations = new double[locations.length][];
        int index = 0;
        for (var l : locations){
            this.locations[index++] = Mappable.stringToLanLon(l);
        }
    }

    @Override
    public void render(){
        System.out.println(this);
        System.out.println("Render " + this + "as LINE" + "(" + locations() + ")");
    }

    public String locations(){
        return Arrays.deepToString(this.locations);
    }
}
