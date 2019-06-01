import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PalindromeApp {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
        System.out.println(isPalindrome("A1ll1a!"));
        System.out.println(isPalindrome("aad,dffk1k"));
    }

    public static boolean isPalindrome(String text) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]");
        Matcher m = p.matcher(text);
        StringBuilder textWithoutSymbols = new StringBuilder();

        while (m.find()) {
            textWithoutSymbols.append(text.substring(m.start(), m.end()));
        }

        String textLowerCase = textWithoutSymbols.toString().toLowerCase();
        String firstPart;
        StringBuilder secondPart;

        if (textLowerCase.length() % 2 == 0) {
            firstPart = textLowerCase.substring(0, textLowerCase.length() / 2);
            secondPart = new StringBuilder(textLowerCase.substring(textLowerCase.length() / 2));
        } else {
            firstPart = textLowerCase.substring(0, textLowerCase.length() / 2);
            secondPart = new StringBuilder(textLowerCase.substring(textLowerCase.length() / 2 + 1));
        }

        if (firstPart.equals(secondPart.reverse().toString())) {
            return true;
        }
        return false;
    }
}
