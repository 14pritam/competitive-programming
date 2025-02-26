package Practice.MultiThread;

class MyThread extends Thread{
    public  void run(){
        System.out.println("Thread 1 is running");
    }
}

public class ThreadExample {

    public static Object sharedObject = new Object();

    public static void main(String[] args){

        System.out.println(" Hello World! ");
        MyThread objThread1 = new MyThread(); // Legacy Code
        objThread1.start();

        // thread 2
        Thread objThread2 = new Thread(() ->
        {
            System.out.println("Thread 2 is running");
        });
        objThread2.start();

        // thread 3
        Runnable objRunnable = () ->{
            System.out.println("Thread 3 is running");
        };

        Thread objThread3 = new Thread(objRunnable,"Runnable Thread 3 ");
        objThread3.start();

        // functional Interface have only one abstract method;

        // thread4
        Runnable objRunnable1 = () ->{
            System.out.println("Thread 4 is running");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());;
            System.out.println(sharedObject.hashCode());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 4 is completed");
        };

        Thread objThread4 = new Thread(objRunnable1,"Runnable Thread 4 ");
        objThread4.setDaemon(true); // Main Thread is not waiting for daemon thread to complete.
        objThread4.start();

        System.out.println("Main Thread Ended");


        Runnable objRunnable2 = () ->{
            System.out.println("Thread 5 is running");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());;
            System.out.println(sharedObject.hashCode());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 5 is completed");
        };
        Thread objThread5 = new Thread(objRunnable2,"Runnable Thread 5 ");
        objThread5.start();


    }
}
