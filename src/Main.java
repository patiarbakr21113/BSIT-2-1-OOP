import java.util.ArrayList;
import java.util.Scanner;

<<<<<<< HEAD
public class Main {

    public static void main(String[] args) {

        // ONE list holds Cars AND Motorcycles
        // because both ARE Vehicles.
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {

            System.out.println();
            System.out.println("===== VEHICLE MANAGER =====");
            System.out.println("1 - Add Car");
            System.out.println("2 - Add Motorcycle");
            System.out.println("3 - Remove a Vehicle");
            System.out.println("4 - Display All Vehicles");
            System.out.println("5 - Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();
            input.nextLine(); // clear the leftover newline

            if (choice == 1) {

                System.out.print("Brand: ");
                String brand = input.nextLine();

                System.out.print("Year: ");
                int year = input.nextInt();

                System.out.print("Number of doors: ");
                int doors = input.nextInt();

                // TODO 7 completed
                vehicles.add(new Car(brand, year, doors));

                System.out.println(">> Car added!");

            } else if (choice == 2) {

                System.out.print("Brand: ");
                String brand = input.nextLine();

                System.out.print("Year: ");
                int year = input.nextInt();

                System.out.print("Has sidecar? (true/false): ");
                boolean sidecar = input.nextBoolean();

                // TODO 8 completed
                vehicles.add(new Motorcycle(brand, year, sidecar));

                System.out.println(">> Motorcycle added!");

            } else if (choice == 3) {

                System.out.print("Enter the number to remove: ");
                int number = input.nextInt();

                // TODO 9 completed
                if (number >= 1 && number <= vehicles.size()) {
                    vehicles.remove(number - 1);
                    System.out.println(">> Removed!");
                } else {
                    System.out.println(">> Invalid number.");
                }

            } else if (choice == 4) {

                System.out.println("--- All Vehicles ---");

                if (vehicles.isEmpty()) {
                    System.out.println("(none yet)");
                }

                // TODO 10 completed
                for (int i = 0; i < vehicles.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    vehicles.get(i).displayInfo();
                }
            }
        }

        System.out.println("Goodbye!");
        input.close();
    }
}

=======
public class GradeTracker {

    // Part A - Grade Scale (Array)
    static int[] cutoffs = {90, 80, 70, 60, 0};
    static String[] letters = {"A", "B", "C", "D", "F"};

    public static String letterFor(double grade) {
        for (int i = 0; i < cutoffs.length; i++) {
            if (grade >= cutoffs[i]) {
                return letters[i];
            }
        }
        return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> roster = new ArrayList<>();

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n=== Grade Tracker ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Class Average");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.next();

                    System.out.print("Enter grade: ");
                    double grade = sc.nextDouble();

                    roster.add(new Student(name, grade));
                    System.out.println("Student added.");
                    break;

                case 2:
                    if (roster.isEmpty()) {
                        System.out.println("No students in the roster.");
                    } else {
                        System.out.println("\nClass List:");
                        for (Student s : roster) {
                            System.out.println(
                                    s.name + " - " +
                                            s.grade + " (" +
                                            letterFor(s.grade) + ")");
                        }
                    }
                    break;

                case 3:
                    if (roster.isEmpty()) {
                        System.out.println("No students to average.");
                    } else {
                        double total = 0;

                        for (Student s : roster) {
                            total += s.grade;
                        }

                        double average = total / roster.size();

                        System.out.printf("Class Average: %.2f (%s)%n",
                                average, letterFor(average));
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}

// Student class
class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}
>>>>>>> b392dee67f2c24fb98bf382ffe68516c5504ddf4
