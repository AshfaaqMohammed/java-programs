import check.ChildClass;
import default_dir.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        BaseClass parent =  new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredToBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("-".repeat(10));
        childReferredToBase.recommendedMethod();
        System.out.println("-".repeat(10));
        child.recommendedMethod();
        System.out.println("-".repeat(10));

        int[] temp = {1,2,3,4,5};
        System.out.println(temp.length);

        List<Integer> list = new ArrayList<Integer>();

        for (int ele: temp){
            list.add(ele);
        }

        System.out.println(list.contains(5));
        list.toArray();


        System.out.println(list);

        String a = "asdfa";
        String b = "bsdfa";
        System.out.println(a.compareTo(b));
}