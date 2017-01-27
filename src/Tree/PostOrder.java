package Tree;

public class PostOrder {
	void postOrder(Node root) {
	    // L, R, RT
	    /*
	    if (root == null) return;
	    postOrder(root.left);
	    postOrder(root.right);
	    System.out.print(root.data + " ");
	    */
	    if (root == null) {
	        return;
	    }
	    Stack<Node> st = new Stack<>();
	    st.push(root);
	    while (!st.isEmpty()) {
	        Node current = st.peek();
	        boolean isSubtreeRoot = (current.left == root || current.right == root);
	        boolean isLeaf = (current.left == null && current.left == null);
	        if (isSubtreeRoot || isLeaf) {
	            System.out.print(st.pop().data+" ");
	            root = current;
	        } else {
	            if (current.right != null)
	                st.push(current.right);
	            if (current.left != null)
	                st.push(current.left);
	        }
	    }
	}
}
