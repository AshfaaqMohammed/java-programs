class Circle {
    // write code here
    private double radius;
    
    public Circle(double radius){
        this.radius = radius<0 ? 0 : radius;
    }
    
    public double getRadius(){
        return this.radius;
    }
    
    public double getArea(){
        return (this.radius*this.radius*Math.PI);
    }
    
}

class Cylinder extends Circle {
    // write code here
    private double height;
    
    public Cylinder(double radius, double height){
        super(radius);
        this.height = height<0 ? 0 : height;
    }
    
    public double getHeight(){
        return this.height;
    }
    
    public double getVolume(){
        return super.getArea() * this.height;
    }
    
}


public class Inheritence_Chall{
    public static void main(String[] args){
	
	Circle circle = new Circle(3.75);
	System.out.println("circle.radius= " + circle.getRadius());
	System.out.println("circle.area= " + circle.getArea());
	Cylinder cylinder = new Cylinder(5.55, 7.25);
	System.out.println("cylinder.radius= " + cylinder.getRadius());
	System.out.println("cylinder.height= " + cylinder.getHeight());
	System.out.println("cylinder.area= " + cylinder.getArea());
	System.out.println("cylinder.volume= " + cylinder.getVolume());
    }
}