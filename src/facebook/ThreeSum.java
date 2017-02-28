package facebook;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		int[] array = new int[]{-1, 0, 1, 2, -1, -4};
		getThreeSum(array, 0);
		getTwoSum(array, -3);
		getTwoSumHash(array, -3);
	}
	
	public static void getThreeSum(int[] A, int target) {
		if (A.length < 3) {
			return;
		}		
		Arrays.sort(A);
		int lo, hi;
		int partial_sum = 0;
		List<List<Integer>> list = new ArrayList<>();

		for (int i=0; i < A.length-2; i++) {
			if (i == 0 || (i > 0 && A[i] != A[i-1])) {
				partial_sum = target - A[i];
				lo = i+1;
				hi = A.length-1;
				while (lo < hi) {
					if (A[lo] + A[hi] == partial_sum) {
						list.add(Arrays.asList(A[i], A[lo], A[hi]));
						while(lo < hi && A[lo] == A[lo+1]) lo++;
						while(lo < hi && A[hi] == A[hi-1]) hi--;
						lo++;
						hi--;
					}
					else if (A[lo] + A[hi] < partial_sum) lo++;
					else hi--;
				}
			}
		}

		printList(list);
	}
	
	public static void getTwoSum(int[] A, int target) {
		Arrays.sort(A);
		int lo = 0, hi = A.length-1;
		int sum = 0;
		List<List<Integer>> list = new ArrayList<>();
		while (lo < hi) {			
			// ignore duplicates
			while (lo != 0 && A[lo] == A[lo+1]) lo++;
			while (hi != A.length-1 && A[hi] == A[hi-1]) hi--;
			sum = A[lo] + A[hi];
			if (sum == target) {
				list.add(Arrays.asList(A[lo], A[hi]));
				lo++;
				hi--;
			}
			else if (sum < target) lo++;
			else hi--;
		}
		printList(list);		
	}
	
	
	public static void getTwoSumHash(int[] A, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<List<Integer>> list = new ArrayList<>();		
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(target - A[i])) {
				list.add(Arrays.asList(A[i], A[map.get(target - A[i])]));
			} else {
				map.put(A[i], i);
			}
		}
		printList(list);
	}
	
	public static void printList(List<List<Integer>> list) {
		for (List<Integer> i : list) {
			for (Integer num : i) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}
	}

}



