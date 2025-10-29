public class StringCommands{
    
    public static void main(String[] args){
    
  	String word = "word is happy";
	// String word2 = "";
	// String word3 = "\t \n  ";
	// stringInspection(word);
	// stringInspection(word2);
	// stringInspection(word3);
	stringComparison(word);
	
    }

    public static void stringInspection(String word){
	System.out.println(word.length());
	if (word.isEmpty() == true){
	    System.out.println("string is emplty");
	    return;
	}
	if (word.isBlank() == true){
	    System.out.println("string is blank");
	    return;
	}
	System.out.println(word.charAt(2));
	System.out.println(word.indexOf("p"));
	System.out.println(word.isBlank());
    }

    public static void stringComparison(String word){
	
	System.out.println(word.contains("happy"));
    }

}