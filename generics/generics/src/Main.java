import Challenge.Layer;
import Challenge.Mountain;

import java.util.*;

interface Player {
    String name();
}

record BaseballPlayer(String name, String position) implements Player{ }

record FootballPlayer(String name, String position) implements Player{ }

public class Main {
    public static void main(String[] args) {

        int[] tempInt = new int[]{33,2,5,1};
        Arrays.sort(tempInt);
        System.out.println(Arrays.toString(tempInt));

        List<Integer> tempList = new ArrayList<>(List.of(33,2,5,1));
        System.out.println(tempList);

        List<Integer> tempLList = new LinkedList<>(List.of(33,2,5,1));
        tempLList.sort(Comparator.reverseOrder());
        System.out.println(tempLList);

        BaseballTeam hyd1 = new BaseballTeam("Hyderabad");
        BaseballTeam blr1 = new BaseballTeam("Bangalore");
        scoreResult(hyd1,blr1,3,0);

        SprotsTeam hyd2 = new SprotsTeam("Hyderabad");
        SprotsTeam blr2 = new SprotsTeam("Bangalore");
        scoreResult(hyd2,blr2,3,0);

        Team<BaseballPlayer> hyd = new Team<>("Hyderabad");
        Team<BaseballPlayer> blr = new Team<>("Bangalore");
        scoreResult(hyd,blr,3,0);

        var klassan = new BaseballPlayer("Henric Klassan","wicketkeeper Batsman");
        hyd.addTeamMember(klassan);
        var virat = new BaseballPlayer("Virat kohli", "Batsman"); //problem 1 (if not using generics)
        hyd.addTeamMember(virat);
        hyd.addTeamMember(new BaseballPlayer("Pat cummins","Bowler"));
        hyd.listTeamMembers();

        System.out.println("-".repeat(10));

        Team<FootballPlayer> al_nasar = new Team<>("Al Nasar");
        Player ronaldo = new FootballPlayer("Cristiano Ronaldo","Mid Fielder");
//        var virat = new BaseballPlayer("Virat kohli", "Batsman"); //problem 1 (if not using generics)
//        al_nasar.addTeamMember(virat);                            //problem 1 (if not using generics)
        al_nasar.addTeamMember(ronaldo);
        al_nasar.listTeamMembers();
        SprotsTeam barcelona = new SprotsTeam("Barcelona");

//        scoreResult(al_nasar,hyd,5,0); //problem 2 (if not using generics)


        var nationalUSMountains = new Mountain[]{
                new Mountain("Mount Everest","44.4882,-110.5916"),
                new Mountain("Kanchanjanga", "36.1085,-112.0965")
        };
        Layer<Mountain> mountains = new Layer<>(nationalUSMountains);
        mountains.addElement(new Mountain("Kailasa parvat","45.9854,-123.0904"));
        mountains.renderElements();


    }

    public static void scoreResult(BaseballTeam team1, BaseballTeam team2, int t1_score, int t2_score){
        String result = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,result,team2);
    }

    public static void scoreResult(SprotsTeam team1, SprotsTeam team2, int t1_score, int t2_score){
        String result = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,result,team2);
    }

    public static void scoreResult(Team team1, Team team2, int t1_score, int t2_score){
        String result = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,result,team2);
    }
}