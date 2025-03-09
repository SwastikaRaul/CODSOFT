import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects;

        while (true) {
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) break;
                else System.out.println("Please enter a valid positive number.");
            } else {
                System.out.println("Invalid input! Enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }

        int totalMarks = 0;
        int maxMarksPerSubject = 100;

        // Taking input for each subject's marks
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + i + " (out of 100): ");
            int marks;

            while (true) {
                if (scanner.hasNextInt()) {
                    marks = scanner.nextInt();
                    if (marks >= 0 && marks <= maxMarksPerSubject) {
                        break;
                    } else {
                        System.out.println("Invalid marks! Enter a value between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a numeric value.");
                    scanner.next(); // Clear the invalid input
                }
            }
            totalMarks += marks;
        }

        // Calculating average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Determining the grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F'; // Fail
        }

        // Displaying the results
        System.out.println("\n----- Result Summary -----");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * maxMarksPerSubject));
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        // Closing scanner
        scanner.close();
    }
}