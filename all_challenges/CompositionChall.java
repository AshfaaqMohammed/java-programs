public class CompositionChall{

public static void main(String[] args){

Wall wall1 = new Wall("West");
Wall wall2 = new Wall("East");
Wall wall3 = new Wall("South");
Wall wall4 = new Wall("North");
 
Ceiling ceiling = new Ceiling(12, 55);
 
Bed bed = new Bed("Modern", 4, 3, 2, 1);
 
Lamp lamp = new Lamp("Classic", false, 75);
 
Bedroom bedRoom = new Bedroom("YOUR NAME HERE", wall1, wall2, wall3, wall4, ceiling,bed, lamp);
bedRoom.makeBed();
 
bedRoom.getLamp().turnOn();

}

}

class Lamp {
    // write code here
    private String style;
    private boolean battery;
    private int globRating;
    
    public Lamp(String style, boolean battery, int globRating){
        this.style = style;
        this.battery = battery;
        this.globRating = globRating;
    }
    
    public void turnOn(){
        System.out.println("Lamp is beging turned on");
    }
    
    public String getStyle(){
        return style;
    }
    
    public boolean isBattery(){
        return battery;
    }
    
    public int getGlobRating(){
        return globRating;
    }
}

class Bed{
    // write code here
    private String style;
    private int pillows;
    private int height;
    private int sheets;
    private int quilt;
    
    public Bed(String style, int pillows, int height, int sheets, int quilt){
        this.style = style;
        this.pillows = pillows;
        this. height = height;
        this.sheets = sheets;
        this.quilt =quilt;
    }
    
    public void make(){
        System.out.println("Bed is being made.");
    }
    
    public String getStyle(){
        return this.style;
    }
    
    public int getPillows(){
        return this.pillows;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getSheets(){
        return this.sheets;
    }
    public int getQuilt(){
        return this.quilt;
    }    
}


class Ceiling {
    // write code here
    private int height;
    private int paintedColor;
    
    public Ceiling(int height, int paintedColor){
        this.height = height;
        this.paintedColor = paintedColor;
    }
    
    private int getHeight(){
        return this.height;
    }
    
    private int getPaintedColor(){
        return this.paintedColor;
    }
}

class Wall {
    // write code here
    private String direction;
    
    public Wall(String direction){
        this.direction = direction;
    }
    
    public String getDirection(){
        return this.direction;
    }
    
}

class Bedroom {
    // write code here
    private String name;
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;
    
    public Bedroom(String name, Wall wall1, Wall wall2, Wall wall3, Wall wall4, Ceiling ceiling, Bed bed, Lamp lamp){
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;   
    }   
    public Lamp getLamp(){
            return lamp;
        }
        
        public void makeBed(){
            bed.make();
            System.out.println("Bed is being made!!");
        }
}
