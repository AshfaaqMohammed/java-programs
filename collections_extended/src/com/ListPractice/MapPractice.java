package com.ListPractice;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*

    Major Operations -
        1. Creation of a map
        2. addition of element into the map - .put(key, value)
        3. retrieval of keys from the map - .keySet()
        4. retrieval of values from the map - .values()
        5. deletion of elements from the map - .remove(key)
        6. verification of keys in the map - .containsKey(key)
        7. verification of values in the map - .conatainsValue(value)
        8. updation of elements in the map. - .replace()

 */



public class MapPractice {

    public static void main(String[] args){

        // creation of a map
        Map<Integer, String> map = new Hashtable<>();

        // Addition of elements into the map
        map.put(500085,"Hyderabad");
        map.put(603103,"Chennai");
        map.put(123456, "Delhi");

        // Retrieval of keys from the map
        Set<Integer> keys = map.keySet();

        for (Integer key : keys){
            System.out.println(key);
        }

        ConcurrentHashMap<Integer,Integer> old_map = new ConcurrentHashMap<>();
        old_map.put(1,3);
        old_map.put(2,4);
        old_map.put(3,1);

        for (Integer value : old_map.keySet()){
            System.out.println(value);
            old_map.put(4,7);
        }
        System.out.println(old_map);

        System.out.println("-".repeat(10));

        // Retrieval of values from the map
        Collection<String> values = map.values();

        for (String value : values){
            System.out.println(value);
        }

        System.out.println("-".repeat(10));

        // Retrieval of value from the map based on key
        System.out.println(map.get(500085));

        // Deletion of element from the map
        System.out.println(map);
//        map.remove(123456);
//        System.out.println(map);

        //verification of keys in map
        System.out.println(map.containsKey(123456));

        // verification of value in map
        System.out.println(map.containsValue("hyderabad"));

        //updation of entry in map
        map.replace(123456,"Mumbai");
        System.out.println(map);

        //Entry set
        Set<Map.Entry<Integer,String>> entries = map.entrySet();
        for (Map.Entry<Integer,String> entry : entries){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));

    }

    public static int[] twoSum(int[] array, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<array.length;i++){
            map.put(array[i],i);
        }
        System.out.println(map);
        for (int i=0;i<array.length;i++){
            int find = target - array[i];
            if (map.containsKey(find) && map.get(find) != i){
                return new int[]{i,map.get(find)};
            }
        }
        return null;

    }


}
