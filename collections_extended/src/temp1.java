public class temp1{
    public static void main(String[] args){
        Animal.animal_fun();
        Dog.animal_fun();
    }
}

class Animal{
    public static void animal_fun(){
        System.out.println("this is inside animal;");
    }
}

class Dog extends Animal{

    public static void animal_fun(){
        System.out.println("this is inside dog");
    }
}
