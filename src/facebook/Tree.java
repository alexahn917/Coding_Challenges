package facebook;

import java.util.*;

public class Tree {
	Node root;
	
	public Tree() {
		root = null;
	}
	
	class Node {
		int data;
		Node left;
		Node right;
		public Node(int val) {
			data = val;
		}
	}
	
	public void insert(int n) {
		Node newNode = new Node(n);
		if (root == null) root = newNode;
		else {
			Node curr = root;
			while (curr!=null) {
				if (curr.data < n) {
					if (curr.right == null) {
						curr.right = newNode;
						break;
					}					
					curr = curr.right;
				}
				else if (curr.data > n) {
					if (curr.left == null) {
						curr.left = newNode;
						break;
					}
					curr = curr.left;
				}
				else {
					curr.data = n;
					break;
				}
			}			
		}
	}
	
	public int getHeight() {
		return height(root);
	}
	
	public int height(Node root) {
		if (root == null) return -1;
		return 1+ Math.max(height(root.left), height(root.right));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Queue<Node> q = new LinkedList<>();
		Node curr;
		q.add(root);
		while (!q.isEmpty()) {
			curr = q.poll();
			sb.append(curr.data + "");
			if (curr.left != null) q.add(curr.left);
			if (curr.right != null) q.add(curr.right);
		}		
		return sb.toString();
	}
	
}