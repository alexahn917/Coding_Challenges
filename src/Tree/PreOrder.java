package Tree;

import java.util.Stack;

import com.sun.org.apache.bcel.internal.classfile.Node;

public class PreOrder {
	void preOrder(Node root) {
	    // Rt, L, R
	    /*
	    if (root == null) return;
	    System.out.print(root.data + " ");
	    postOrStack<E>oot.left);
	    postOrder(root.right);
	    */
	    if (root == null) return;
		Stack<Node> st = new Stack<>();
	    st.push(root);
	    Node current;
	    while (!st.isEmpty()) {
	    	current = st.pop();
	    	System.out.print(current.data + " ");
	        if (current.right != null)
	        	st.push(current.right);
	        if (current.left != null)
	        	st.push(current.left);
	    }
	}

}
