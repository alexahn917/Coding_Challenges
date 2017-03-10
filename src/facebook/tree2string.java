package facebook;

import java.util.*;
import java.math.*;

public class tree2string {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static int getHeight(TreeNode root) {
		if (root == null) return -1;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		System.out.println(getHeight(root));		
		
		
		int[] arr = new int[(int) Math.pow(2, getHeight(root)+1)];
		tree2arr(root, arr, 1);
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		
		TreeNode new_root = new TreeNode(arr[1]);
		
		arr2tree(new_root, arr, 1);
		
		System.out.println();
		
		LevelOrder(new_root);
	}
	
	public static void InOrder(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> st = new Stack<>();

		TreeNode p = root;
		while (p != null) {
			st.push(p);
			p = p.left;
		}
		
		while (!st.isEmpty()) {
			p = st.pop();
			System.out.print(p.val + ", ");			
			if (p.right != null) {
				p = p.right;
				while (p != null) {
					st.push(p);
					p = p.left;
				}
			}			
		}
	}
	
	public static void LevelOrder(TreeNode root) {
		if (root == null) return;		
		Queue<TreeNode> q = new LinkedList<>();		
		q.offer(root);
		TreeNode curr;
		while (!q.isEmpty()) {
			curr = q.poll();
			System.out.print(curr.val + ", ");
			if (curr.left != null) q.offer(curr.left);
			if (curr.right != null) q.offer(curr.right);			
		}		
	}
	
	
	public static void tree2arr(TreeNode root, int[] arr, int index) {
		if (root == null || index >= arr.length) return;		
		arr[index] = root.val;
		tree2arr(root.left, arr, index*2);
		tree2arr(root.right, arr, index*2+1);
	
	}
	public static void arr2tree(TreeNode root, int[] arr, int index) {
		if (index*2+1 >= arr.length) return;
		root.left = new TreeNode(arr[index*2]);
		root.right = new TreeNode(arr[index*2+1]);
		arr2tree(root.left, arr, index*2);
		arr2tree(root.right, arr, index*2+1);
	}
	
}