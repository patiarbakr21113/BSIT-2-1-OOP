import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int MAX = 10;

        // Parallel arrays
        int[] studentID = new int[MAX];
        String[] fullName = new String[MAX];
        int[] age = new int[MAX];
        String[] course = new String[MAX];
        double[] grade = new double[MAX];
        boolean[] enrolled = new boolean[MAX];

        int studentCount = 0;
        int choice;

        do {
            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by ID");
            System.out.println("4. View Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    if (studentCount >= MAX) {
                        System.out.println("Student list is full!");
                        break;
                    }

                    System.out.print("Enter Student ID: ");
                    studentID[studentCount] = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Full Name: ");
                    fullName[studentCount] = scanner.nextLine();

                    // Validate Age
                    while (true) {
                        System.out.print("Enter Age: ");
                        int inputAge = scanner.nextInt();

                        if (inputAge > 0) {
                            age[studentCount] = inputAge;
                            break;
                        } else {
                            System.out.println("Age must be positive.");
                        }
                    }
                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    course[studentCount] = scanner.nextLine();

                    // Validate Grade
                    while (true) {
                        System.out.print("Enter Grade: ");
                        double inputGrade = scanner.nextDouble();

                        if (inputGrade >= 0 && inputGrade <= 100) {
                            grade[studentCount] = inputGrade;
                            break;
                        } else {
                            System.out.println("Grade must be between 0 and 100.");
                        }
                    }

                    System.out.print("Is Enrolled? (true/false): ");
                    enrolled[studentCount] = scanner.nextBoolean();

                    studentCount++;
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (studentCount == 0) {
                        System.out.println("No student records found.");
                    } else {

                        System.out.printf("%-8s %-20s %-5s %-15s %-8s %-10s %-15s%n",
                                "ID", "Name", "Age", "Course", "Grade", "Status", "Standing");

                        for (int i = 0; i < studentCount; i++) {

                            String standing;

                            if (grade[i] >= 90) {
                                standing = "Dean's Lister";
                            } else if (grade[i] >= 75) {
                                standing = "Passed";
                            } else {
                                standing = "Failed";
                            }

                            System.out.printf("%-8d %-20s %-5d %-15s %-8.2f %-10b %-15s%n",
                                    studentID[i],
                                    fullName[i],
                                    age[i],
                                    course[i],
                                    grade[i],
                                    enrolled[i],
                                    standing);
                        }
                    }
                    break;

                case 3:
                    if (studentCount == 0) {
                        System.out.println("No student records available.");
                        break;
                    }

                    System.out.print("Enter Student ID to search: ");
                    int searchID = scanner.nextInt();

                    boolean found = false;

                    for (int i = 0; i < studentCount; i++) {

                        if (studentID[i] == searchID) {

                            System.out.println("\nStudent Found");
                            System.out.println("ID: " + studentID[i]);
                            System.out.println("Name: " + fullName[i]);
                            System.out.println("Age: " + age[i]);
                            System.out.println("Course: " + course[i]);
                            System.out.println("Grade: " + grade[i]);
                            System.out.println("Enrolled: " + enrolled[i]);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    if (studentCount == 0) {
                        System.out.println("No student records available.");
                    } else {

                        double total = 0;
                        double highestGrade = grade[0];
                        String topStudent = fullName[0];

                        for (int i = 0; i < studentCount; i++) {

                            total += grade[i];

                            if (grade[i] > highestGrade) {
                                highestGrade = grade[i];
                                topStudent = fullName[i];
                            }
                        }

                        double average = total / studentCount;

                        System.out.println("\n===== Statistics =====");
                        System.out.println("Total Students: " + studentCount);
                        System.out.printf("Average Grade: %.2f%n", average);
                        System.out.printf("Top Student: %s (%.2f)%n",
                                topStudent, highestGrade);
                    }

                    break;

                case 5:
                    System.out.println("Thank you for using the Student Information System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
