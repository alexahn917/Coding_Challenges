package facebook;
import java.util.*;

public class sparse_vector_dotprod {
	public static int[][] multiply(int[][] A, int[][] B) {
		if (A[0] == null || B[0] == null) return null;

		List<List<Integer>> sparse_A = new ArrayList<>();

		int aN = A.length;
		int aM = A[0].length;
		int bM = B[0].length;

		for (int i=0; i<aN; i++) {
			List<Integer> col = new ArrayList<>();
			for (int j=0; j < aM; j++) {
				if (A[i][j] != 0) {
					col.add(j);
				}
			}
			sparse_A.add(col);
		}

		int[][] C = new int[aN][bM];

		for (int i=0; i<aN; i++) {
			List<Integer> A_col = sparse_A.get(i);
			for (Integer col : A_col) {
				for (int k=0; k<bM; k++){
					if (B[col][k] != 0) {
						C[i][k] += A[i][col]*B[col][k];
					}
				}
			}
		}
		return C;
	}

	public static int[][] sol(int[][] A, int[][] B) {
		int A_row = A.length;
		int A_col = A[0].length;
		int B_col = B[0].length;

		int[][] ans = new int[A_row][B_col];

		for (int i = 0; i < A_row; i++) {
			for (int j = 0; j < A_col; j++) {
				if (A[i][j] != 0){
					for (int k = 0; k < B_col; k++) {
						if (B[j][k] != 0) {
							ans[i][k] += A[i][j] * B[j][k];
						}
					}
				}
			}
		}
		return ans;
	}
}
