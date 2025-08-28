package week2.one;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library doesn't have any books yet");
        } else {
            for (Book b : books) {
                b.displayInfo();
            }
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by Author \"" + author + "\":");
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                b.displayAuthor();
                found = true;
            }
        }
        if (!found) {
            System.out.println("None.");
        }
    }

    public boolean borrowBook(User user, String title) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                user.borrowBook(b);
                return true;
            }
        }
        return false;
    }

    public void returnBook(User user, Book book) {
        user.returnBook(book);
        books.add(book);
    }

    public boolean isBookAvailable(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public double getAverageBookRating() {
        if (books.isEmpty()) return 0.0;
        double total = 0;
        int count = 0;
        for (Book b : books) {
            total += b.getRating();
            count++;
        }
        return total / count;
    }

    public Book getMostReviewedBook() {
        if (books.isEmpty()) return null;

        Book mostReviewed = books.get(0);
        for (Book b : books) {
            if (b.getReviews().size() > mostReviewed.getReviews().size()) {
                mostReviewed = b;
            }
        }
        return mostReviewed;
    }

    public void addUser(User user) {
        users.add(user);
    }

    // For looping in main
    public ArrayList<Book> getBooks() {
        return books;
    }
}