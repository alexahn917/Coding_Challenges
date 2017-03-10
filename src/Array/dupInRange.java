package Array;

import java.util.HashSet;

/*
Given an array of values, design and code an algorithm 
that returns whether there are two duplicates within k indices of each other? 
k indices and within plus or minus l (value) of each other? 
Do all, even the latter, in O(n) running time and O(k) space.
*/

public class dupInRange {
	
	public static boolean dupInRangeK(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<>();
		for (int i=0; i<nums.length; i++) {
			if (i > k) {
				set.remove(nums[i-k-1]);
			}
//			if (set.contains(nums[i])) {
			if (set.contains(nums[i]) || set.contains(nums[i]-1) || set.contains(nums[i]+1)) {
				return true;
			}
			set.add(nums[i]);
		}		
		return false;
	}
	
	public static void main(String[] args) {
		int[] a1 = new int[]{1,3,5,7,9,2};
		System.out.println(dupInRangeK(a1,4));
	}
	
}