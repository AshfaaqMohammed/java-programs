import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Dog lab = new Dog("lab","Big",40);
        lab.makeNoise();
        doAnimalStuff(lab);

        Fish gold_fish = new Fish("gold fish","small",10);
        gold_fish.makeNoise();
        doAnimalStuff(gold_fish);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(lab);
        animals.add(gold_fish);
        animals.add(new Fish("shark","Big",200));
        animals.add(new Dog("pug","small", 50));

        for (Animal animal : animals){
            doAnimalStuff(animal);
            System.out.println("-".repeat(5));
        }

        String name = "ashfaaq";
        name.toCharArray();
    }

    public static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("Slow");
    }
}