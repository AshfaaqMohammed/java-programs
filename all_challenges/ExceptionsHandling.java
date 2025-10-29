public class ExceptionsHandling{

	public static void main(String[] args){
		
		int num1 = 9;
		int num2 = 0;

		try{
			int result = num1/num2;
		}catch (Exception e1){

			throw new CustomeException("this is a custome exception");

		}
		
	}

}

class CustomeException extends RuntimeException{

	
	public CustomeException(String message){
		super(message);
	}

}