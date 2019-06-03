public class PalindromeApp {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
        System.out.println(isPalindrome("A1ll1a!"));
        System.out.println(isPalindrome("aad,dffk1k"));
    }

    public static boolean isPalindrome(String text) {
        String temp = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return temp.equals(new StringBuffer(temp).reverse().toString());
    }
}
