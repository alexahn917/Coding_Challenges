package facebook;

import java.util.regex.Pattern;

public class isPalindrom_ext {


	public static boolean isPalindrome(String s) {
		s.replaceAll("[^A-Za-z0-9]", "");
		s.replaceAll(" ", "");
		for (int i=0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "A man, a Cave, palinddrome:d";
		a = a.replaceAll("[^A-Za-z0-9]", "");
		System.out.println(a);
		p = Pattern.compile("A");
		m = p.find(a);
		System.out.println(m);
	}
}
