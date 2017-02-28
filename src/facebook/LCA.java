package facebook;

public class LCA {
	
	public static void printOrder(Node root) {
		if (root == null) return;
		System.out.print(root.data+",");
		printOrder(root.left);
		printOrder(root.right);
	}
	
	public static Node LCA(Node node, Node n1, Node n2)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node == n1 || node == n2)
            return node;
        else {
	        // Look for keys in left and right subtrees
	        Node l = LCA(node.left, n1, n2);
	        Node r = LCA(node.right, n1, n2);
	 
	        // If both of the above calls return Non-NULL, then one key
	        // is present in once subtree and other is present in other,
	        // So this node is the LCA	        	        
	        if (l!=null && r!=null) {return node;}
	 
	        // Otherwise check if left subtree or right subtree is LCA
	        return (l != null) ? l : r;
        }
    }

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printOrder(root);
		System.out.println();
		System.out.println("LCA is: " +LCA(root, root.right.right, root.left.left).data);
	}
}
