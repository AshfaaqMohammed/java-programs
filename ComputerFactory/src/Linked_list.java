import java.util.LinkedList;
import java.util.ListIterator;

public class Linked_list {
    public static void main(String[] args) {
        var placeToVisit = new LinkedList<String>();
        placeToVisit.add("sydney");
        placeToVisit.add(0,"canberra");
        placeToVisit.add("dessert");
        addMoreElements(placeToVisit);
        System.out.println(placeToVisit);
//        System.out.println("now remove - ");
        printItinerary(placeToVisit);
        printItinerary2(placeToVisit);
//        getElements(placeToVisit);
//        removeMoreElements(placeToVisit);
//        System.out.println(placeToVisit);

    }
    public static void addMoreElements(LinkedList<String> list){
        list.addFirst("Darwin");
        list.addLast("Hobart");

        //Queue methods
        list.offer("Melbourne");
        list.offerFirst("new city");

        //Stack methods
        list.push("Alice springs");
    }
    public static void removeMoreElements(LinkedList<String> list){
        list.remove(0);
        list.remove("new city");
        String s1 = list.remove(); //removes first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast();
        System.out.println(s3 + " last element is removed");

        //queue/deque remove methods
        String p1 = list.poll(); // removes first element
        System.out.println(p1 + " was removed");

        String p2 = list.pollLast(); // removes last element
        System.out.println(p2 + " was removed");

        list.push("sydney");
        list.push("canberra");
        System.out.println(list);

        String p4 = list.pop();
        System.out.println(p4 + " was removed");

    }

    public static void getElements(LinkedList<String> list){
        System.out.println("Retrieved element - " + list.get(4));
        System.out.println("first element - " + list.getFirst());
        System.out.println("last element - " + list.getLast());

        // Queue retrieval method
        System.out.println("Element from element() = " + list.element()); //returns first element

        // Stack retrieval method
        System.out.println("element from peek() = " + list.peek()); // return first element
    }

    public static void printItinerary(LinkedList<String> list){
//        System.out.println("Trip starts at " + list.getFirst());
        for (int i=1;i< list.size(); i++){
            System.out.println("---> From " + list.get(i-1));
            System.out.println("----> To " + list.get(i));
        }
//        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()){
            var town = iterator.next();
            System.out.println("---> From: "+ previousTown + " to " + town);
            previousTown = town;

        }
        System.out.println("Trip ends at " + list.getLast());
    }
}
