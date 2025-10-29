class Stove{

    private String name;
    private String model;

    public Stove(String name, String model){
	
	this.name = name;
	this.model = model;
    
    }

    public void StoveOn(){

	System.out.println("Stove is on fire");
    }

  }

    class Kitchen{
  
    private Stove stove;
    private int doors;

    public Kitchen(Stove stove, int doors){

	this.stove = stove;
	this.doors = doors;
    }

    public void startKitchen(){

	System.out.println(" you have entered the kitchen");
	stove.StoveOn();
	
    }


}




class Challenge_class{


    public static void main(String[] args){

	Stove stove = new Stove("prestige","new");
	
	Kitchen kitchen = new Kitchen(stove, 4);
	kitchen.startKitchen();

	String name = "ashfaaq";

	for (int i=0;i<name.length();i++){

 	    System.out.println(name.count(name[i]));
        }
	
	

}

}
