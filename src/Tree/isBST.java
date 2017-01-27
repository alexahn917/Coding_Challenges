package Tree;

public class isBST {
	
    class Node {
        int data;
        Node left;
        Node right;
     }

    static boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

}