package facebook;

import java.util.*;

public class add_large_number {
	
	public static void add_num(String num_1, String num_2) {
		char[] num_1_arr = num_1.toCharArray();
		char[] num_2_arr = num_2.toCharArray();
		
		int i = num_1_arr.length-1,j = num_2_arr.length-1;

		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		int carry = 0;
		int digit = 0;

		while (i >= 0 || j >= 0) {
			if (i < 0) {
				sum = (int)(num_2_arr[j] - '0');
			}
			else if (j < 0) {
				sum = (int)(num_1_arr[i] - '0');
			}	
			else {
				sum = (int)(num_1_arr[i] -'0' + num_2_arr[j] - '0');
			}
			digit = sum + carry;
			if (digit >= 10) {
				sb.insert(0,digit%10+"");
				carry = 1;
			}
			else {
				sb.insert(0,digit+"");
				carry = 0;
			}
			i--;
			j--;
		}
		System.out.println(sb.toString());
	}
		
	public static void main(String[] args) {
		long a = 2345234;
		long b = 399266;
		add_num(a+"",b+"");
		System.out.println(a+b);
	}
}
