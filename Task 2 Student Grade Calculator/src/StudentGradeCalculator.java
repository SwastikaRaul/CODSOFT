import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Taking input for number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects;

        while (true) {
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) break;
                else System.out.println("Please enter a valid positive number.");

            }
            else {
                System.out.println("Invalid input! Enter a number.");
                scanner.next(); //clear the invalid input
            }
        }

        int totalMarks = 0;
        int maxMarksPerSubject = 100;
        //taking input for each student's marks
        for (int i = 1; i<=numSubjects; i++) {
            System.out.print("Enter the marks obtained in subject " + i + " out (of 100): ");
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
    }
}
