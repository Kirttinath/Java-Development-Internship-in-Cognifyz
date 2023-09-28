import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of grades to be entered: ");
        int numGrades = scanner.nextInt();

        // Check if the number of grades is valid
        if (numGrades <= 0) {
            System.out.println("Invalid number of grades. Please enter a positive integer.");
            scanner.close();
            return;
        }

        double totalGrade = 0;

        for (int i = 1; i <= numGrades; i++) {
            System.out.print("Enter mark-" + i + ": ");
            double grade = scanner.nextDouble();

            // Check if the entered grade is valid (between 0 and 100)
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Grades should be between 0 and 100.");
                scanner.close();
                return;
            }

            totalGrade += grade;
        }

        double averageGrade = totalGrade / numGrades;
        System.out.println("Average Grade: " + averageGrade);

        scanner.close();
    }
}
