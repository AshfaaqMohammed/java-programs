package Theater_challenge;

import java.util.TreeSet;

public class TheaterAgent {
    public static void main(String[] args) {
        Theater theater = new Theater("PVR",10,100);
        bookSeat(theater,'A',2);
        bookSeats(theater,15,'C','E',1,16);


    }
    public static void bookSeat(Theater theater,char row, int seatNO){
        String reserved = theater.reserveSeat(row, seatNO);
        if (reserved == null){
            System.out.println("Seat is unavailable");
        }
        else{
            System.out.printf("your %s Seat has been reserved successfully%n".formatted(reserved));
        }
        theater.printSeatMap();
    }

    private static void bookSeats(Theater theater, int tickets,char minRow,
                                  int minSeat, int maxSeat){
        bookSeats(theater,tickets,minRow,minRow,minSeat,maxSeat);
    }

    private static void bookSeats(Theater theater, int tickets,
                                 char minRow,char maxRow,
                                 int minSeat, int maxSeat){
        var seats = theater.reserveSeats(tickets,minRow,maxRow,minSeat,maxSeat);
        System.out.println(seats);
        if (seats != null){
            System.out.println("Congratulations!, your seats are reserved successfully");
            theater.printSeatMap();
        }else{
            System.out.println("Sorry!, seats are take or not contiguous");
        }
    }
}
