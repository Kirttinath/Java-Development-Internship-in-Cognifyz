import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }

        int strengthScore = calculateStrengthScore(length, hasUppercase, hasLowercase, hasDigit, hasSpecialChar);

        if (strengthScore >= 8) {
            System.out.println("Password Strength: Strong");
        } else if (strengthScore >= 6) {
            System.out.println("Password Strength: Medium");
        } else {
            System.out.println("Password Strength: Weak");
        }

        scanner.close();
    }

    private static int calculateStrengthScore(int length, boolean hasUppercase, boolean hasLowercase, boolean hasDigit, boolean hasSpecialChar) {
        int score = 0;

        if (length >= 8) {
            score += 2;
        } else if (length >= 6) {
            score += 1;
        }

        if (hasUppercase) {
            score += 2;
        }
        if (hasLowercase) {
            score += 2;
        }
        if (hasDigit) {
            score += 2;
        }
        if (hasSpecialChar) {
            score += 2;
        }

        return score;
    }
}

