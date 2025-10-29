public class PolyChallenge {
    private String description;

    public PolyChallenge(String description){
        this.description = description;
    }

    public void startEngine(){
        System.out.println("Car Engine is starting with : ");
    }

    public void drive(){
        System.out.print("current millage of the below car - ");
    }



    protected static PolyChallenge runEngine(String description){
        char letter = description.charAt(0);
        System.out.println(letter);
        switch (letter){
            case 'G':
                return new GasPoweredCar(description);
            case 'E':
                return new ElectricCar(description);
            case 'H':
                return new HybridCar(description);
            default:
                return new PolyChallenge(description);

        }
    }
}

class GasPoweredCar extends PolyChallenge{

    private double avgKmPerLiter;
    private int cylinder;

    public GasPoweredCar(String description){
        this(description,20,4);
    }
    public GasPoweredCar(String description, double avgKmPerLiter, int cylinder){
        super(description);
        this.avgKmPerLiter  = avgKmPerLiter;
        this.cylinder = cylinder;
    }

    @Override
    public void startEngine(){
        super.startEngine();
        System.out.println("Type of car is - " + this.getClass().getSimpleName() + " with " + this.cylinder + " cylinders." );
    }

    @Override
    public void drive(){
        super.drive();
        System.out.println(this.avgKmPerLiter);
    }
}

class ElectricCar extends PolyChallenge{

    private double avgKmPerLiter;
    private int batterySize;

    public ElectricCar(String description){
        this(description,40,10);
    }

    public ElectricCar(String description, double avgKmPerLiter, int batterySize){
        super(description);
        this.avgKmPerLiter  = avgKmPerLiter;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine(){
        super.startEngine();
        System.out.println("Type of car is - " + this.getClass().getSimpleName() + " with " + this.batterySize + " batterySize." );
    }

    @Override
    public void drive(){
        super.drive();
        System.out.println(this.avgKmPerLiter);
    }
}

class HybridCar extends PolyChallenge{

    private double avgKmPerLiter;
    private int cylinder;
    private int batterySize;

    public HybridCar(String description){
        this(description,45,6,15);
    }

    public HybridCar(String description, double avgKmPerLiter, int cylinder, int batterySize){
        super(description);
        this.avgKmPerLiter  = avgKmPerLiter;
        this.cylinder = cylinder;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine(){
        super.startEngine();
        System.out.println("Type of car is - " + this.getClass().getSimpleName() + " with " + this.cylinder + " cylinders. And with " + this.batterySize + " Battery size." );
    }

    @Override
    public void drive(){
        super.drive();
        System.out.println(this.avgKmPerLiter);
    }
}
