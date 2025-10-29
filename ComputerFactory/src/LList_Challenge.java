import java.util.*;

public class LList_Challenge {
    record Planner(String town, int distance){

        @Override
        public String toString() {
            return String.format("%s (%d)",town,distance);
        }
    }

    public static void main(String[] args) {
        String s = "asdfas";
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> llist = new LinkedList<>(List.of(arr));
        ListIterator<Integer> newllist = llist.listIterator();

        LinkedList<Planner> planner = new LinkedList<>();
        add_planner(planner,new Planner("Adelaide",1374));
        add_planner(planner,new Planner("Alice Springs", 2771));
        add_planner(planner, new Planner("Brisbane",917));
        add_planner(planner, new Planner("Darwin",3972));
        add_planner(planner, new Planner("Melbourne",877));
        add_planner(planner, new Planner("Perth",3923));

        planner.addFirst(new Planner("Sydney",0));

        System.out.println(planner);

        ListIterator<Planner> iterator = planner.listIterator();

        Scanner scanner = new Scanner(System.in);
        String instructions = """
                Available actions (select word for letter):
                    (F)orward
                    (B)ackward
                    (L)ist places
                    (M)enu
                    (Q)uit
                """;
        System.out.println(instructions);
        boolean flag = true;
        boolean forward = true;

        while(flag){
            System.out.println(forward);
            if (!iterator.hasPrevious()){
                System.out.println("Starting from " + iterator.next());
            }
            if (!iterator.hasNext()){
                System.out.println("Ending at " + iterator.previous());
            }
            switch (scanner.nextLine()){
                case "F":
                    if (!forward){
                        forward = true;
                        if (iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()){
                        System.out.println("now moving forward you are at - " + iterator.next());
                    }
                    break;
                case "B":
                    if (forward){
                        forward = false;
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious()){
                        System.out.println("now moving backward you are at - " + iterator.previous());
                    }
                    break;
                case "L":
                    System.out.println(planner);
                    break;
                case "M":
                    break;
                case "Q":
                    flag = false;
                    break;
            }
        }

    }
    private static void add_planner(LinkedList<Planner> list, Planner planner){
        if (list.contains(planner)){
            System.out.println("Found duplicate " + planner);
            return;
        }
        for (Planner p : list){
            if (p.town().equalsIgnoreCase(planner.town())){
                System.out.println("Found duplicate " + planner);
                return;
            }
        }

        int matchedIdx = 0;
        for (Planner p : list){
            if (planner.distance() < p.distance()){
                list.add(matchedIdx,planner);
                return;
            }
            matchedIdx++;
        }
        list.add(planner);
    }
}
