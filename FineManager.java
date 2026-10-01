import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class FineManager {

    private HashMap<
            String,
            LocalDate
            > borrowDates;

    private static final int LIMIT = 14;

    private static final int FINE_PER_DAY = 5;

    public FineManager() {

        borrowDates =
                new HashMap<>();
    }

    public void issueBook(
            String isbn) {

        borrowDates.put(
                isbn,
                LocalDate.now()
        );

        System.out.println(
                "✓ Book Issued"
        );
    }

    public int calculateFine(
            String isbn) {

        LocalDate issueDate =
                borrowDates.get(isbn);

        if (issueDate == null) {

            return 0;
        }

        long days =
                ChronoUnit.DAYS.between(
                        issueDate,
                        LocalDate.now()
                );

        long overdue =
                Math.max(
                        0,
                        days - LIMIT
                );

        return (int)
                overdue * FINE_PER_DAY;
    }

    public void returnBook(
            String isbn) {

        int fine =
                calculateFine(isbn);

        System.out.println(
                "Fine Amount : ₹"
                        + fine
        );

        borrowDates.remove(isbn);

        System.out.println(
                "✓ Book Returned"
        );
    }

    public void displayIssuedBooks() {

        if (borrowDates.isEmpty()) {

            System.out.println(
                    "No Issued Books"
            );

            return;
        }

        System.out.println(
                "\n===== ISSUED BOOKS ====="
        );

        for (String isbn :
                borrowDates.keySet()) {

            System.out.println(
                    isbn
                            + " -> "
                            + borrowDates.get(isbn)
            );
        }
    }
}