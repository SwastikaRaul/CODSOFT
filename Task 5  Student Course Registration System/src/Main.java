import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseManager courseManager = new CourseManager();
        StudentManager studentManager = new StudentManager();

        // Adding Sample Courses
        courseManager.addCourse(new Course("CS101", "Introduction to Programming", "Learn Java Basics", 3, "Mon-Wed 10 AM"));
        courseManager.addCourse(new Course("MATH202", "Calculus II", "Advanced Math Topics", 2, "Tue-Thu 2 PM"));

        System.out.println("Welcome to the Course Registration System!");

        while (true) {
            System.out.println("\n1. List Available Courses");
            System.out.println("2. Register a New Student");
            System.out.println("3. Register for a Course");
            System.out.println("4. Drop a Course");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    courseManager.listCourses();
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    Student newStudent = new Student(studentID, name);
                    studentManager.addStudent(newStudent);
                    System.out.println("Student registered successfully!");
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    Student student = studentManager.getStudentByID(scanner.nextLine());
                    if (student == null) {
                        System.out.println("Student not found!");
                        break;
                    }
                    courseManager.listCourses();
                    System.out.print("Enter Course Code to Register: ");
                    Course course = courseManager.getCourseByCode(scanner.nextLine());
                    if (course == null) {
                        System.out.println("Invalid Course Code!");
                    } else if (student.registerCourse(course)) {
                        System.out.println("Course registered successfully!");
                    } else {
                        System.out.println("Course is full or already registered!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    Student studentToDrop = studentManager.getStudentByID(scanner.nextLine());
                    if (studentToDrop == null) {
                        System.out.println("Student not found!");
                        break;
                    }
                    System.out.print("Enter Course Code to Drop: ");
                    Course courseToDrop = courseManager.getCourseByCode(scanner.nextLine());
                    if (courseToDrop == null || !studentToDrop.dropCourse(courseToDrop)) {
                        System.out.println("You are not enrolled in this course!");
                    } else {
                        System.out.println("Course dropped successfully!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
