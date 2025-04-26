public class UsernameValidator {
    public static boolean validateUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        System.out.println("user_123: " + validateUsername("user_123"));
        System.out.println("123user: " + validateUsername("123user"));
        System.out.println("us: " + validateUsername("us"));
    }
}