import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AutoboxingChallenge {
    record Customer(String name, ArrayList<Double> statement){
        public Customer(String name, double initialDeposit){
            this(name, new ArrayList<Double>(500));
            statement.add(initialDeposit);
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", statement=" + statement +
                    '}';
        }
    }

    public static void main(String[] args) {
        ArrayList<Customer> customer = new ArrayList<>();
//        customer.add(new Customer("adi",200));
//        customer.add(new Customer("sumit",500));
//        System.out.println(customer);
        Bank bank = new Bank("chase");
        bank.addCustomer("venkat",200.00);
        System.out.println(bank);
//        bank.addCustomer("venkat",501.00);
//        ArrayList<Double> amount = new ArrayList<>(List.of(100.00,-200.00,-50.00,-100.00,-300.00));
//        for (double each : amount){
//            bank.addTransactions("venkat",each);
//        }
//        bank.printStatement("venkat");

        Bank bank2 = new Bank("HDFC");
        bank2.addCustomer("venkat",100);
        System.out.println(bank2);
//        System.out.println(bank);
//        System.out.println(customer);
    }
}

class Bank{
    private String name;
    private ArrayList<AutoboxingChallenge.Customer> customers = new ArrayList<>(5000);

    public Bank(String name){
        this.name = name;
    }

    private AutoboxingChallenge.Customer getCustomer(String customerName){
        for (var cus : customers){
            if (cus.name().equalsIgnoreCase(customerName)){
                return cus;
            }
        }
        System.out.printf("Customer %s wasn't found%n", customerName);
        return null;
    }

    public void addCustomer(String name, double initialDeposit){
        if (getCustomer(name) == null){
            customers.add(new AutoboxingChallenge.Customer(name, initialDeposit));
        }else{
            System.out.printf("Customer - %s is already in records %n",name);
        }
    }

    public void addTransactions(String name, double initialDeposit){
        AutoboxingChallenge.Customer customer = getCustomer(name);
        if (customer != null){
            customer.statement().add(initialDeposit);
        }
    }

    public void printStatement(String name){
        AutoboxingChallenge.Customer customer = getCustomer(name);
        if (customer == null){
            return;
        }
        System.out.println("-".repeat(20));
        System.out.println("Customer name - " + name);
        System.out.println("Transactions: ");
        double tsum = 0;
        for (var cust : customer.statement()){
            System.out.printf("$%10.2f (%s)%n",cust,cust<0?"Debit":"credit");
            tsum+=cust;
        }
        System.out.println("-".repeat(20));
        System.out.printf("$%10.2f %n",tsum);
    }



    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
