public class Book {

    private String isbn;
    private String title;
    private String author;
    private String genre;
    private boolean available;
    private int borrowCount;

    public Book(String isbn, String title, String author, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
        this.borrowCount = 0;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void incrementBorrowCount() {
        borrowCount++;
    }

    @Override
    public String toString() {
        return String.format(
                "%-12s %-25s %-20s %-15s %-10s %-5d",
                isbn,
                title,
                author,
                genre,
                available ? "YES" : "NO",
                borrowCount
        );
    }
}