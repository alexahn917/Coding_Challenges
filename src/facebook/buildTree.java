package facebook;

public class buildTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = helper(0, 0, inorder.length - 1, preorder, inorder);
		return root;
	}

	public static TreeNode helper(
		int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {

		if (preStart >= preorder.length || inStart > inEnd) {
			return null;
		}

		int val = preorder[preStart];
		TreeNode newNode = new TreeNode(val);

		int pivot = 0;

		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == val) {
				pivot = i;
				break;
			}
		}
		
		newNode.left = helper(preStart + 1, inStart, pivot - 1, preorder, inorder);
		newNode.right = helper(preStart + pivot + 1 - inStart, pivot + 1, inEnd, preorder, inorder);

		return newNode;
	}
}
