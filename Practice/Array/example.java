package Practice.Array;

class Address {
    String city;
    Address(String city) {
        this.city = city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // does not clone Address
    }
}

public class example {
    public static void main(String[] args) throws Exception {
        Address addr = new Address("Kolkata");
        Person p1 = new Person("Ram", addr);
        Person p2 = (Person) p1.clone();
        System.out.println(p1.address.city); // Output: Kolkata

        p2.name = "Shyam";
        p1.address.city = "Delhi"; // modifies p1's city too

        System.out.println(p1.address.city); // Output: Delhi ❌
    }
}
