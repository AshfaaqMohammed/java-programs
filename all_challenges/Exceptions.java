public class Exceptions{


	public static void main(String args[]){


		int a = 2;
		int b = 3;
		String name = null;

		try{
			int c =a +b;
			System.out.println(name.length());

		}catch (NullPointerException ne){


			System.out.println("this is null pointer exception");

		}

	}


}