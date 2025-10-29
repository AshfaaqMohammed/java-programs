class Temp{
	
	private int num;
	public Temp(int num){

		this.num=num;
	}

	public void printNum(){

		System.out.println(this.num);

	}

}

public class InternalRev{


	public static void main(String[] args){


		Temp temp = new Temp(10);
		temp.printNum();

		int[] array = {1,2,3,4,5};
		System.out.println(array[array.length/2]);
		

	}

	public static void main(String[] args){


		System.out.println("Hi this is second main");

	}


}
