import java.util.*;
public class Test{

   public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);
	String name = scanner.nextLine();
	Test.getChar(name);


   }

   public static void getChar(String name){

	System.out.println("Number of elements in " + name + " is = " + name.length());
   }

}


abstract class call
