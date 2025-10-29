package Sets;

import Challenge.Task;
import Challenge.TaskData;

import java.util.*;

public class main {
    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        printData("Emails",emails);

        List<Contact> phones = ContactData.getData("phone");
        printData("Phones",phones);

        NavigableSet<Contact> ph_trees = new TreeSet<>(phones);
        printData("Ph_trees",ph_trees);

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c->justNames.add(c.getName()));
//        justNames.forEach(System.out::println);


        NavigableSet<Contact> allContacts = new TreeSet<>(ph_trees);

//
        allContacts.addAll(emails);
        printData("After adding emails",allContacts);

//        Comparator<Contact> comparator = Comparator.comparing(Contact::getName);
//        List<Contact> fullList = new ArrayList<>(phones);
//        fullList.addAll(emails);
//        fullList.sort(ph_trees.comparator());
//        fullList.forEach(System.out::println);

        System.out.println("-----");
        System.out.println(Collections.min(allContacts));
        System.out.println(allContacts.first());

        List<String> check = new ArrayList<>(List.of("hi","bye","hi","there"));
        for (String j : check){
            System.out.println(j+"= "+j.hashCode());
        }
//        Set<Integer> newCheck = new HashSet<>();
//        newCheck.addAll(check);
//        System.out.println(newCheck);
//        Set<Integer> treeCheck = new TreeSet<>(check);
//        System.out.println(treeCheck);

        int[] newarr = {1,2,3,4};
        int[] samp = newarr;

        System.out.println(Arrays.toString(newarr));
        System.out.println(Arrays.toString(samp));

        List<Integer> eem = new ArrayList<>();







    }
    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        contacts.forEach(System.out::println);
    }

    private static void reverse(int[] arr){
        for(int ele : arr){
            System.out.println(ele);
        }

        int l = 0;
        int r = arr.length - 1;

        while (l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        for(int ele : arr){
            System.out.println(ele);
        }
    }


}
