import java.util.*;

public class Assig7{

	public static void main(String[] args){

		ArrayList<Integer> input = new ArrayList<>(List.of(1,1,1,2));
		System.out.println(input);

		ArrayList<Integer> output = new ArrayList<>();
		
		for (int i=0; i<input.size();i++){

			int count = 0;

			for (int j=0;j<input.size();j++){

				if (input.get(i) == input.get(j)){

					count++;
				}
			}

			if (count == 1){

				output.add(input.get(i));
			}
		}

		System.out.println(output);

		
	}

}