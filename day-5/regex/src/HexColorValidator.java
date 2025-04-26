public class HexColorValidator {
    public static boolean validateHexColor(String colorCode) {
        return colorCode.matches("^#[0-9a-fA-F]{6}$");
    }

    public static void main(String[] args) {
        System.out.println("#FFA500: " + validateHexColor("#FFA500"));
        System.out.println("#ff4500: " + validateHexColor("#ff4500"));
        System.out.println("#123: " + validateHexColor("#123"));
    }
}