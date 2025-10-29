public class Methods{
    public static void main(String[] args){
	String playerName = "Hamilton";
	double playerScore = 123.4;
	int playerPosition = calculateHighScore(playerScore);
	displayHighScore(playerName, playerPosition);
    }
    public static void displayHighScore(String playerName,int playerPosition){
	System.out.println(playerName + " managed to get into position " + playerPosition + " on the high score list");
    }
    public static int calculateHighScore(double playerScore){
    	if (playerScore >= 1000){
	    return 1;
	}
	else if (500 <= playerScore && playerScore < 1000){
	    return 2;
	}
	else if (100 <= playerScore && playerScore < 500){
	    return 3;
	}
	else{
	    return 4; 
	}
    }
}