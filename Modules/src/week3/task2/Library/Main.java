package week3.task2.Library;

import week3.task2.Library.model.Book;
import week3.task2.Library.model.LibraryMember;
import week3.task2.Library.system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("1984", "George Orwell", "ISBN001");
        Book book2 = new Book("Brave New World", "Aldous Huxley", "ISBN002");

        LibraryMember member1 = new LibraryMember("Alia", 1);
        LibraryMember member2 = new LibraryMember("Smith", 2);

        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook(member1, book1);
        library.reserveBook(member2, book2);

        library.displayReservedBooks(member2);

        library.cancelReservation(member2, book2);
        library.displayReservedBooks(member2);

        library.returnBook(member1, book1);
    }
}
