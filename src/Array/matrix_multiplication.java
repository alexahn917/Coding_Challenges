package Array;

public class matrix_multiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		int row_A = A.length, col_A = A[0].length, col_B = B[0].length;
		int[][] C = new int[row_A][col_B];

		for (int i=0; i < row_A; i++) {
			for (int j=0; j < col_A; j++) {
				if (A[i][j] != 0) {
					for (int k = 0; k < col_B; k++) {
						if (B[j][k] != 0) C[i][k] = A[i][j] * B[j][k];
					}
				}
			}
		}
		return C;
	}

	public int[][] multiplySparse(int[][] A, int[][] B) {
		int row_A = A.length, col_A = A[0].length, col_B = B[0].length;
		int[][] C = new int[row_A][col_B];

		for (int i=0; i < row_A; i++) {
			for (int j=0; j < col_A; j++) {
				if (A[i][j] != 0) {
					for (int k = 0; k < col_B; k++) {
						if (B[j][k] != 0) C[i][k] = A[i][j] * B[j][k];
					}
				}
			}
		}
		return C;
	}
	
}
