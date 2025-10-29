package Theater_challenge;

import javax.swing.*;
import java.sql.Struct;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Theater {

    static class Seat implements Comparable<Seat> {
        private String seatNum;
        private boolean reserved;

        public Seat(char rowChar, int seatNum){
            this.seatNum = "%c%03d".formatted(rowChar,seatNum).toUpperCase();
        }

        @Override
        public String toString(){
            return seatNum;
        }

        @Override
        public int compareTo(Seat o){
            return this.seatNum.compareTo(o.seatNum);
        }
    }
    private String name;
    private int seatCount;
    private NavigableSet<Seat> seats;


    public Theater(String name, int sCount,int totalSeats){
        this.name = name;
        this.seatCount = totalSeats/sCount;

        seats = new TreeSet<>();
        for (int i=0;i<totalSeats;i++){
            char rowChar = (char) (i/seatCount + (int)'A');
            int seatInRow = (i%seatCount) + 1;
            seats.add(new Seat(rowChar,seatInRow));
        }
    }
    public void printSeatMap(){
        String seperateLine = "-".repeat(50);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n",seperateLine,name);
        int index = 0;
        for (Seat s: seats){
            System.out.printf("%-8s%s",s.seatNum + ((s.reserved) ? "(\u25CF)" : ""),
                    ((index++ + 1) % seatCount == 0) ? "\n" : "");
        }
        System.out.println(seperateLine);
    }

    public String reserveSeat(char row, int seatNo){
        Seat seat = new Seat(row,seatNo);
        Seat requested = seats.floor(seat);
        if (requested == null || (!requested.seatNum.equals(seat.seatNum))){
            System.out.println("---> NO such seat: "+seat);
            System.out.println(": Seats must be between %s and %s".formatted(seats.first().seatNum,seats.last().seatNum));
        }
        else {
            if(!requested.reserved){
                requested.reserved = true;
                return requested.seatNum;
            }else{
                System.out.println("Seat is already taken");
            }
        }
        return null;
    }

    private boolean validate(int count, char first, char last, int min, int max){

        boolean result = (min > 0 || seatCount>=count || (max-min) + 1 >=count);
        System.out.println(result);
        result = result && seats.contains(new Seat(first,min));
        System.out.println(result);
        if (!result){
            System.out.println("Sorry these are seats are invalid please enter valid seats.");
        }
        return result;
    }

    public Set<Seat> reserveSeats(int count, char minRow, char maxRow, int minSeat, int maxSeat){
        char lastValid = seats.last().seatNum.charAt(0);
        maxRow = (maxRow > lastValid) ? lastValid : maxRow;

        if (!validate(count, minRow, maxRow,minSeat,maxSeat)){
            return null;
        }
        NavigableSet<Seat> selected = null;

        for (char letter=minRow; letter<maxRow; letter++){
            NavigableSet<Seat>  contiguous = seats.subSet(
                    new Seat(letter, minSeat),true,
                    new Seat(letter, maxSeat),true);
            int index = 0;
            Seat first = null;
            for (Seat current : contiguous){
                if (current.reserved){
                    index = 0;
                    continue;
                }
                first = (index == 0) ? current : first;
                if (++index == count){
                    selected = contiguous.subSet(first, true, current, true);
                    break;
                }

            }
            if (selected != null){
                break;
            }
        }

        Set<Seat> reservedSeats = null;
        if (selected!=null){
            selected.forEach(s->s.reserved = true);
            reservedSeats = new TreeSet<>(selected);
        }
        System.out.println(reservedSeats);
        return reservedSeats;
    }
}
