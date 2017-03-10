package facebook;

import java.util.*;
import facebook.tree2string.TreeNode;

public class In_Pre2tree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		int[] in = new int[]{2,1,4,3};
		int[] pre = new int[]{1,2,3,4};
		TreeNode root = arr2tree(in, pre, 0, in.length-1, 0);
		inOrderRec(root);
	}
	
	public static void inOrderRec(TreeNode root) {
		if (root == null) return;
		inOrderRec(root.left);
		System.out.print(root.val + ", ");
		inOrderRec(root.right);
	}
	
	public static void inOrder(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> st = new Stack<>();
		TreeNode p = root;
		
		while (p!=null) {
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
					p=p.left;
				}
			}
		}
		
	}
	
	public static TreeNode arr2tree(int[] in, int[] pre, int in_start, int in_end, int root_at_pre) {
		if (in_start > in_end) return null;
		if (root_at_pre > pre.length-1) return null;
		TreeNode root = new TreeNode(pre[root_at_pre]);
		
		int root_at_in = in_start;
		for (int i = in_start; i < in_end; i++) {
			if (in[i] == pre[root_at_pre])
				root_at_in = i;
		}
		
		int left_size = root_at_in - in_start;
				
		root.left = arr2tree(in, pre, in_start, root_at_in-1, root_at_pre + 1);
		root.right = arr2tree(in, pre, root_at_in + 1, in_end, root_at_pre + 1 + left_size);
		
		return root;
	}
	
}
