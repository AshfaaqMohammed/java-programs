import java.util.Arrays;
public class Challenge{
    public static void main(String a[]){
	System.out.println(Arrays.toString(a));
	System.out.println(a);
	boolean gameOver = true;
	int score = 10000;
	int levelCompleted = 8;
	int bonus = 200;
	
	int fScore = challenge(gameOver,score, levelCompleted, bonus);
	System.out.println("fscore is - " + fScore);
    }
    public static int challenge(boolean gameOver, int score, int levelCompleted, int bonus){
	System.out.println("this is inside challenge methode");
    	int finalScore = score;
	if (gameOver){
	    finalScore += (levelCompleted * bonus);
	    System.out.println("your final score was " + finalScore);
	}
	return finalScore;
    }
}