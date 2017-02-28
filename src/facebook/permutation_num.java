package facebook;

import java.util.*;

public class permutation_num {
	
	public static void generate_permutations(String prefix, String string, List<String> arr) {
		int n = string.length();

		if (string.length() < 1 ) {
			arr.add(prefix);
			//System.out.println(prefix);
		}
		for (int i=0; i<n; i++) {
			generate_permutations(prefix + string.charAt(i), string.substring(0, i) + string.substring(i+1, n), arr);
		}
	}
	
	public static int get_just_smaller_int(int number) {
		String num_str = number + "";
		List<String> perms = new ArrayList<>();
		generate_permutations("", num_str, perms);
		int smaller_max = Integer.MIN_VALUE;
		int check = 0;
		for (String i : perms) {
			check = Integer.parseInt(i);
			if (check < number && check > smaller_max)
				smaller_max = check;
		}
		return smaller_max;
	}
	
	public static int get_just_smaller_int_OPT(int number) {
		int[] bucket = new int[10];
		char[] num2chars = (number+"").toCharArray();
		int len = num2chars.length;
		
		int i = 0;
		int last = (int) (num2chars[len-1] - '0');
		int curr = 0;
		// change the last digit with one larger
		for (i = len-2; i > 0; i--) {
			curr = (int)(num2chars[i] - '0');
			if (curr > last) {
				num2chars[i] = (char) (last + '0');
				num2chars[len-1] = (char) (curr + '0');
				bucket[curr] += 1;
				break;
			}
			else {
				bucket[curr] += 1;
			}
		}
//		System.out.println(Integer.parseInt(new String(num2chars)));
		// sort the rest after change
		i++;
		for (int j = bucket.length-1; j > 0; j--) {
			while (bucket[j] != 0) {
				bucket[j] -= 1;
				num2chars[i] = (char)(j + '0');
				i++;
			}
		}		
		return Integer.parseInt(new String(num2chars));
	}
	
	
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		System.out.println(get_just_smaller_int(374718285));
		long e = System.currentTimeMillis();
		System.out.println("Elapsed Time: " + (e-s));
		s = System.currentTimeMillis();
		System.out.println(get_just_smaller_int_OPT(374718285));		
		System.out.println("Elapsed Time: " + (e-s));
	}
}
