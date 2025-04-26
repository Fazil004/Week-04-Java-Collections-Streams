public class IPAddressValidator {
    public static boolean validateIPAddress(String ipAddress) {
        return ipAddress.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})$");
    }

    public static void main(String[] args) {
        System.out.println("192.168.1.1: " + validateIPAddress("192.168.1.1"));
        System.out.println("256.256.256.256: " + validateIPAddress("256.256.256.256"));
    }
}
