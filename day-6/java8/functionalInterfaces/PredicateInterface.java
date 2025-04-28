import java.util.function.Predicate;

public class PredicateInterface {
    public static void main(String[] args) {

        // Predicate to check if a number is even
        Predicate<Integer> isEven = n -> n % 2 == 0; //Boolean valued function

        // Testing the predicate
        System.out.println("Is 10 even? " + isEven.test(10)); // true
        System.out.println("Is 7 even? " + isEven.test(7));   // false

        // Another Predicate: checks if a string starts with "A"
        Predicate<String> startsWithA = s -> s.toLowerCase().startsWith("a") ;
        Predicate<String> endWithB = s -> s.toLowerCase().endsWith("y") ;

        Predicate <String> and= startsWithA.or(endWithB);
        System.out.println("Starts with A? 'Apple' -> " + startsWithA.test("Apple")); // true
        System.out.println("Starts with A? 'Banana' -> " + endWithB.test("Banana")); // false

        System.out.println(and.test("AkshayB"));//Using Both the Predicate to check the string
    }
}

