import java.util.*;

public class Assig9{

	public static void main(String[] args){

		int upperLimit = 50;

		List<Integer> primes = new ArrayList<>();
		
		for (int i=2;i<=upperLimit; i++){

			Boolean isPrime = true;
			
			for (int j=2; j<i/2; j++){

				if (i%j == 0){
					isPrime = false;
					break;
				
				}
			}
			if(isPrime){
				primes.add(i);
			}
			
		}
		System.out.println(primes);


	}


}
