package Array;


import java.util.HashMap;

/*
 * Function which returns a boolean indicating if there exists indices i, j in an array such that
 * abs(i-j) <= k, and
 * abs(A[i] - A[j]) <= t.
 */
public class nearDupInRange {

	public static boolean nearDupInRangeK(int[] nums, int k, int t) {
		if (k < 1 || t < 0) {
			return false;
		}
		
		HashMap<Long, Long> map = new HashMap<>();
		long bucket;
		long converted_num;
		
		for (int i = 0; i < nums.length; i++) {
			converted_num = (long) nums[i] + Integer.MAX_VALUE;
			bucket = converted_num / ((long) t+1);
			if (map.containsKey(bucket)) {
				return true;
			}
			if (map.containsKey(bucket-1) && (converted_num - map.get(bucket-1) <= t)) {
				return true;
			}
			if (map.containsKey(bucket+1) && (map.get(bucket+1) - converted_num <= t)) {
				return true;
			}
			if (i >= k) {
				long lastBucket = ((long) nums[i-k] + Integer.MAX_VALUE) / ((long) t+1);
				map.remove(lastBucket);
			}
			map.put(bucket, converted_num);
		}	
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2};
		System.out.println(nearDupInRangeK(array, 1, 1));		
	}

}
