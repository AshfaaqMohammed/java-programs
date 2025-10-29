import java.util.*;

public class Assig6{

	public static void main(String[] args){

		ArrayList<Integer> input = new ArrayList<>(List.of(4,1,9,4,8,0,5,8,1,8,6));
		System.out.println(input);
		int num = 0;
		int fcount = 0;

		for (int i=0;i<input.size();i++){

			int count=1;
			for (int j=i+1; j< input.size(); j++){
				if (input.get(i) == input.get(j)){

					count++;
				}
						}
			if (fcount < count){

				fcount = count;
				num = input.get(i);
			}		

		}

		System.out.println(num);
		System.out.println(fcount);
		

	}


}