public class Fish extends Animal{

    public Fish(String name, String size, double weight){
        super(name,size,weight);
    }

    @Override
    public void move(String speed){
        if (speed.equalsIgnoreCase("slow")){
            System.out.println(type + " is doing lazy swimming");
        }else{
            System.out.println(type + " is threatened and swimming fast.");
        }
    }

    @Override
    public void makeNoise(){
        if (type == "gold fish"){
            System.out.println("ewew!!");
        }else{
            System.out.println("arrr!!");
        }

    }

}
