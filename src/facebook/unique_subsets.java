package facebook;
import java.util.*;

public class unique_subsets {
	public static void main(String[] args) {
		String str = "abcd";
		
	}
    
	public static List<List<Integer>> int_subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    public static void helper(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
        list.add(new ArrayList(temp));
        for (int i=start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(list, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
        
    }
    
	public static void permutation(List<String> list, String prefix, String str) {
		if (str.length() < 1) {
			list.add(prefix);
		}
		
		for (int i=0; i<str.length(); i++) {
			permutation(list, prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
		}
	}
	
	public static void subsets(List<String> list, String prefix, String str, int index) {
		for (int i=index; i<str.length(); i++) {
			list.add(prefix + str.charAt(i));
			subsets(list, prefix + str.charAt(i), str, i+1);
		}
	}
	
	public static void subsets_hash(HashSet<String> set, String prefix, String str, int index) {
		for (int i=index; i<str.length(); i++) {
			set.add(prefix + str.charAt(i));
			subsets_hash(set, prefix + str.charAt(i), str, i+1);
		}
	}
	
	
	public static void sol(String s) {
	    Queue<String> q = new ArrayDeque<>();
	    Queue<Integer> pointer = new ArrayDeque<>();

	    //go through the string and add all single chars
	    for (int i = 0; i < s.length(); i++) {
	      String str = s.substring(i, i+1); // str.charAt(i+1) ?
	      //put in q and keep track of their index
	      q.add(str);
	      pointer.add(i);
	    }
	    
	    String ans = "";

	    while (!q.isEmpty()) {
	      String cur = q.poll();
	      int point = pointer.poll();
	      
	      for (int j = point + 1; j < s.length(); j++) {
	        String str = cur + s.substring(j, j+1);
	        q.add(str);
	        pointer.add(j);
	      }
	      
	      ans = ans + cur + " ";
	    }
	    
	    System.out.println(ans);
	  }
}