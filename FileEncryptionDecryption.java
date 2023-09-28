import java.io.*;
import java.util.*;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File Encryption/Decryption Program");
        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        char choice = scanner.next().charAt(0);
        scanner.nextLine(); // Consume newline

        if (choice == 'E' || choice == 'e' || choice == 'D' || choice == 'd') {
            System.out.print("Enter the input file path: ");
            String inputFile = scanner.nextLine();
            System.out.print("Enter the output file path: ");
            String outputFile = scanner.nextLine();

            try {
                if (choice == 'E' || choice == 'e') {
                    encryptFile(inputFile, outputFile);
                    System.out.println("Encryption completed. Encrypted file saved as " + outputFile);
                } else {
                    decryptFile(inputFile, outputFile);
                    System.out.println("Decryption completed. Decrypted file saved as " + outputFile);
                }
            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Please enter 'E' or 'D' for encryption or decryption.");
        }

        scanner.close();
    }

    // Simple Caesar cipher encryption
    private static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encryptedText.append((char) (((c - base + shift) % 26) + base));
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    // Encrypts the contents of an input file and saves it to an output file
    private static void encryptFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encrypt(line, 3); // Use a shift of 3 as an example
                writer.write(encryptedLine);
                writer.newLine();
            }
        }
    }

    // Decrypts the contents of an input file and saves it to an output file
    private static void decryptFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = encrypt(line, -3); // Decrypt using a shift of -3
                writer.write(decryptedLine);
                writer.newLine();
            }
        }
    }
}
