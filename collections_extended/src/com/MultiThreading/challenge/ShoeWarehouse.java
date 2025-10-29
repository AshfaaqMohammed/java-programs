package com.MultiThreading.challenge;

import java.util.ArrayList;
import java.util.List;

public class ShoeWarehouse {

    private List<Order> shippingItems;
    public final static String[] PRODUCT_LIST =
            {"Running shoes","Sandals","Boots","Slippers","High Tops"};

    public ShoeWarehouse(){
        this.shippingItems = new ArrayList<>();
    }

    public synchronized void receiveOrder(Order item){
        System.out.println("starting receiveOrder");
        while (shippingItems.size() > 20){
            try{
                System.out.println("in receive try");
                wait();
            }catch (InterruptedException e){
                throw  new RuntimeException(e);
            }
        }
        shippingItems.add(item);
        System.out.println("Incoming order: " + item);
        notifyAll();
    }

    public synchronized Order fullFillOrders(){
        System.out.println("Starting fullfillorder");
        while (shippingItems.isEmpty()){
            try {
                System.out.println("in fullfill try");
                wait();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        Order out = shippingItems.remove(0);
        System.out.println("Fulfilled: "+ out);
        return out;

    }
}
