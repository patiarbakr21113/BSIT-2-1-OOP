import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserManager manager = new UserManager();

        int nextId = 1;

        // Sample users
        manager.add(new Admin(
                nextId++,
                "Razz",
                "razz@liceo.edu.ph"
        ));

        manager.add(new Teacher(
                nextId++,
                "Maria",
                "maria@liceo.edu.ph",
                "CIT"
        ));

        manager.add(new Student(
                nextId++,
                "Ana",
                "ana@liceo.edu.ph",
                "BSIT"
        ));

        while (true) {

            System.out.println();
            System.out.println("=== USER MANAGEMENT SYSTEM ===");
            System.out.println("1. Add User");
            System.out.println("2. List Users");
            System.out.println("3. Search User");
            System.out.println("4. Delete User");
            System.out.println("5. Export CSV");
            System.out.println("6. Exit");

            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {

                case 1:
                    nextId = addUser(scanner, manager, nextId);
                    break;

                case 2:
                    manager.listAll();
                    break;

                case 3:
                    int searchId = readInt(scanner, "Enter user ID: ");
                    User found = manager.findById(searchId);

                    if (found == null) {
                        System.out.println("User not found.");
                    } else {
                        found.display();
                    }
                    break;

                case 4:
                    int deleteId = readInt(scanner, "Enter user ID to delete: ");

                    if (manager.deleteById(deleteId)) {
                        System.out.println("User deleted successfully.");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    manager.exportAll();
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static int addUser(
            Scanner scanner,
            UserManager manager,
            int nextId) {

        System.out.println();
        System.out.println("--- ADD USER ---");
        System.out.println("1. Admin");
        System.out.println("2. Teacher");
        System.out.println("3. Student");

        int type = readInt(scanner, "Choose user type: ");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        User user;

        switch (type) {

            case 1:
                user = new Admin(
                        nextId,
                        name,
                        email
                );
                break;

            case 2:
                System.out.print("Enter department: ");
                String department = scanner.nextLine();

                user = new Teacher(
                        nextId,
                        name,
                        email,
                        department
                );
                break;

            case 3:
                System.out.print("Enter course: ");
                String course = scanner.nextLine();

                user = new Student(
                        nextId,
                        name,
                        email,
                        course
                );
                break;

            default:
                System.out.println("Invalid user type.");
                return nextId;
        }

        manager.add(user);

        return nextId + 1;
    }

    private static int readInt(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}
