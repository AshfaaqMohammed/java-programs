public abstract class ProductForSale {
    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description){
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalePrice(int quantity){
        return quantity * this.price;
    }

    public void printPriceItem(int quantity){
        System.out.printf("%d %s's =  $%.2f %n", quantity,this.type, getSalePrice(quantity));
    }
    public abstract void showDetails();
}

class Brush extends ProductForSale{
    public Brush(String type, double price, String description){
        super(type,price,description);
    }

    @Override
    public void showDetails(){
        System.out.println("-".repeat(5));
        System.out.printf("""
                Item %s - 
                    price - $%.2f
                    description - %s
                """,type,price,description);
        System.out.println("-".repeat(5));

    }

}
