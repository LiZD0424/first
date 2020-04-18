import java.util.ArrayList;
import java.util.Scanner;

public class theShortestPath {
    public static void main(String[] args) {
        TreeNode root = create();
        dfs(root);
    }

    public static TreeNode create() {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        TreeNode node;
        if (value != -1) {
            node = new TreeNode(value);
            node.left = create();
            node.right = create();
        } else {
            node = null;
        }
        return node;
    }

    public static void dfs(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            dfs(treeNode.left);
            dfs(treeNode.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}