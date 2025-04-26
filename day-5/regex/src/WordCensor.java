import java.util.List;
public class WordCensor {
    public static String censorBadWords(String text, List<String> badWords) {
        String censoredText = text;
        for (String word : badWords) {
            censoredText = censoredText.replaceAll(word, "****");
        }
        return censoredText;
    }

    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        List<String> badWords = List.of("damn", "stupid");
        String censoredText = censorBadWords(text, badWords);
        System.out.println(censoredText);
    }
}