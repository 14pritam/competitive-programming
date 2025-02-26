package Practice.JavaBasics;

/**
 * keeping try catch inside and Outside the Loop . Does it have any impact . 
 * 
 *  If there are not many code errors, there is almost no difference between putting try-catch inside and outside the for loop.
 */
public class TrycatchQuestion {

        public static void main(String[] args) {
            Runtime runtime = Runtime.getRuntime();
            long startMemory = runtime.totalMemory() - runtime.freeMemory();
            for (int i = 0; i < 100000; i++) {
                try {
                    if (i > 2) {
                        // If there is a problem with this batch of data and all of them are abnormal situations,
                        // this means that nearly 100,000 exceptions will be thrown.
                        int num = i / 0;
                    } else {
                        System.out.println("success, i:" + i);
                    }
                } catch (Exception e) {
                    System.out.println("An exception occurs.");
                }
            }
            long endMemory = runtime.totalMemory() - runtime.freeMemory();
            long memoryUsed = endMemory - startMemory;
            System.out.println("memoryUsed: " + memoryUsed + " byte");
        }
}
    

