import java.util.*;

public class ReservationManager {

    private HashMap<
            String,
            Queue<Member>
            > waitLists;

    public ReservationManager() {

        waitLists = new HashMap<>();
    }

    public void reserveBook(
            String isbn,
            Member member) {

        waitLists.putIfAbsent(
                isbn,
                new LinkedList<>()
        );

        waitLists.get(isbn)
                .offer(member);

        System.out.println(
                "✓ Reservation Added"
        );
    }

    public void displayWaitList(
            String isbn) {

        Queue<Member> queue =
                waitLists.get(isbn);

        if (queue == null
                || queue.isEmpty()) {

            System.out.println(
                    "No Reservations"
            );

            return;
        }

        System.out.println(
                "\nWAITLIST FOR BOOK "
                        + isbn
        );

        for (Member m : queue) {

            System.out.println(
                    m.getMemberId()
                            + " - "
                            + m.getName()
            );
        }
    }

    public Member assignNextMember(
            String isbn) {

        Queue<Member> queue =
                waitLists.get(isbn);

        if (queue == null
                || queue.isEmpty()) {

            return null;
        }

        Member next =
                queue.poll();

        System.out.println(
                "Book Assigned To : "
                        + next.getName()
        );

        return next;
    }
}