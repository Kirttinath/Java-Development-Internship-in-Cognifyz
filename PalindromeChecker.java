import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Palindrome Checker");
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        // Remove spaces and punctuation and convert to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        if (isPalindrome(cleanedInput)) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }

        scanner.close();
    }

    // Method to check if a string is a palindrome
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
