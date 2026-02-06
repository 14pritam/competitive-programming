package Practice.Java8;

public class AnyonomusFunc {

    public void m1(){
        System.out.println("Normal Method");
    }

    // Instance initializer block
    {
        System.out.println("Anonymous method");
    }

    public static void main(String[] args){
        new AnyonomusFunc(); //
    }
}
