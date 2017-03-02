package facebook;

public class EditDistance {

	public static void main(String[] args) {
		String a = "Hello";
		String b = "olleH";
		System.out.println(minOps(a,b,a.length(), b.length()));
		System.out.println(minOpsOPT(a,b,a.length(), b.length()));
	}
	
	public static int minOps(String s1, String s2, int n, int m) {
		if (n == 0) return m;

		else if (m == 0) return n;

		else if (s1.charAt(n-1) == s2.charAt(m-1)) {
			return minOps(s1,s2,n-1,m-1);
		}
		
		else {
			return 1 + minOfThree(minOps(s1,s2, n-1, m-1),
							minOps(s1,s2,n,m-1),
							minOps(s1,s2,n-1,m-1));
		}
	}

	public static int minOpsOPT(String s1, String s2, int n, int m) {
		int[][] dp = new int[n+1][m+1];
		
		for (int i=0; i<=n; i++){
			for (int j=0; j<=m; j++) {
				
				if (i == 0) dp[i][j] = j;
				
				else if (j == 0) dp[i][j] = i;				
				
				else if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				
				else {
					dp[i][j] = 1 + minOfThree(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
				}				
			}			
		}
		
		return dp[n][m];
	}
	
	public static int minOfThree(int i, int j, int k) {
		return Math.min(Math.min(i, j),k);
	}
}
