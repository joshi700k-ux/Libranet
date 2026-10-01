import java.util.LinkedList;

public class Member {

    private String memberId;
    private String name;

    private LinkedList<Book> borrowingHistory;

    public Member(String memberId, String name) {

        this.memberId = memberId;
        this.name = name;

        borrowingHistory = new LinkedList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void addHistory(Book book) {
        borrowingHistory.add(book);
    }

    public LinkedList<Book> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void displayHistory() {

        System.out.println("\nBorrowing History of " + name);

        for (Book book : borrowingHistory) {
            System.out.println(book.getTitle());
        }
    }
}