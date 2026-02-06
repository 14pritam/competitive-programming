package Practice.JavaBasics;

import java.util.Arrays;
import java.util.List;

public class sampleTest {

    public static void main(String[] args){

        try {
            System.out.println("Try");
            int a = 5/0;
        }catch (ArithmeticException exception){
            System.out.println("Catch");
        } finally{
            System.out.println("Finally");
        }


        List<Integer> list = Arrays.asList(14,15,17,18,19,20,21);

        // find max
        int max = list.stream().max(Integer::compareTo).get();

        int min = list.stream().min(Integer::compareTo).get();

        System.out.println("MAX : "+max);
        System.out.println("MIN : "+min);

        boolean anyMatch = list.stream().anyMatch(value  -> value % 2 == 0);

        boolean allMatch = list.stream().allMatch(value  -> value % 2 == 0);

        boolean nonMatch =  list.stream().noneMatch(value  -> value % 2 == 0);

        System.out.println("AnyMatch : "+anyMatch);
        System.out.println("AllMatch : "+allMatch);
        System.out.println("nonMatch : "+nonMatch);


    }
}
