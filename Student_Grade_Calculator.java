import java.util.Scanner;

public class Student_Grade_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained in each subject
	System.out.println("\n\n\t\t\t\t\t*****-STUDENT GRADE CALCULATOR-*****");

        System.out.print("\n\tEnter the number of subjects:");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("\n\tEnter marks obtained in subject " + i + " : ");
            int marks = scanner.nextInt();

            // Validate that marks are in the valid range (0 to 100)
            if (marks < 0 || marks > 100) {
                System.out.print("Invalid marks! Marks should be in the range 0 to 100.");
                return;
            }

            totalMarks += marks;
        }

        // Calculate Total Marks
        System.out.println("\n\t\tTotal Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        System.out.println("\t\tAverage Percentage: " + averagePercentage + "%");

        // Grade Calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\t\tGrade: " + grade);

        // Close the scanner
        scanner.close();
    }

}
