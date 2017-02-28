package facebook;

public class reverse_linkedlist {
	
	static class Node {
		int data;
		Node next;
		public Node(int val) {
			data = val;
		}
		
		public String toString() {
			return data + "";
		}
	}
	
	public static void printReverse(Node root) {
		if (root == null) return;
		printReverse(root.next);
		System.out.print(root + ", ");
	}
	
	public static void printReverseIter(Node root) {
		if (root == null) return;
		Node newHead = null;
		while (root != null) {
			Node root_next = root.next;
			root.next = newHead;
			newHead = root;
			root = root_next;
		}					
		while (newHead != null) {
			System.out.print(newHead.data + ", ");
			newHead = newHead.next;
		}	
	}
	
	public static void main(String[] args) {
		Node n = new Node(1);
		Node current = n;

		for (int i=2; i<11; i++) {
			Node newNode = new Node(i);
			current.next = newNode;
			current = newNode;
		}
		
		current = n;		
		while (current != null) {
			System.out.print(current + ", ");
			current = current.next;
		}
		System.out.println();
		printReverse(n);
		System.out.println();
		printReverseIter(n);
		
	}


}