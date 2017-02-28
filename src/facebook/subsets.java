package facebook;
import java.util.*;
public class subsets {
	public static void main(String[] args) {
		String a = "acbd";
//		Set<String> subsets = new HashSet<>();
		Set<String> subsets = new TreeSet<>();
//		List<String> subsets = new LinkedList<>();		
		generate_subsets("", a, subsets, 0);
		for (String s : subsets)
			System.out.print(s + ", ");
	}
	
	public static void generate_subsets(String prefix, String word, Set<String> subsets, int index) {
		for (int i=index; i < word.length(); i++) {
			subsets.add(prefix + word.charAt(i));
			generate_subsets(prefix + word.charAt(i), word, subsets, i+1);
		}
	}
}