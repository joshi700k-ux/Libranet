import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookCatalog catalog =
                new BookCatalog();

        MemberManager memberManager =
                new MemberManager();

        ReservationManager reservationManager =
                new ReservationManager();

        FineManager fineManager =
                new FineManager();

        RecommendationEngine recommendationEngine =
                new RecommendationEngine();

        ReportManager reportManager =
                new ReportManager();

        BranchNetwork network =
                new BranchNetwork();

        int choice;

        do {

            ConsoleUI.showHeader();
            ConsoleUI.showMenu();

            System.out.print("\nEnter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("ISBN : ");
                    String isbn = sc.nextLine();

                    System.out.print("Title : ");
                    String title = sc.nextLine();

                    System.out.print("Author : ");
                    String author = sc.nextLine();

                    System.out.print("Genre : ");
                    String genre = sc.nextLine();

                    Book book =
                            new Book(
                                    isbn,
                                    title,
                                    author,
                                    genre
                            );

                    catalog.addBook(book);

                    ConsoleUI.success(
                            "Book Added Successfully"
                    );

                    break;

                case 2:

                    System.out.print(
                            "Enter ISBN : "
                    );

                    isbn = sc.nextLine();

                    catalog.removeBook(isbn);

                    break;

                case 3:

                    catalog.displayBooks();

                    break;

                case 4:

                    System.out.print(
                            "Enter ISBN : "
                    );

                    isbn = sc.nextLine();

                    Book found =
                            catalog.searchByISBN(isbn);

                    if (found != null)
                        System.out.println(found);
                    else
                        ConsoleUI.error(
                                "Book Not Found"
                        );

                    break;

                case 5:

                    System.out.print(
                            "Enter Title : "
                    );

                    title = sc.nextLine();

                    found =
                            catalog.searchByTitle(title);

                    if (found != null)
                        System.out.println(found);
                    else
                        ConsoleUI.error(
                                "Book Not Found"
                        );

                    break;

                case 6:

                    System.out.print(
                            "Member ID : "
                    );

                    String id =
                            sc.nextLine();

                    System.out.print(
                            "Name : "
                    );

                    String name =
                            sc.nextLine();

                    Member member =
                            new Member(
                                    id,
                                    name
                            );

                    memberManager.registerMember(
                            member
                    );

                    break;

                case 7:

                    memberManager.displayMembers();

                    break;

                case 8:

                    System.out.print(
                            "ISBN : "
                    );

                    isbn =
                            sc.nextLine();

                    System.out.print(
                            "Member ID : "
                    );

                    id =
                            sc.nextLine();

                    member =
                            memberManager.getMember(id);

                    if (member != null) {

                        reservationManager
                                .reserveBook(
                                        isbn,
                                        member
                                );
                    }

                    else {

                        ConsoleUI.error(
                                "Member Not Found"
                        );
                    }

                    break;

                case 9:

                    System.out.print(
                            "ISBN : "
                    );

                    isbn =
                            sc.nextLine();

                    reservationManager
                            .displayWaitList(
                                    isbn
                            );

                    break;

                case 10:

                    System.out.print(
                            "ISBN : "
                    );

                    isbn =
                            sc.nextLine();

                    fineManager.issueBook(
                            isbn
                    );

                    Book issueBook =
                            catalog.searchByISBN(
                                    isbn
                            );

                    if(issueBook != null){

                        issueBook.incrementBorrowCount();
                    }

                    break;

                case 11:

                    System.out.print(
                            "ISBN : "
                    );

                    isbn =
                            sc.nextLine();

                    fineManager.returnBook(
                            isbn
                    );

                    reservationManager
                            .assignNextMember(
                                    isbn
                            );

                    break;

                case 12:

                    System.out.print(
                            "Enter Preferred Genre : "
                    );

                    genre =
                            sc.nextLine();

                    List<Book> recommendations =
                            recommendationEngine
                                    .recommendByGenre(
                                            genre,
                                            catalog.getAllBooks()
                                    );

                    System.out.println(
                            "\nRecommended Books"
                    );

                    for(Book b :
                            recommendations){

                        System.out.println(
                                b.getTitle()
                                        +
                                        " ("
                                        +
                                        b.getGenre()
                                        +
                                        ")"
                        );
                    }

                    break;

                case 13:

                    reportManager
                            .generateMostBorrowedReport(
                                    catalog.getAllBooks()
                            );

                    break;

                case 14:

                    catalog.displayBPlusTree();

                    break;

                case 15:

                    network.addBranchRoute(
                            "Central",
                            "North",
                            5
                    );

                    network.addBranchRoute(
                            "Central",
                            "East",
                            8
                    );

                    network.addBranchRoute(
                            "East",
                            "South",
                            4
                    );

                    network.addBranchRoute(
                            "North",
                            "South",
                            6
                    );

                    network.displayNetwork();

                    network.shortestPath(
                            "Central"
                    );

                    break;

                case 0:

                    ConsoleUI.success(
                            "Thank You!"
                    );

                    break;

                default:

                    ConsoleUI.error(
                            "Invalid Choice"
                    );
            }

        } while(choice != 0);

        sc.close();
    }
}