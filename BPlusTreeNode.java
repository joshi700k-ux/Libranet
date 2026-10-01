import java.util.ArrayList;
import java.util.List;

public class BPlusTreeNode {

    boolean leaf;

    List<String> keys;
    List<Book> books;

    List<BPlusTreeNode> children;

    BPlusTreeNode next;

    public BPlusTreeNode(boolean leaf) {

        this.leaf = leaf;

        keys = new ArrayList<>();
        books = new ArrayList<>();
        children = new ArrayList<>();

        next = null;
    }
}