package String;

public class permutations {
	
	
	public static void main(String[] args) {
		printPermutations("Hello");
	}
	
	public static void printPermutations(String str) {
		printPermutationsRecursive("", str);
	}
	
	public static void printPermutationsRecursive(String prefix, String str) {
		int n = str.length();
		if (n < 1) {
			System.out.println(prefix);
		}
		for (int i = 0; i < n; i++) {
			printPermutationsRecursive(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
		}
	}
}
