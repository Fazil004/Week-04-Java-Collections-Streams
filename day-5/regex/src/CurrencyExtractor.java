import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        Pattern pattern = Pattern.compile("[$\u20B9\u00A3\u20AC]?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50. In India, it costs \u20B91000.00";
        List<String> currencyValues = extractCurrencyValues(text);
        System.out.println(currencyValues);
    }
}