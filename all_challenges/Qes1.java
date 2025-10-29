import java.util.*;
import java.lang.*;
public class Qes1{


	public static void main(String[] args){

		
		ArrayList<Integer> list = new ArrayList<>(List.of(40, 50, 90, 70, 54, 32));
		
		System.out.println(list);
		
		int high = 0;

		for(int i=0; i<list.size(); i++){
			
			if (high < list.get(i)){

				high = list.get(i);
			}
			
		}
		
		System.out.println(high);

		int secHigh = 0;
		int temp = high - list.get(0);

		for (int i=1;i<list.size(); i++){
			
			int diff = high - list.get(i);

			if (diff !=0 && diff <= temp ){
				
				temp = diff;

				secHigh = list.get(i);

			}

		}

		System.out.println(secHigh);
		
	}


}