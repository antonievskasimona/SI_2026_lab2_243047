import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class SI2026Lab2Test {

    @Test
    public void searchBookEveryStatementTest() {

        Library library1 = new Library();
        assertThrows(IllegalArgumentException.class, () -> {
            library1.searchBookByTitle("");
        });

        Library library2 = new Library();
        library2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));

        List<Book> result = library2.searchBookByTitle("Clean Code");

        assertNotNull(result);
        assertEquals(1, result.size());

        Library library3 = new Library();
        library3.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));

        List<Book> result2 = library3.searchBookByTitle("Unknown Book");

        assertNull(result2);
    }

    @Test
    public void borrowBookEveryBranchTest() {

        Library library1 = new Library();

        try {
            library1.borrowBook("", "");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid search query", e.getMessage());
        }

        Library library2 = new Library();

        library2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library2.borrowBook("Clean Code", "Robert C. Martin");
        List<Book> result = library2.searchBookByTitle("Clean Code");
        assertNull(result);

        Library library3 = new Library();

        Book borrowedBook = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy");

        borrowedBook.setBorrowed(true);
        library3.addBook(borrowedBook);

        try {
            library3.borrowBook("The Hobbit", "J.R.R. Tolkien");
            fail("Exception not thrown");
        } catch (RuntimeException e) {
            assertEquals("Book is already borrowed.", e.getMessage());
        }

        Library library4 = new Library();

        try {
            library4.borrowBook("Unknown", "Unknown");
            fail("Exception not thrown");
        } catch (RuntimeException e) {
            assertEquals("Book not found", e.getMessage());
        }
    }

    @Test
    public void searchBookMultipleConditionTest() {

        Library library1 = new Library();
        library1.addBook(new Book("Clean Code", "Robert", "Programming"));
        List<Book> result1 = library1.searchBookByTitle("Clean Code");
        assertNotNull(result1);

        Library library2 = new Library();

        Book b2 = new Book("Clean Code", "Robert", "Programming");

        b2.setBorrowed(true);
        library2.addBook(b2);
        List<Book> result2 = library2.searchBookByTitle("Clean Code");
        assertNull(result2);
        Library library3 = new Library();
        library3.addBook(new Book("Java", "Author", "Programming"));

        List<Book> result3 = library3.searchBookByTitle("Python");

        assertNull(result3);
        Library library4 = new Library();
        Book b4 = new Book("Java", "Author", "Programming");
        b4.setBorrowed(true);
        library4.addBook(b4);
        List<Book> result4 = library4.searchBookByTitle("Python");
        assertNull(result4);
    }

    @Test
    public void borrowBookMultipleConditionTest() {

        Library library1 = new Library();

        try {
            library1.borrowBook("", "");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid search query", e.getMessage());
        }

        Library library2 = new Library();

        try {
            library2.borrowBook("", "Author");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid search query", e.getMessage());
        }

        Library library3 = new Library();

        try {
            library3.borrowBook("Book", "");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid search query", e.getMessage());
        }

        Library library4 = new Library();
        library4.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library4.borrowBook("Clean Code", "Robert C. Martin");
        assertNull(library4.searchBookByTitle("Clean Code"));
    }
}