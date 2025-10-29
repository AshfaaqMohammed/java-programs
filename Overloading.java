public class Overloading{
    public static void main(String[] args){
	firstMethod(20.00,40);
	firstMethod(40,20.00);
    }
    public static void firstMethod(double par2 ,int par1){
	System.out.println(par1);
	System.out.println(par2);
	System.out.println("this is in firstMethod");
    }
    public static void firstMethod(int par1, double par2){
	System.out.println(par1);
	System.out.println(par2);
	System.out.println("this is in secondMethod");
    }
	
}