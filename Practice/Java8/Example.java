package Practice.Java8;

import java.util.*;
import java.sql.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Example {


    private record Employee( int id, String name, String department, double salary,Date date) { }


        public static void main(String[] args){

            List<Employee> employees = new ArrayList<>();

            employees.add(new Employee(1, "pritam", "It", 10000, Date.valueOf("2012-05-12")));
            employees.add(new Employee(3, "prita2", "MECH", 30000,Date.valueOf("2021-04-12")));
            employees.add(new Employee(4, "prita3", "CIVIL", 40000,Date.valueOf("2029-03-12")));
            employees.add(new Employee(5, "prita4", "It", 50000,Date.valueOf("2028-01-12")));
            employees.add(new Employee(2, "pritam1", "CSE", 20000,Date.valueOf("2015-10-12")));


            employees.stream().forEach( value ->
                    System.out.println(value.name));

            // salary less than 4

            List<String> name = employees.stream().filter(index -> index.salary <= 40000).map(Employee::name).toList();

            Collections.sort(employees, (a, b) -> Double.compare(a.salary(), b.salary()));
            System.out.println(" EMP11 : "+ employees);

            employees.sort(Comparator.comparingInt(Employee::id).reversed());

            System.out.println(" EMP : "+ employees);
            System.out.println("name : " + name);


            Map<String, Integer> map = new HashMap<>();

            map.put("abc1",10);
            map.put("abc2",20);
            map.put("abc3",30);
            map.put("abc4",40);

            for (Map.Entry<String,Integer> entry : map.entrySet()){
                System.out.println("entry " + entry.getKey() + " :: "+ entry.getValue());
            }
            Date maxDate = employees.stream().filter(Objects::nonNull).map(Employee::date).max(Comparator.naturalOrder()).orElse(null);
            System.out.println("Max Date" + maxDate);

            List<Employee> itEmployee = employees.stream().filter(employee -> employee.department.equalsIgnoreCase("IT")).toList();
            System.out.println("IT EMPloyee : "+ itEmployee);

            List<String> names = employees.stream().map(Employee::name).sorted().toList();
            System.out.println("Names : " + names);

            List<Double> salaryList = employees.stream().map(Employee::salary).sorted().toList();
            System.out.println("SALARY : "+salaryList);

            Predicate<Integer> predicate = (input) -> input % 2 == 0; // return boolean

            System.out.println("Value 12 % 2: "+predicate.test(12));

            Supplier<Integer> supplier = () -> 3*3;

            System.out.println("Supplier : "+supplier.get());

            AtomicInteger a = new AtomicInteger();
            Consumer<Integer> consumer = a::set;

            System.out.println(numSquares(12));

        }
    // "Design a system for processing high-frequency financial transactions efficiently and securely." This tests system design, scalability, concurrency, and security considerations—all crucial for financial applications.
    //Two LC Questions Medium, Medium. 1. Max Path Sum 2 Variation of Robot Return to Origin(Not Easy tagged on LC)
/*
Q: A prefix sum DSA question

Group Anagram and 3 Sum

What is the difference between Waterfall and Agile methodologies in software development?

Find the largest number of consecutive elements in an array such that the sum of those elements is less than n.

design spotify


It was a coderpad round where i got asked two questions 1.
The first one was to find out the max average score of a student when different students with different scores from different subjects are given.

2. The second one was to return true/false if a bishop on a chess board can reach a particular destination.

IP addresses and Tree nodes

Find the median for 2 different sorted arrays.

It was DSA round and they asked design a Cache?


 */
    static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = i;  // Worst case: all 1^2
            System.out.println("Calculating dp[" + i + "] starting value: " + dp[i]);

            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                int candidate = 1 + dp[i - square];
                if (candidate < dp[i]) {
                    System.out.println("  Trying square: " + square + ", candidate: " + candidate);
                    dp[i] = candidate;
                }
            }

            System.out.println("dp[" + i + "] = " + dp[i]);
        }

        return dp[n];
    }
}
