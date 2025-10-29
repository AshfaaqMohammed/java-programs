import java.util.*;

public class NewArray {
    public static void main(String[] args) {

//        int[] new_array = getArray(5);
//        System.out.println(Arrays.toString(new_array));
//        Arrays.sort(new_array, Collections.reverseOrder());
//        System.out.println(Arrays.toString(new_array));
//        int [] new_array = getElements(5);
//        System.out.println(Arrays.toString(new_array));
//        System.out.println(findMin(new_array));


        int [][] twoDimArray = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        for (var element : twoDimArray){
            System.out.println(Arrays.toString(element));
        }

        for (int i=0; i < twoDimArray.length; i++){
            var subArray = twoDimArray[i];
            for (int j=0; j < subArray.length;j++){
                System.out.printf("i - %d, j - %d%n",i,j);
                System.out.println(twoDimArray[i][j]);
            }
        }

    }
    private static int[] getArray(int len){
        Random random = new Random();
        int [] myArray = new int[len];

        for (int i=0;i < len; i++){
            myArray[i] = random.nextInt(100);
        }
        return myArray;

    }
    private static int[] getElements(int len){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value");
        int[] myArray = new int[len];

        for (int i=0;i< len; i++){
            int temp = Integer.parseInt(scanner.nextLine());
            myArray[i] = temp;
        }
        return myArray;
    }
    private static int findMin(int[] tempArray){
        int tmin = Integer.MAX_VALUE;
        System.out.println(tmin);
        for (int i=0; i<tempArray.length;i++){
            if ( tempArray[i] < tmin){
                tmin = tempArray[i];
            }
        }
        return tmin;
    }
}
