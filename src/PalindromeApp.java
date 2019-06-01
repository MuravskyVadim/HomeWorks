import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PalindromeApp {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
        System.out.println(isPalindrome("A1ll1a!"));
        System.out.println(isPalindrome("aad,dffk1k"));
    }

    public static boolean isPalindrome(String text) {
        StringBuilder stringWithoutSymbols = new StringBuilder(text.replaceAll("[^a-zA-Z0-9]", ""));
        int middleString = stringWithoutSymbols.length() / 2;
        String firstPart = stringWithoutSymbols.substring(0, middleString);
        StringBuilder secondPart = new StringBuilder(
                stringWithoutSymbols.substring(stringWithoutSymbols.length() % 2 + middleString));

        if (firstPart.equalsIgnoreCase(secondPart.reverse().toString())) {
            return true;
        }
        return false;
    }
}
