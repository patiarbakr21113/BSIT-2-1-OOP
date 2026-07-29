import java.util.ArrayList;
import java.util.Scanner;

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Borrow a book
    public void borrow() {
        isBorrowed = true;
    }

    // Return a book
    public void returnBook() {
        isBorrowed = false;
    }

    // Display book information
    public String describe() {
        String status = isBorrowed ? "Borrowed" : "Available";
        return title + " by " + author + " [" + status + "]";
    }
}


// Library Class
class Library {
    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println(">> Book added successfully.");
    }

    // List all books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n--- Library Catalog ---");

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).describe());
        }
    }

    // Borrow a book
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {

                if (!book.isBorrowed()) {
                    book.borrow();
                    System.out.println(">> You borrowed '" + book.getTitle() + "'.");
                } else {
                    System.out.println(">> This book is already borrowed.");
                }

                return;
            }
        }

        System.out.println(">> Book not found.");
    }

    // Return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {

                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println(">> You returned '" + book.getTitle() + "'.");
                } else {
                    System.out.println(">> This book is already available.");
                }

                return;
            }
        }

        System.out.println(">> Book not found.");
    }

    // Search a book
    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(">> Book found:");
                System.out.println(book.describe());
                return;
            }
        }

        System.out.println(">> Book not found.");
    }
}


// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY INFORMATION SYSTEM =====");
            System.out.println("1. Add a book");
            System.out.println("2. List all books");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Search a book");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear input buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(title, author);
                    library.addBook(book);
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:
                    System.out.print("Enter title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;

                case 4:
                    System.out.print("Enter title to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;

                case 5:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 0:
                    System.out.println(">> Thank you for using the Library System. Goodbye!");
                    break;

                default:
                    System.out.println(">> Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
