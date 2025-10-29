public class Inheritence {
    public static void main(String[] args) {

        Animal animal  = new Animal("Generic animal","big", 22.2);
        doAnimalStuff(animal,"slow");

        Dog dog = new Dog();
        doAnimalStuff(dog, "Fast");

    }
    public static void doAnimalStuff(Animal animal ,String speed){
        System.out.println(animal);
        animal.makeNoice();
        animal.move(speed);
        System.out.println("-".repeat(5));
    }
}



