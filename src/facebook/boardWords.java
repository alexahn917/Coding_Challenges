package facebook;
import java.util.*;

public class boardWords {
	public static void main(String[] args) {
		char[] first = new char[3];
		first[0] = 'a'; first[1] = 'b'; first[2] = 'c';
		char[] second = new char[3];		
		second[0] = 'a'; second[1] = 'b'; second[2] = 'c';
		HashSet<String> set = new HashSet<>();
		set.add("abc"); set.add("bb");
		char[][] matrix = new char[2][3];
		matrix[0] = first;
		matrix[1] = second;
		List<String> list = getWords(matrix, set);
	}
	
	public static List<String> getWords(char[][] matrix, HashSet<String> dict) {
		List<String> list = new ArrayList<>();
		if (matrix == null) {
			return list;
		}
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i=0; i < m; i++) {
			for (int j=0; j < n; j++) {
				DFSwords(matrix, i, j, list, dict, "");
			}
		}

		// if generated string is in dictionary, add to list;  
		return list;
	}

	public static void DFSwords(char[][] matrix, int row, int col, List<String> list, HashSet<String> dict, String potential_word) {
		// sanity check.
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) return;

		StringBuilder sb = new StringBuilder();
		sb.append(potential_word);
		sb.append(matrix[row][col]);

		String prefix = sb.toString();
		// if valid word, add it.
		if (dict.contains(sb.toString())) list.add(prefix);

		// DFS to neighbors
		DFSwords(matrix, row-1, col, list, dict, prefix);
		DFSwords(matrix, row, col-1, list, dict, prefix);
		DFSwords(matrix, row+1, col, list, dict, prefix);
		DFSwords(matrix, row, col+1, list, dict, prefix);  
	}
}
