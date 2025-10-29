import java.util.HashMap;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMaps {

    public static void main(String[] args) {

        HashMap<Integer,String> map = new HashMap<>();

        map.put(1,"sumith");
        map.put(2,"adil");
        map.put(3,"aman");
        map.put(4,"srinivas");
        System.out.println(map);

        String student = map.get(3);
        System.out.println(student);

        System.out.println(map.containsKey(4));
        System.out.println(map.containsValue("sumith"));

        for (String i : map.values()){
            System.out.println(i);
        }

        for (int i: map.keySet()){
            System.out.println(i);
        }

        System.out.println("-".repeat(10));
        for (int i=0;i<map.size();i++){
            System.out.println(map.get(i));
        }
        System.out.println("-".repeat(10));


        for (Map.Entry<Integer,String> entry : map.entrySet() ){
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }

        String name = "ashfaaq";
        Map<Character,Integer> dic = new HashMap<>();
        for (char c : name.toCharArray()){
            if (dic.containsKey(c)){
                dic.replace(c,dic.get(c),dic.get(c)+1);
            }else{
                dic.put(c,1);
            }
        }
        System.out.println(dic);

        Map<Person, String> new_map = new HashMap<>();
        Person p1 = new Person("Sumith",1);
        Person p2 = new Person("Aman",2);
        Person p3 = new Person("sumith",1);

        new_map.put(p1,"Ceo");
        new_map.put(p2,"CTO");
        new_map.put(p3,"CFO");

        System.out.println(new_map);

        Map<Integer,String> temp_map = new TreeMap<>();
        temp_map.put(2,"temp1");
        temp_map.put(1,"temp1");
        temp_map.put(4,"temp1");

        System.out.println(temp_map);
        System.out.println(isPalindrome(11));



        String s = "aabbcddeff";

        HashMap<Character,Integer> oMap = new HashMap<>();

        for (int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if (map.containsKey(temp)){
                map.replace(temp,map.get(temp),map.get(temp)+1);
            }else{
                map.put(temp,1);

            }
        }

        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                System.out.println("1st ele of non repeating - " + entry.getKey());
                break;
            }
        }




    }
    public static boolean isPalindrome (int number){
        int tempNum = number;
        int checkNum = 0;
        int temp1 = 0;
        while (tempNum!=0){
            temp1 = tempNum%10;
            checkNum = temp1 + checkNum*10;
            tempNum = tempNum/10;

        }
        System.out.println("Check num = "+checkNum);
        System.out.println(checkNum == number);
        if (checkNum == number){
            return true;
        }
        return false;
    }
}

class Person{
    private String name;
    private int id;

    public Person(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "%d %s ".formatted(id,name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (this.getClass() != o.getClass()){
            return false;
        }
        Person other = (Person) o;
        return id == other.getId() && Objects.equals(name,other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,id);
    }
}
