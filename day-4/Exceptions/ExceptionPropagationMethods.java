public class ExceptionPropagationMethods {

    public static void method1() {
        System.out.println("Inside method1");
        int result = 10 / 0; //ArithmeticException
        System.out.println("This line will not be reached");
    }

    public static void method2() {
        System.out.println("Inside method2");
        method1();
        System.out.println("This line will not be reached in method2");
    }

    public static void main(String[] args) {
        System.out.println("Inside main");
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");

        }
        System.out.println("Exiting main");
    }
}