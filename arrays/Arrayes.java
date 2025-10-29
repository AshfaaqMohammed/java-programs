import java.util.Arrays;
public class Arrayes{
    
    public static void main(String[] args){
	
	int[] myArray = new int[]{10,20,30,40,50};
	// myArray[3] = 30;
	// System.out.println(Arrays.toString(myArray));
	// System.out.println(myArray[2]);
	// System.out.println(myArray[3]);
	for (int i=0; i<myArray.length;i++){
	    System.out.println(myArray[i]);
	}
	System.out.println();
	for (int element : myArray){
	    System.out.print(element + " ");
	}
    }

}