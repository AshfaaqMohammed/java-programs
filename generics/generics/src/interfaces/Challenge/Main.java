package interfaces.Challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
//        List<Mappable> mappables = new ArrayList<>();
//
//        mappables.add(new Building("Assembly",UsageType.GOVERNMENT));
//        mappables.add(new Building("Gachibowli stadium",UsageType.ENTERTAINMENT));
//        mappables.add(new Utility("Water pipeline",UtilityType.WATER));
//
//        for (var e: mappables){
//            Mappable.mapIt(e);
//        }

        Integer five = 5;
        Integer[] others = {0,5,10,-50,50};

        for (int i : others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d compare to %d%n",five,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"),i, val);
        }
    }
}
