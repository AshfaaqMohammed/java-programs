import java.util.*;

abstract class sumith{
    abstract void printName();
}

public class Rough extends sumith{
    public static void main(String[] args){

        char[] pf = {'!','r','e','s','e'};
        System.out.println(String.valueOf(pf));

        String name = "ashfaaq";
        name = name.replace("a","");
        System.out.println(name);

        int[] nums = {2,4,4};
        int target = 8;
        List<Integer> new_nums = new ArrayList<>();
        for (int ele : nums){
            new_nums.add(ele);
        }
        System.out.println(new_nums);

        for (int i=0; i<nums.length; i++){

            int temp_target = target - new_nums.get(i);

            if((new_nums.contains(temp_target))  && (new_nums.indexOf(new_nums.get(i)) != new_nums.lastIndexOf(temp_target))){
                int[] ans = {new_nums.indexOf(new_nums.get(i)),new_nums.lastIndexOf(temp_target)};
                System.out.println(Arrays.toString(ans));

            }

        }

        int[] arr = {1,3,2,4,8,5};
        Arrays.sort(arr);
        System.out.println(Arrays.binarySearch(arr,3));

        for (int i = 0; i<arr.length/2; i++){
            int t = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = t;
        }
        System.out.println(Arrays.toString(arr));
        String words = "sumith is very good boy, sumith.info is info, sumith,aman are friends";
        String[] list = words.split(" ");
        ArrayList<String> lst = new ArrayList<>(List.of(list));
        System.out.println(lst);

        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i=0;i<name.length();i++){
            if (map.containsKey(name.charAt(i))){
                map.replace(name.charAt(i),map.get(name.charAt(i))+1);
            }else{
                map.put(name.charAt(i),1);
            }
        }
        System.out.println(map);
        for (Character i : map.keySet()){
            if (map.get(i) == 1){
                System.out.println(i);
                break;
            }
        }


        String[] places = {"infor","test","indonasia","tagore","calcutta","chennai","tamilnamdu"};
//        Set<String> new_places = new TreeSet<>(List.of(places));
//        System.out.println(new_places);
        Arrays.sort(places);
        System.out.println(Arrays.toString(places));


        List<Integer> list1 = new ArrayList<>(List.of(new Integer[]{1, 2, 3, 4, 5}));
        System.out.println(Collections.max(list1));
        System.out.println(Collections.binarySearch(list1,5));

        Rough rough = new Rough();
        rough.printName();






    }
    @Override
    public void printName(){
        String names = "ashfaaq";
        for(int i=0; i<names.length();i++){
            System.out.println(names.charAt(i));
        }
    }

}