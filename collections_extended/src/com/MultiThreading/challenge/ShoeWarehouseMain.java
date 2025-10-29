package com.MultiThreading.challenge;


import java.util.Random;
import java.util.concurrent.Executors;

record Order(long orderId, String item, int qty){};

public class ShoeWarehouseMain {

    private static final Random random = new Random();

    public static void main(String[] args) {

        ShoeWarehouse shoeWarehouse = new ShoeWarehouse();

        Thread producerThread = new Thread(() -> {
           for (int j = 0;j<3;j++){
               shoeWarehouse.receiveOrder(new Order(
                       random.nextInt(20,5000000),
                       ShoeWarehouse.PRODUCT_LIST[random.nextInt(0,ShoeWarehouse.PRODUCT_LIST.length)],
                       random.nextInt(2,5)
               ));
           }
        });

        Thread consumerThread = new Thread(() -> {
           for(int i=0; i< 3;i++){
               Order item = shoeWarehouse.fullFillOrders();
               System.out.println(item);
           }
        });
//
//        producerThread.start();
//        consumerThread.start();
        var receiveExecutor = Executors.newSingleThreadExecutor();
        receiveExecutor.execute(producerThread);
        var fullFillExecutor = Executors.newSingleThreadExecutor();
        fullFillExecutor.execute(consumerThread);

        receiveExecutor.shutdown();
        fullFillExecutor.shutdown();
    }

}
