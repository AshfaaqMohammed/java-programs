import java.util.Scanner;

public class Input{
    public static void main(String[] args){
        String name = System.console().readLine("Whats your name? ");
	System.out.println("welcome aboard " + name);

	System.out.println("-".repeat(10));
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("whats your name?");
	String new_name = scanner.nextLine();
	System.out.println("welcome aboard " + new_name);
    }
}