import java.util.ArrayList;

record OrderItem(int quantity, ProductForSale productList){

}
public class Store {
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();
    public static void main(String[] args) {
        storeProducts.add(new Brush("Colgate brush",15,"cheap and best"));
        storeProducts.add(new Brush("sensodaine brush",20,"this is brush is best for sensitive gums."));
        listProducts();

        ArrayList<OrderItem> allOrders = new ArrayList<>();
        addItemToOrder(allOrders,1,10);
        addItemToOrder(allOrders,0,5);
        printOrder(allOrders);
    }

    public static void listProducts(){
        for (var item: storeProducts){
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty){
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> orders){
        double salesTotal = 0;
        for (var order : orders){
            order.productList().printPriceItem(order.quantity());
            salesTotal += order.productList().getSalePrice(order.quantity());
        }
        System.out.printf("Sales Total = $%.2f %n",salesTotal);
    }

}
