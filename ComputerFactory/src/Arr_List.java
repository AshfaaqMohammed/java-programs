import java.util.*;

public class Arr_List {
    record GroceryItems(String name, String type, int count){
        public GroceryItems(String name){
            this(name, "DAIRY",1);
        }
    }

    public static void main(String[] args) {
        List<GroceryItems> grocery = new ArrayList<>();
        grocery.add(new GroceryItems("Milk"));
        grocery.add(new GroceryItems("curd"));
        System.out.println(grocery.get(0));


        ArrayList<String> rand = new ArrayList<>(List.of("shade", "mico", "surge"));
        String[] str = rand.toArray(new String[0]);
        System.out.println(rand.get(0));

        System.out.println((rand));
        System.out.println(rand.size());
        rand.set(1,"edger");
        rand.add("kenji");
        System.out.println(rand.remove("shade"));
        ArrayList<String> brawlers = new ArrayList<>(List.of("penny","poco","motriss"));
        rand.addAll(brawlers);
        System.out.println(rand);
        rand.sort(Comparator.naturalOrder());
        System.out.println(rand);
        rand.sort(Comparator.reverseOrder());
        System.out.println(rand);

        Integer[] b_count = new Integer[]{1,2,3,4,5,6};
        ArrayList<Integer> b_arrcount = new ArrayList<>(Arrays.asList(b_count));
        System.out.println(b_arrcount);

        var bb_count = b_arrcount.toArray(new Integer[3]);
        System.out.println(Arrays.toString(bb_count));




//        for (GroceryItems temp : grocery){
//            System.out.println(temp);
//            System.out.println(temp.name);
//            System.out.println("-".repeat(5));
//        }
     }
}
