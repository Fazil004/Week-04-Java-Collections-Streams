public class CreditCardValidator {
    public static boolean validateCreditCard(String cardNumber) {
        return cardNumber.matches("^(4[0-9]{15}|5[1-5][0-9]{14})$");
    }

    public static void main(String[] args) {
        System.out.println("Visa: 4123456789012345: " + validateCreditCard("4123456789012345"));
        System.out.println("MasterCard: 5123456789012345: " + validateCreditCard("5123456789012345"));
        System.out.println("Invalid: 6123456789012345: " + validateCreditCard("6123456789012345"));
    }
}
