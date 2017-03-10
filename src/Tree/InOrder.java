package Tree;

public class InOrder {
	void inOrder(Node root) {
	    if (root == null) return;
	    Stack<Node> st = new Stack<>();
	    Node p = root;
	    while (!st.isEmpty() || p != null) {
	        if (p != null) {
	            st.push(p);
	            p = p.left;
	        }
	        else {
	            Node curr = st.pop();
	            System.out.print(curr.data+" ");
	            p = curr.right;
	        }
	    }
	}
}
