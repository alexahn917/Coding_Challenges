package facebook;

import java.util.*;
public class tree_vertical_print {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) return list;
		Queue<TreeNode> node_q = new LinkedList<>();
		Queue<Integer> col_q = new LinkedList<>();
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		int min = 0, max = 0;

		node_q.offer(root);
		col_q.offer(0);

		while (!node_q.isEmpty()) {
			TreeNode curr = node_q.poll();
			int col = col_q.poll();

			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<>());
			}
			map.get(col).add(curr.val);

			if (curr.left != null) {
				node_q.offer(curr.left);
				col_q.offer(col-1);
				min = Math.min(min, col-1);
			}

			if (curr.right != null) {
				node_q.offer(curr.right);
				col_q.offer(col+1);
				max = Math.max(max, col+1);
			}
		}

		for (int i=min; i <= max; i++) {
			list.add(map.get(i));
		}

		return list;
	}
}
