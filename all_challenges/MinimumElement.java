import java.util.Scanner;
import java.util.Arrays;

public class MinimumElement {

    public static void main(String[] args){
	
	int inte = readInteger();
	int[] array = readElements(inte);
	System.out.println("Minimun element - " + findMin(array));
    
    }

    
    private static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        return size;
    }
    
    private static int[] readElements(int size){
        
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[size];
        
        for (int i=0;i<size;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        return arr;
        
    }
    
    private static int findMin(int[] arr){
        int minEle = Integer.MAX_VALUE;
        for (int ele : arr){
            if (ele<minEle){
                minEle = ele;
            }
            
        }
        return minEle;
    }
}