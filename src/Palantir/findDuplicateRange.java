
public int firstIndexOf(int[] nums, int start, int end, int target) {
	if (start <= end) {
		int mid = (start + end) / 2;
		if ((nums[mid] == target) && (mid == 0 || nums[mid-1] < target)) {
			return mid;
		}
		else if (nums[mid] < target) {
			return firstIndexOf(nums, start, mid-1, target);
		}
		else {
			return firstIndexOf(nums, mid+1, end, target);
		}
	}
	return -1;
}

public int lastIndexOf(int[] nums, int start, int end, int target) {
	if (start <= end) {
		int mid = (start + end) / 2;
		if ((nums[mid] == target) && (mid == nums.length-1 || nums[mid+1] > target)) {
			return mid;
		}
		else if (nums[mid] < target) {
			return lastIndexOf(nums, start, mid-1, target);
		}
		else {
			return lastIndexOf(nums, mid+1, end, target);
		}
	}
	return -1;
}

/*
Ex1: Array = {0,0,2,3,3,3,3,4,7,7,9} and Number = 3 --> Output = {3,6} 
Ex2: Array = {0,0,2,3,3,3,3,4,7,7,9} and Number = 5 --> Output = {-1,-1} 
*/
public static void main(String[] args) {
	int[] array = new int[]{0,0,2,3,3,3,3,4,7,7,9};
	int fi = firstIndexOf(array, 0, array.length-1, 3);
	int li = lastIndexOf(array, 0, array.length-1, 3);	
	System.out.println(new int[]{fi, li})
}