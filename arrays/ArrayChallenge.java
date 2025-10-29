import java.util.*;
public class ArrayChallenge{
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);

	ArrayList<String> grocery = new ArrayList<>();       

	String instructions = """
Available Shortcuts:
	0 - to shutdown
	1 - to add item(s) to list (comma delimited list)
	2 - to remove any item (comma delimited list)
	Enter a number for which action you want to do: """;
	System.out.println(instructions);
	boolean flag = true;
	String user_data = "";
	

	while(flag){
	    switch (scanner.nextLine()){
	        case "1":
		    System.out.println("Enter the data - ");
		    user_data = scanner.nextLine();
		    if (grocery.contains(user_data)){
			System.out.println("grocery already contains the item");
		    }else{
			grocery.add(user_data);
			grocery.sort(Comparator.naturalOrder());
			System.out.println(grocery);
		    }    
		    break;
	        case "2":
		    System.out.println("Enter the data - ");
		    user_data = scanner.nextLine();
		    if (grocery.contains(user_data)){
			grocery.remove(user_data);
			grocery.sort(Comparator.naturalOrder());
			System.out.println(grocery);
		    }else{
			System.out.println("There is no such data in grocery");
		    }    
		    break;
		default:
		    flag = false;
	    }
	}
	System.out.println(grocery);
    }
}