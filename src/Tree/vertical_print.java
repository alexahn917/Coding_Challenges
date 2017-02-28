package Tree;

import java.util.*;

public class vertical_print {
	private static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

    public static void tree2array(TreeNode root) {
        int tree_height = get_height(root);
        int size = (int) Math.pow(2.0, tree_height+1);
        System.out.println(size);
        int[] array = new int[size];
        fill_in(array, root, 1);
        for (int i=0; i<array.length; i++)
        	System.out.print(array[i] + ", ");
        	//        	System.out.println("index:" + i +" has " + array[i]);
		return;
    }
    
    public static void fill_in(int[] array, TreeNode root, int i) {
    	if (root == null || i >= array.length) {
    		return;
    	}
    	array[i] = root.val;
    	fill_in(array, root.left, 2*i);
    	fill_in(array, root.right, 2*i+1);
    }

    public static int get_height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left_h = get_height(root.left);
        int right_h = get_height(root.right);
        return 1 + Math.max(left_h, right_h);
    }

    public static List<List<Integer>> verticalPrint() {	
    	
    	return null;
    }
        
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.left.right.right = new TreeNode(2);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(5);	
		tree2array(root);
	}
	
}