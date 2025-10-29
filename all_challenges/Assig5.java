import java.util.*;

public class Assig5{


    public static void main(String[] args){


	String[] elements = {"baby","ball","soap","baby","shampoo","chalk","soap","makeup","baby", "lotion"}; 
	ArrayList<String> input = new ArrayList<>(List.of(elements));

	System.out.println(input);
	
	int[] positions = new int[input.size()];
	ArrayList<String> check = new ArrayList<>();

	for (int i=0; i<input.size(); i++){

	    if (check.contains(input.get(i))){
		continue;
	    }

	    int count = 1;
	    
	    for (int j=i+1; j<input.size(); j++){
		
		if (input.get(i) == input.get(j)){
		    
		    count++;
		
		}

	    }
	    positions[i] = count;
	    check.add(input.get(i));

	}

	for(int i = 0; i<positions.length; i++){

	    if (positions[i] != 0 && positions[i] != 1){
		System.out.println(input.get(i) + " - " + positions[i]);
		
	    }

	}

    }


}

