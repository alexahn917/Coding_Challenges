package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
	public static void main(String[] args) {
		String a = "Hello";
		String b = "elHlo";
		System.out.println(isAnagram(a,b));
		System.out.println(isAnagramTable(a,b));
		List<String> anagramGroup = new ArrayList<>();
		generatePermutations(anagramGroup, "", a);
		for (String i : anagramGroup) {
			System.out.print(i + ", ");
		}
	}
	public static boolean isAnagram(String a, String b) {
		if (a.length() < 1 || b.length() < 1 || (a.length() != b.length()))
			return false;
		char[] arr_a = a.toCharArray();
		char[] arr_b = b.toCharArray();
		Arrays.sort(arr_a);
		Arrays.sort(arr_b);
		return (new String(arr_a).equals(new String(arr_b)));
	}
	
	public static boolean isAnagramTable(String a, String b) {
		if (a.length() < 1 || b.length() < 1) {
			return false;
		}
		
		if (a.length() != b.length()) {
			return false;
		}
		
		char[] char_table = new char[128];
		char[] arr_a = a.toCharArray();
		char[] arr_b = b.toCharArray();
		
		for (int i=0; i < arr_a.length; i++) {
			char_table[arr_a[i]]--;
		}
		for (int j=0; j < arr_b.length; j++) {
			char_table[arr_b[j]]--;
			if (char_table[arr_b[j]] < 0) {
				return false;
			}
		}	
		return true;
	}
	
	public static void generatePermutations(List<String> list, String prefix, String str) {
		if (str.length() < 1) {
			list.add(prefix);
		}
		for (int i=0; i < str.length(); i++) {
			generatePermutations(list, prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
		}
	}
	
}