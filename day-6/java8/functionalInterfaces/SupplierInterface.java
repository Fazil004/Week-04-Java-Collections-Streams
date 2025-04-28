import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args){
        //No parameters Passed
        Supplier<String> returns=()->"Hello World";// Return without taking any Input

        System.out.println(returns.get());
    }
}
