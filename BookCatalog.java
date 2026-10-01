import java.util.*;

public class BookCatalog {

    private HashMap<String, Book> books;
    private BPlusTree bPlusTree;
    private Trie trie;

    public BookCatalog() {

        books = new HashMap<>();
        bPlusTree = new BPlusTree();
        trie = new Trie();
    }

    public void addBook(Book book) {

        books.put(book.getIsbn(), book);

        bPlusTree.insert(book);

        trie.insert(book.getTitle());

        System.out.println("✓ Book Added Successfully");
    }

    public void removeBook(String isbn) {

        Book removed = books.remove(isbn);

        if (removed == null) {

            System.out.println("✗ Book Not Found");
            return;
        }

        System.out.println("✓ Book Removed");
        System.out.println(removed.getTitle());

        /*
           Academic Note:
           For simplicity we remove only
           from HashMap.

           Full B+ Tree deletion can be
           implemented later if required.
        */
    }

    public Book searchByISBN(String isbn) {

        return books.get(isbn);
    }

    public Book searchByTitle(String title) {

        return bPlusTree.search(title);
    }

    public boolean prefixSearch(String prefix) {

        return trie.startsWith(prefix);
    }

    public Collection<Book> getAllBooks() {

        return books.values();
    }

    public void displayBooks() {

        if (books.isEmpty()) {

            System.out.println("No Books Available");
            return;
        }

        System.out.println(
                "==============================================================================================");

        System.out.printf(
                "%-12s %-25s %-20s %-15s %-10s %-5s\n",
                "ISBN",
                "TITLE",
                "AUTHOR",
                "GENRE",
                "AVAILABLE",
                "CNT"
        );

        System.out.println(
                "==============================================================================================");

        for (Book book : books.values()) {

            System.out.println(book);
        }

        System.out.println(
                "==============================================================================================");
    }

    public void displayBPlusTree() {

        bPlusTree.display();
    }
}