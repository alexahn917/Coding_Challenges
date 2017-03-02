package facebook;

public class longest_seq_len {

	//Return the length of the longest sequence of increasing numbers in an unsorted array


	public static void main(String[] args) {
		int[] nums = new int[]{1,3,2,7,8,7,9,2,4};
		System.out.println(lsl(nums));
	}
	
	public static int lsl(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		
		int max = 0;
		int count = 1;
		for (int i=1; i<nums.length; i++) {
			if (nums[i-1] < nums[i]) {
				count++;
				max = Math.max(max, count);
			}
			else {
				count = 0;
			}
		}		
		return max;
	}
	
}
