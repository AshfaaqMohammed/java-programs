
import java.util.*;

public class Review3{

	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args){

		Thread thread1 = new Thread(() -> {

			synchronized(lock1){
				System.out.println("thread1 is locked lock1");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){

					throw new RuntimeException(e);
				}
				synchronized(lock2){
					System.out.println("thread1 is locked lock2");
				}

			}
			
		});


		Thread thread2 = new Thread(() -> {

			synchronized(lock2){
				System.out.println("thread2 is locked lock2");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){

					throw new RuntimeException(e);
				}
				synchronized(lock1){
					System.out.println("thread2 is locked lock2");
				}

			}
			
		});

		thread1.start();
		thread2.start();
		
	
	}


}