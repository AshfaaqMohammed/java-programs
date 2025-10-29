import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int [] arr = {7,7,7,1,1,7};
        int [] new_arr = new int[arr.length];
        int idx = arr.length - 1;
        int new_idx = 0;

        for (int i=0;i<arr.length;i++){
            if (arr[i] == 1){
                new_arr[idx] =arr[i];
                idx --;
            }else{
                new_arr[new_idx] = arr[i];
                new_idx++;
            }
        }
        System.out.println(Arrays.toString(new_arr));
    }
}