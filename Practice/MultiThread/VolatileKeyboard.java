package Practice.MultiThread;

import java.util.concurrent.atomic.AtomicInteger;

class SharedResource{
    private volatile boolean flag = false;

    // public synchronized
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


class SharedCounter{
/*
 race condition
    private int count;

    public  void increment() {
         count++;
    }

    public  int getCount() {
       return count;
    }
    */

    private static AtomicInteger count ;

    public  static void increment() {
        System.out.println("No Need for Locks");
        synchronized(SharedCounter.class) {
            count.getAndIncrement();
        }
    }

    public  int getCount() {
        return count.get();
    }

}
public class VolatileKeyboard {

    public static void main(String[] args) throws Exception{

        SharedResource sharedResource = new SharedResource();

        new Thread(()->{
            try{
                System.out.println("Thread 1 Logic Started");
                Thread.sleep(1000);
                System.out.println("Thread 1 Logic Completed");
                sharedResource.setFlag(true);
                System.out.println("Flag set by Thread 1");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }).start();


        new Thread(()->{
            try{
                System.out.println("Thread 2  Logic Started");
                while (!sharedResource.isFlag()){

                }
                System.out.println("Thread 2 Logic completed");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }).start();

        // visibility problem waiting for flag = true and so it keeps on running

        // to solve visiblity problem use Synchronized keyword
        // as soon as it updated put back that in main memory


        //
        System.out.println("-------Race Condition --------");
        SharedCounter sharedCounter = new SharedCounter();
        new Thread(()->{
            System.out.println("Thread 3 Logic Started ");
           for(int i = 0 ; i < 50000 ; i++){
               sharedCounter.increment();
           }
            System.out.println("Thread 3 Completed ");
        }).start();

        new Thread(()->{
            System.out.println("Thread 4 Logic Started ");
            for(int i = 0 ; i < 50000 ; i++){
                sharedCounter.increment();
            }
            System.out.println("Thread 4 Completed ");
        }).start();

        System.out.println("Thread Count : " +sharedCounter.getCount());
    }

}
