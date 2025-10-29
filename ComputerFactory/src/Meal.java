import javax.xml.stream.events.DTD;

public class Meal {

    private static int mealCounter;

    private HamBurger hamBurger;
    private Drink drink;
    private String side;

    public Meal(String side,String burgerType, double basePrice, char size){
        this.mealCounter = Meal.mealCounter++;
        this.hamBurger = new HamBurger(burgerType,basePrice);
        this.drink = new Drink(size);
        this.side = side;
    }

    public Meal(){
        this.mealCounter = Meal.mealCounter++;
        this.hamBurger = new HamBurger("aloo tikki burker",100);
        this.drink = new Drink();
        this.side = "nuggets";
    }

    @Override
    public String toString() {
        return "Meal{" +
                "hamBurger=" + hamBurger +
                ", drink=" + drink +
                ", side='" + side + '\'' +
                '}';
    }
}

class HamBurger{
    private String burgerType;
    private double basePrice;
    private int extraToppings;

    public HamBurger(String burgerType, double basePrice){
        this(burgerType,basePrice,0);
    }
    public HamBurger(String burgerType, double basePrice, int extraToppings){
        this.burgerType = burgerType;
        this.basePrice = basePrice;
        if (extraToppings > 3){
            this.extraToppings = 3;
            System.out.println("Only 3 free extra toppings are allowed, your burger will have only 3 toppings, " +
                    "for extra topping please click addToppings function Thank you.");
        }else{
            this.extraToppings = extraToppings;
        }
    }

    public double addToppings(int extraToppings){
        System.out.println(extraToppings + " has been added");
        this.basePrice += (20*extraToppings);
        System.out.println("Your total bill - " + this.basePrice);
        return this.basePrice;
    }

    public double getBasePrice(){
        return this.basePrice;
    }
}

class Drink{
    private char size;

    public Drink(){
        this('S');
    }

    public Drink(char size){
        this.size = size;
    }
    public char getSize(){
        return this.size;
    }

    public void changeSize(char size){
        switch (size){
            case 'L', 'M':
                this.size = size;
                System.out.println("Your drink size has been changed successfully to " + this.size);
                break;
            default:
                this.size = 'S';
        }
    }
}


