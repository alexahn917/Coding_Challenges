package facebook;

import java.util.*;

public class groupAnagrams {
	public static void main(String[] args) {
		String[] strs = new String[]{"ab", "ba", "ca"};
		List<List<String>> list = groupAnagrams(strs);
		for (List<String> l : list) {
			for (String s : l)
				System.out.print(s + ", ");
			System.out.println();
		}
	}

	// ab, ba, ca   <ab, ba>, <ca>
	public static List<List<String>> groupAnagrams(String[] list) {
		if (list.length <=1) return null;
		HashMap<String, List<String>> map = new HashMap<>();
		int n = list.length;

		for (int i=0; i < n; i++) {
			char[] chars = list[i].toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);

			// String key = sorted(list[i]);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(list[i]);
		}   

		List<List<String>> answer = new ArrayList<>();

		for (String key : map.keySet()) {
			answer.add(map.get(key));
		}

		return answer;
	}

}
