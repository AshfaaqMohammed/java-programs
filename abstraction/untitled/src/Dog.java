import java.util.Objects;

public class Dog extends Animal{

    public Dog(String name, String size, double weight){
        super(name,size,weight);
    }

    @Override
    public void move(String speed){
        if (speed.equalsIgnoreCase("slow")){
            System.out.println(type + " is moving slow");
        }else{
            System.out.println(type + " is running.");
        }
    }

    @Override
    public void makeNoise(){
        if (type == "Wolf"){
            System.out.println("Awooooo!!");
        }else{
            System.out.println("wolff!!");
        }

    }

}
