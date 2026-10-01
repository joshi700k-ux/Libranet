import java.util.*;

public class MemberManager {

    private HashMap<String, Member> members;

    public MemberManager() {

        members = new HashMap<>();
    }

    public void registerMember(Member member) {

        members.put(
                member.getMemberId(),
                member
        );

        System.out.println(
                "✓ Member Registered Successfully"
        );
    }

    public Member getMember(String memberId) {

        return members.get(memberId);
    }

    public void displayMembers() {

        if (members.isEmpty()) {

            System.out.println(
                    "No Members Registered"
            );

            return;
        }

        System.out.println(
                "\n=========== MEMBERS ==========="
        );

        for (Member member : members.values()) {

            System.out.println(
                    member.getMemberId()
                            + " - "
                            + member.getName()
            );
        }
    }

    public void addBorrowHistory(
            String memberId,
            Book book) {

        Member member =
                members.get(memberId);

        if (member != null) {

            member.addHistory(book);
        }
    }
}