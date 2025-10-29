import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BaseballTeam {

    private String teamName;
    private List<BaseballPlayer> teamMembers = new ArrayList<>();
    private int totalWins;
    private int totalLosses;
    private int totalTies;

    public BaseballTeam(String teamName){
        this.teamName = teamName;
    }


    public void addTeamMember(BaseballPlayer player){
        if (!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void listTeamMembers(){
        System.out.println("Roster - ");
        System.out.println(teamMembers);
    }

    public int ranking(){
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore){
        String outcome = "Lost to ";
        if (ourScore > theirScore){
            totalWins++;
            outcome = "Beat";
        }else if (ourScore == theirScore){
            totalTies++;
            outcome = "Tie";
        }else{
            totalLosses++;
        }
        return outcome;
    }

    @Override
    public String toString() {
        return this.teamName + " (Ranked " + ranking() + ")";
    }
}
