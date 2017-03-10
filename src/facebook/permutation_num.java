package facebook;

import java.util.*;

public class permutation_num {

	public static void generate_permutations(String prefix, String postfix, List<String> perms) {
		if (postfix.length() < 1) {
			perms.add(prefix);
		}
		for (int i=0; i < postfix.length(); i++) {
			generate_permutations(prefix+postfix.charAt(i), 
					postfix.substring(0, i) + postfix.substring(i+1, postfix.length()),
					perms);
		}
	}

	public static void generate_subsets(String prefix, String str, int start) {
		System.out.print(prefix + ", ");
		for (int i=start; i < str.length(); i++) {
			generate_subsets(prefix + str.charAt(i), str, i+1);		
		}	
	}

	public static long get_just_smaller_int(long num) {
		String str = num + "";
		if (str.length() < 1) return (long)-1;
		char[] chars = str.toCharArray();
		int n = chars.length;
		int[] bucket = new int[10];
		int last = (chars[n-1] - '0');
		int swapped = -1;
		for (int i=n-2; i > 0; i--) {
			int current = (chars[i] - '0');
			if (current > last) {
				swapped = i+1;
				chars[i] = (char)(last + '0');
				bucket[current]++;
				break;
			}
			else {
				bucket[current]++;
			}
		}

		for (int j=9; j>0; j--) {
			while (bucket[j] != 0) {
				chars[swapped++] = (char)(j + '0');
				bucket[j]--;
			}
		}

		return Long.parseLong(new String(chars));  
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
		generate_subsets("","abc", 0);
	}
}
