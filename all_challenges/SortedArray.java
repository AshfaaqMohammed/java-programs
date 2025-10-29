import java.util.Scanner;
public class SortedArray {
    // write code here   
    public static void main(String[] args){

	int[] unsortedarray = getIntegers(5);
	int[] sortedarray = sortIntegers(unsortedarray);
	printArray(sortedarray);

    }
    
    public static int[] getIntegers(int size){
        Scanner scanner = new Scanner(System.in);
        int[] newarr = new int[size];
        
        for (int i=0;i<newarr.length;i++){
            newarr[i] = scanner.nextInt();
        }
        return newarr;
    }
    
    public static int[] sortIntegers(int[] array){
        int[] sortedArray = array;
        
        for (int i=0; i<sortedArray.length;i++){
            for (int j=i+1; j <sortedArray.length;j++){
                if(sortedArray[i] > sortedArray[j]){
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }

	int[] descarray = new int[sortedArray.length];
	int j = 0;
        
        for (int i=sortedArray.length-1;i>=0;i--){
            descarray[j] = sortedArray[i];
	    j++;
        }
        
        return descarray;
    }
    
    public static void printArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.println("Element " + (i+1) + " contents " + array[i]);
        }
    }
}
    
 