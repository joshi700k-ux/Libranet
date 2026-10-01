

public class BPlusTree {

    private static final int ORDER = 4;
    private BPlusTreeNode root;

    public BPlusTree() {
        root = new BPlusTreeNode(true);
    }

    public void insert(Book book) {

        if (book == null) {
            return;
        }

        BPlusTreeNode current = root;

        while (!current.leaf) {

            int i = 0;

            while (i < current.keys.size()
                    && book.getTitle().compareToIgnoreCase(current.keys.get(i)) > 0) {
                i++;
            }

            if (i >= current.children.size()) {
                break;
            }

            current = current.children.get(i);
        }

        int pos = 0;

        while (pos < current.keys.size()
                && book.getTitle().compareToIgnoreCase(current.keys.get(pos)) > 0) {
            pos++;
        }

        current.keys.add(pos, book.getTitle());
        current.books.add(pos, book);

        if (current.keys.size() >= ORDER) {
            splitLeaf(current);
        }
    }

    private void splitLeaf(BPlusTreeNode node) {

        BPlusTreeNode newLeaf = new BPlusTreeNode(true);

        int mid = node.keys.size() / 2;

        while (node.keys.size() > mid) {
            newLeaf.keys.add(node.keys.remove(mid));
            newLeaf.books.add(node.books.remove(mid));
        }

        newLeaf.next = node.next;
        node.next = newLeaf;

        System.out.println("B+ Tree Leaf Split Performed");
    }

    public Book search(String title) {

        if (title == null) {
            return null;
        }

        BPlusTreeNode current = root;

        while (!current.leaf) {

            int i = 0;

            while (i < current.keys.size()
                    && title.compareToIgnoreCase(current.keys.get(i)) > 0) {
                i++;
            }

            if (i >= current.children.size()) {
                return null;
            }

            current = current.children.get(i);
        }

        for (int i = 0; i < current.keys.size(); i++) {

            if (current.keys.get(i).equalsIgnoreCase(title)) {
                return current.books.get(i);
            }
        }

        return null;
    }

    public void display() {

        System.out.println("\n===== B+ TREE INDEX =====");

        BPlusTreeNode current = root;

        while (!current.leaf && !current.children.isEmpty()) {
            current = current.children.get(0);
        }

        while (current != null) {

            for (String key : current.keys) {
                System.out.print(key + " | ");
            }

            current = current.next;
        }

        System.out.println();
    }
}