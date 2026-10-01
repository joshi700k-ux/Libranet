public class ConsoleUI {

    public static void showHeader() {

        System.out.println(
                "\n╔══════════════════════════════════════════════════════════════╗");

        System.out.println(
                "║              CITY CENTRAL LIBRARY SYSTEM                   ║");

        System.out.println(
                "║      Advanced Data Structures Project (Java)              ║");

        System.out.println(
                "╚══════════════════════════════════════════════════════════════╝");
    }

    public static void showMenu() {

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        System.out.println(" 1. Add Book");
        System.out.println(" 2. Delete Book");
        System.out.println(" 3. Display Books");
        System.out.println(" 4. Search Book By ISBN");
        System.out.println(" 5. Search Book By Title");
        System.out.println(" 6. Register Member");
        System.out.println(" 7. Display Members");
        System.out.println(" 8. Reserve Book");
        System.out.println(" 9. Display Waitlist");
        System.out.println("10. Issue Book");
        System.out.println("11. Return Book");
        System.out.println("12. Recommendation By Genre");
        System.out.println("13. Most Borrowed Report");
        System.out.println("14. Display B+ Tree Index");
        System.out.println("15. Branch Network Demo");
        System.out.println(" 0. Exit");

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    public static void success(String msg) {
        System.out.println("✅ " + msg);
    }

    public static void error(String msg) {
        System.out.println("❌ " + msg);
    }

    public static void info(String msg) {
        System.out.println("ℹ️ " + msg);
    }
}