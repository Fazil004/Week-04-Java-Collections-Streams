// Defining a custom functional interface
@FunctionalInterface //Using Function interface Annotation this allows only one abstract method in the interface
interface Operation<T extends Number> { //Using Generics where a datatype extends subclasses of Number
    T calculate(T a, T b); // Single abstract method
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {

        // Lambda expression implementing the calculate method
        // Here it performs multiplication of two Integers
        Operation<Integer> multiply = (a, b) -> a * b;

        // Using the lambda
        int result = multiply.calculate(5, 4);
        System.out.println("Multiplication result: " + result); // Output: 20
    }
}

