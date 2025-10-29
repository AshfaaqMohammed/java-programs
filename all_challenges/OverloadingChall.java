public class OverloadingChall{

    public static void main(String[] args){
	
	//double cm = convertToCentimeter(5,10);
	System.out.println(getDurationString(65,25));
	
    }
	
    public static double convertToCentimeter(int inches){

	return 2.54 * inches; 
    }

    public static double convertToCentimeter(int feet, int inches){

    	int totalInches = inches + (feet * 12);
	double inCm = convertToCentimeter(totalInches);
	System.out.printf("%d'%d in centimeters = %f",feet,inches,inCm);
	return inCm;
    }

    public static String getDurationString(int seconds){

	int minute = seconds/60;
	int hour = minute/60;

	int remainingMinute = minute % 60;
	int remainingSeconds = seconds % 60;

	return "%dh %dm %ds".formatted(hour,remainingMinute, remainingSeconds);
    }

    public static String getDurationString(int min, int seconds){
	
	int totalSec = min*60 + seconds;
	String ans = getDurationString(totalSec);
	return ans;
	
    }

}