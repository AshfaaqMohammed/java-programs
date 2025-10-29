import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Card[] cardsArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART,'A');
        Arrays.fill(cardsArray,aceOfHearts);
        Card.printDeck(Arrays.asList(cardsArray),"aces of heart",1);


        System.out.println("-".repeat(10));
        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards,aceOfHearts);
        System.out.println(cards);
        System.out.println("Card size = " + cards.size());


        List<Card> acesOfHeart = Collections.nCopies(13,aceOfHearts);
        Card.printDeck(acesOfHeart,"Using collections",1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB,'K');
        List<Card> kingOfClub = Collections.nCopies(13,kingOfClubs);
        Card.printDeck(kingOfClub,"King of clubs",1);

        Collections.addAll(cards,cardsArray);
        Card.printDeck(cards,"Full deck",1);

        List<Card> deck = Card.getStandardDeck();
        Collections.shuffle(deck);
        Card.printDeck(deck,"Shuffled deck",4);

//        Integer[] temp = new Integer[]{2,4,3,1};
//        List<Integer> new_temp = new ArrayList<>(List.of(temp));
//        System.out.println(new_temp);
//        Collections.reverse(new_temp);
//        System.out.println(new_temp);

        var sortAlgo = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit).reversed();
        Collections.sort(deck,sortAlgo);
        Card.printDeck(deck,"sorting deck",13);

        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings,"all kings",1);

        List<Card> tens = new ArrayList<>(deck.subList(16,20));
        Card.printDeck(tens,"all tens",1);

        int subListIndex = Collections.indexOfSubList(deck,tens);
        System.out.println("Index of subList = " + subListIndex);

        System.out.println("contains = "+ deck.containsAll(tens));

        boolean disjoin = Collections.disjoint(deck,tens);
        System.out.println(disjoin);





    }

    public static String getFace(Card card){
        return card.face();
    }
}