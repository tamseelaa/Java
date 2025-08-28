package week2.one;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Task 1: all classes assosiations are below
        // Create books
        Book b2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book b3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // Create library
        Library library = new Library();

        // User input
        int age;
        String name;
        System.out.print("Enter your name: ");
        name = input.nextLine();
        System.out.print("Enter your age: ");
        age = input.nextInt();
        input.nextLine(); // consume newline
        User user = new User(name, age);
        library.addUser(user);

        // Add books to library
        library.addBook(new Book("Atomic Habits", "James Clear", 2018));
        library.addBook(new Book("The Alchemist", "Paulo Coelho", 1988));
        library.addBook(new Book("The Shining", "Stephan King", 1977));
        library.addBook(new Book("Misery", "Stephan King", 1987));
        library.addBook(b2);  // add b2
        library.addBook(b3);  // add b3

        // Display all books
        System.out.println("All books inside the Library: ");
        library.displayBooks();
        System.out.println("---------------------------------------------------------------------------------");

        library.findBooksByAuthor("Stephan King");
        library.findBooksByAuthor("James Clear");
        System.out.println("---------------------------------------------------------------------------------");
        //Task 2
        // Borrow/Return
        boolean running = true;
        while (running) {
            System.out.println("\nDo you want to borrow, return, or exit?");
            System.out.print("Enter borrow/return/exit: ");
            String response = input.nextLine().trim().toLowerCase();

            switch (response) {
                case "borrow":
                    System.out.print("Enter the book name to borrow: ");
                    String borrowBookName = input.nextLine();
                    boolean borrowResult = library.borrowBook(user, borrowBookName);
                    if (borrowResult) {
                        System.out.println("Borrowing successful");
                    } else {
                        System.out.println("Borrowing failed (book may not exist or is already borrowed)");
                    }
                    break;

                case "return":
                    System.out.print("Enter the book name to return: ");
                    String returnBookName = input.nextLine();
                    Book bookToReturn = null;
                    for (Book b : user.getBorrowedBooks()) {
                        if (b.getTitle().equalsIgnoreCase(returnBookName)) {
                            bookToReturn = b;
                            break;
                        }
                    }
                    if (bookToReturn != null) {
                        library.returnBook(user, bookToReturn);
                        System.out.println("Return successful");
                    } else {
                        System.out.println("Book not found in your borrowed list.");
                    }
                    break;

                case "exit":
                    running = false;
                    System.out.println("Exiting library system...");
                    break;

                default:
                    System.out.println("Invalid input. Please type borrow, return, or exit.");
            }
        }

        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.println("Its a test borrow book");
        System.out.println("\nBorrowed 'The Alchemist'");
        library.borrowBook(user, "The Alchemist");
        System.out.println("---------------------------------------------------------------------------------");

        // Task 3: Availability
        System.out.println("\nIs 'Data Structures and Algorithms' available? "
                + library.isBookAvailable("Data Structures and Algorithms"));

        // Task 4: Ratings & Reviews (rate all books)
        for (Book b : library.getBooks()) {
            if (b.getTitle().equalsIgnoreCase("Atomic Habits")) {
                b.setRating(4.8);
                b.addReview("Life changing!");
            } else if (b.getTitle().equalsIgnoreCase("The Alchemist")) {
                b.setRating(4.2);
                b.addReview("Inspirational story.");
            } else if (b.getTitle().equalsIgnoreCase("The Shining")) {
                b.setRating(4.6);
                b.addReview("Scary and thrilling.");
            } else if (b.getTitle().equalsIgnoreCase("Misery")) {
                b.setRating(4.1);
                b.addReview("Dark but brilliant.");
            } else if (b.getTitle().equalsIgnoreCase("Data Structures and Algorithms")) {
                b.setRating(4.5);
                b.addReview("Excellent resource!");
            } else if (b.getTitle().equalsIgnoreCase("The Art of Fiction")) {
                b.setRating(4.0);
                b.addReview("Very insightful.");
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");

        // Task 5: Statistics
        System.out.println("\nAverage Book Rating: " + library.getAverageBookRating());
        System.out.println("Most Reviewed Book: " + library.getMostReviewedBook().getTitle());
    }
}