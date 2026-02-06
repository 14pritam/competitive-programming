package Practice.JAVA;

public interface sample2 extends sample{

    @Override
    default void m1() {
        sample.super.m1();
    }

    default void m3(){
        System.out.println("println");
    }
}

