import java.util.*;

public class ReportManager {

    public void mergeSort(
            List<Book> books) {

        if (books.size() <= 1)
            return;

        int mid =
                books.size() / 2;

        List<Book> left =
                new ArrayList<>(
                        books.subList(0, mid)
                );

        List<Book> right =
                new ArrayList<>(
                        books.subList(
                                mid,
                                books.size()
                        )
                );

        mergeSort(left);
        mergeSort(right);

        merge(
                books,
                left,
                right
        );
    }

    private void merge(
            List<Book> books,
            List<Book> left,
            List<Book> right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size()
                &&
                j < right.size()) {

            if (left.get(i)
                    .getBorrowCount()
                    >
                    right.get(j)
                            .getBorrowCount()) {

                books.set(
                        k++,
                        left.get(i++)
                );
            }

            else {

                books.set(
                        k++,
                        right.get(j++)
                );
            }
        }

        while (i < left.size()) {

            books.set(
                    k++,
                    left.get(i++)
            );
        }

        while (j < right.size()) {

            books.set(
                    k++,
                    right.get(j++)
            );
        }
    }

    public void generateMostBorrowedReport(
            Collection<Book> collection) {

        List<Book> books =
                new ArrayList<>(collection);

        mergeSort(books);

        System.out.println(
                "\n========================================"
        );

        System.out.println(
                "      MOST BORROWED BOOKS REPORT"
        );

        System.out.println(
                "========================================"
        );

        System.out.printf(
                "%-25s %-10s\n",
                "BOOK",
                "BORROWED"
        );

        System.out.println(
                "----------------------------------------"
        );

        for (Book book : books) {

            System.out.printf(
                    "%-25s %-10d\n",
                    book.getTitle(),
                    book.getBorrowCount()
            );
        }
    }
}