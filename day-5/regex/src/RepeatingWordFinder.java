import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class RepeatingWordFinder {
    public static List<String> findRepeatingWords(String text) {
        List<String> repeatingWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (!repeatingWords.contains(matcher.group(1))) {
                repeatingWords.add(matcher.group(1));
            }
        }
        return repeatingWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        List<String> repeatingWords = findRepeatingWords(text);
        System.out.println(repeatingWords);
    }
}